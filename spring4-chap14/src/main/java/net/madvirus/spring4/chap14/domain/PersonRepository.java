package net.madvirus.spring4.chap14.domain;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface PersonRepository extends Repository<Person, Long> {
	Person save(Person person);

	@Modifying(flushAutomatically = true)
	@Query("UPDATE Person p SET p.name = :newName WHERE p.name = :prevName")
	void updatePersonsName(@Param("prevName") String pervName, @Param("newName") String newName);

	void deleteByName(String name);

	List<Person> findAll();

	List<Person> findAll(Sort sort);

	List<Person> findAll(Pageable pageable);
}
