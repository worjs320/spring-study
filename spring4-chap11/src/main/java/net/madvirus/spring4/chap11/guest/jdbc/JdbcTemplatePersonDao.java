package net.madvirus.spring4.chap11.guest.jdbc;

import net.madvirus.spring4.chap11.guest.Message;
import net.madvirus.spring4.chap11.guest.MessageDao;
import net.madvirus.spring4.chap11.guest.Person;
import net.madvirus.spring4.chap11.guest.PersonDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class JdbcTemplatePersonDao implements PersonDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplatePersonDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<Person> personRowMapper = new PersonRowMapper();

    @Override
    public List<Person> select(int start, int size) {
        List<Person> persons = jdbcTemplate.query(
                "select * from person order by num desc limit ?, ?",
                new Object[]{start, size},
				personRowMapper
        );
        return persons;
    }

    @Override
    public int counts() {
        return jdbcTemplate.queryForObject("select count(*) from person", Integer.class);
    }

    @Override
    public int insert(final Person person) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn)
                    throws SQLException {
                PreparedStatement pstmt = conn
                        .prepareStatement(
                                "insert into person (name, gender, age, birth) values (?,?,?,?)",
                                new String[]{"num"});
				pstmt.setString(1, person.getName());
				pstmt.setString(2, person.getGender());
				pstmt.setInt(3, person.getAge());
				pstmt.setTimestamp(4, new Timestamp(person.getBirth().getTime()));
                return pstmt;
            }
        }, keyHolder);
        Number idNum = keyHolder.getKey();
        return idNum.intValue();
    }

    @Override
    public int delete(int num) {
        return jdbcTemplate.update("delete from person where num = ?", num);
    }

}
