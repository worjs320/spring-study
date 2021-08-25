package net.madvirus.spring4.chap11.guest.jdbc;

import net.madvirus.spring4.chap11.guest.Person;
import net.madvirus.spring4.chap11.guest.PersonDao;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.List;

public class SimpleInsertPersonDao implements PersonDao {

    private PersonDao delegate;
    private SimpleJdbcInsert simpleInsert;

    public SimpleInsertPersonDao(DataSource dataSource) {
        simpleInsert = new SimpleJdbcInsert(dataSource);
        simpleInsert.withTableName("person")
				.usingColumns("name", "gender", "age", "birth")
				.setGeneratedKeyName("num");

        delegate = new JdbcTemplatePersonDao(dataSource);
    }

    @Override
    public int insert(Person person) {
		/*
		Map<String, Object> values = new HashMap<>();
		values.put("NAME", message.getName());
		values.put("message", message.getMessage());
		values.put("creationTime", new Timestamp(message.getCreationTime().getTime()));
		Number genKey = simpleInsert.executeAndReturnKey(values);
		*/
        BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(person);
        Number genKey = simpleInsert.executeAndReturnKey(paramSource);
        return genKey.intValue();
    }

    public List<Person> select(int start, int size) {
        return delegate.select(start, size);
    }

    public int counts() {
        return delegate.counts();
    }

    public int delete(int id) {
        return delegate.delete(id);
    }

}
