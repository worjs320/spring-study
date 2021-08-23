package net.madvirus.spring4.chap11.guest.jdbc;

import net.madvirus.spring4.chap11.guest.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRowMapper implements RowMapper<Person> {

	@Override
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		Person p = new Person();
		p.setNum(rs.getInt("num"));
		p.setName(rs.getString("name"));
		p.setAge(rs.getInt("age"));
		p.setBirth(rs.getTimestamp("birth"));
		p.setGender(rs.getString("gender"));
		return p;
	}

}
