package net.madvirus.spring4.chap14.domain;

import org.springframework.data.repository.Repository;

public interface PersonRepository extends Repository<Person, Long> {
	public Person save(Person person);
}
