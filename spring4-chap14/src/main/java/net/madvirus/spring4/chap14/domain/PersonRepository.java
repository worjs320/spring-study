package net.madvirus.spring4.chap14.domain;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PersonRepository extends Repository<Person, Long> {
	public Person save(Person person);

	@Transactional
	@Modifying(flushAutomatically = true)
	@Query("UPDATE Person p SET p.name = :newName WHERE p.name = :prevName")
	public void updatePersonsName(@Param("prevName") String pervName, @Param("newName") String newName);
}
