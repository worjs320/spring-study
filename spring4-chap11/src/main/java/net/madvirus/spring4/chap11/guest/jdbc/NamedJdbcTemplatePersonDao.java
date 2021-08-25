package net.madvirus.spring4.chap11.guest.jdbc;

import net.madvirus.spring4.chap11.guest.Person;
import net.madvirus.spring4.chap11.guest.PersonDao;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NamedJdbcTemplatePersonDao implements PersonDao {

    private NamedParameterJdbcTemplate template;

    public NamedJdbcTemplatePersonDao(DataSource dataSource) {
        this.template = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<Person> select(int start, int size) {
        Map<String, Object> params = new HashMap<>();
        params.put("start", start);
        params.put("size", size);
        List<Person> persons = template.query(
                "select * from person order by num desc limit :start, :size",
                params,
                new PersonRowMapper()
        );
        return persons;
    }

    @Override
    public int counts() {
        return template.queryForObject("select count(*)from person", Collections.<String, Object>emptyMap(), Integer.class);
    }

    @Override
    public int insert(Person person) {
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(person);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update("insert into person (name, gender, age, birth) values (:name, :gender, :age, :birth)", paramSource, keyHolder);
        Number idNum = keyHolder.getKey();
        return idNum.intValue();
    }

    @Override
    public int delete(int num) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("num", num);
        return template.update("delete from person where num = :num", paramSource);
    }

}
