package net.madvirus.spring4.chap11.guest.jdbc;

import net.madvirus.spring4.chap11.guest.Person;
import net.madvirus.spring4.chap11.guest.PersonDao;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
import org.springframework.jdbc.support.SQLExceptionTranslator;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JdbcPersonDao implements PersonDao {

    private DataSource dataSource;
    private SQLExceptionTranslator exceptionTranslator;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.exceptionTranslator = new SQLErrorCodeSQLExceptionTranslator(dataSource);
    }

    @Override
    public List<Person> select(int start, int size) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from person order by num desc limit ?, ?";
        try {
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, start);
            pstmt.setInt(2, size);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                List<Person> persons = new ArrayList<>();
                do {
                    Person person = new Person();
					person.setNum(rs.getInt("num"));
					person.setName(rs.getString("name"));
					person.setGender(rs.getString("gender"));
					person.setAge(rs.getInt("age"));
					person.setBirth(rs.getTime("birth"));
					persons.add(person);
                } while (rs.next());
                return persons;
            } else {
                return Collections.emptyList();
            }
        } catch (SQLException ex) {
            throw exceptionTranslator.translate("select", sql, ex);
        } finally {
            JdbcUtils.closeResultSet(rs);
            JdbcUtils.closeStatement(pstmt);
            JdbcUtils.closeConnection(conn);
        }
    }

    @Override
    public int counts() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "select count(*) from person";
        try {
            conn = dataSource.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        } catch (SQLException ex) {
            throw exceptionTranslator.translate("counts", sql, ex);
        } finally {
            JdbcUtils.closeResultSet(rs);
            JdbcUtils.closeStatement(stmt);
            JdbcUtils.closeConnection(conn);
        }
    }

    @Override
    public int insert(Person person) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "insert into person (name, gender, age, birth) values (?,?,?,?)";
        try {
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, person.getName());
            pstmt.setString(2, person.getGender());
            pstmt.setInt(3, person.getAge());
            pstmt.setTimestamp(4, new Timestamp(person.getBirth().getTime()));
            int insertedCount = pstmt.executeUpdate();
            if (insertedCount > 0) {
                stmt = conn.createStatement();
                rs = stmt.executeQuery("select SCOPE_IDENTITY() from person");
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
            return -1;
        } catch (SQLException ex) {
            throw exceptionTranslator.translate("insert", sql, ex);
        } finally {
            JdbcUtils.closeResultSet(rs);
            JdbcUtils.closeStatement(stmt);
            JdbcUtils.closeStatement(pstmt);
            JdbcUtils.closeConnection(conn);
        }
    }

    @Override
    public int delete(int num) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "delete from person where num = ?";
        try {
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, num);
            return pstmt.executeUpdate();
        } catch (SQLException ex) {
            throw exceptionTranslator.translate("delete", sql, ex);
        } finally {
            JdbcUtils.closeStatement(pstmt);
            JdbcUtils.closeConnection(conn);
        }
    }

}
