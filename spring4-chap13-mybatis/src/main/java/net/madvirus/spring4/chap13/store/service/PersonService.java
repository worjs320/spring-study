package net.madvirus.spring4.chap13.store.service;

import net.madvirus.spring4.chap13.store.dao.DeletePersonDao;
import net.madvirus.spring4.chap13.store.dao.MyBatisPersonDao;
import net.madvirus.spring4.chap13.store.dao.SavePersonDao;
import net.madvirus.spring4.chap13.store.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class PersonService {
	@Autowired
	private MyBatisPersonDao personDao;

	@Autowired
	private SavePersonDao savePersonDao;

	@Autowired
	private DeletePersonDao deletePersonDao;

	public void setPersonDao(MyBatisPersonDao personDao) {
		this.personDao = personDao;
	}

	@Transactional
	public List<Person> getPersonListAll() {
		return personDao.findAll();
	}

	@Transactional
	public void insertPerson(Person person) {
		savePersonDao.save(person);
	}

	@Transactional
	public void deletePerson(Person person) {
		deletePersonDao.delete(person);
	}

}
