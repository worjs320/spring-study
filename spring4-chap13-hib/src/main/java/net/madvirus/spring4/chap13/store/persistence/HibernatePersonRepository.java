package net.madvirus.spring4.chap13.store.persistence;

import net.madvirus.spring4.chap13.store.domain.Person;
import net.madvirus.spring4.chap13.store.domain.PersonRepository;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class HibernatePersonRepository implements PersonRepository {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Person findById(Integer id) {
		Person person = (Person) sessionFactory.getCurrentSession().get(Person.class, id);
		return person;
	}

}
