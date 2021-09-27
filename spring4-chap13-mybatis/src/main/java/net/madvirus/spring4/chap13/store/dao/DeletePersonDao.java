package net.madvirus.spring4.chap13.store.dao;

import net.madvirus.spring4.chap13.store.model.Person;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Repository;

@Repository
public interface DeletePersonDao {
	@Delete("delete from person where name = #{name}")
	void delete(Person person);
}
