package net.madvirus.spring4.chap13.store.dao;

import net.madvirus.spring4.chap13.store.model.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface SavePersonDao {
	void save(Person person);
}
