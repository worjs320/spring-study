package net.madvirus.spring4.chap13.main;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import net.madvirus.spring4.chap13.store.domain.*;
import net.madvirus.spring4.chap13.store.persistence.HibernateCallHistoryRepository;
import net.madvirus.spring4.chap13.store.persistence.HibernatePersonRepository;
import net.madvirus.spring4.chap13.store.service.PersonCallService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class JavaConfigAnnotationMappingPerson {

	@Bean
	public DataSource dataSource() {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		try {
			ds.setDriverClass("org.h2.Driver");
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
		ds.setJdbcUrl("jdbc:h2:tcp://localhost/~/hibernate");
		ds.setUser("admin");
		ds.setPassword("admin");
		return ds;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		HibernateTransactionManager txMgr = new HibernateTransactionManager();
		txMgr.setSessionFactory(sessionFactoryBean().getObject());
		return txMgr;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactoryBean() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setAnnotatedClasses(Person.class, CallHistory.class);
		Properties prop = new Properties();
		prop.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		sessionFactoryBean.setHibernateProperties(prop);
		return sessionFactoryBean;
	}

	@Bean
	public PersonCallService personCallService() {
		PersonCallService personCallService = new PersonCallService();
		personCallService.setPersonRepository(personRepository());
		personCallService.setCallHistoryRepository(callHistoryRepository());
		return personCallService;
	}

	@Bean
	public PersonRepository personRepository() {
		HibernatePersonRepository personRepository = new HibernatePersonRepository();
		personRepository.setSessionFactory(sessionFactoryBean().getObject());
		return personRepository;
	}

	@Bean
	public CallHistoryRepository callHistoryRepository() {
		HibernateCallHistoryRepository callHistoryRepository = new HibernateCallHistoryRepository();
		callHistoryRepository.setSessionFactory(sessionFactoryBean().getObject());
		return callHistoryRepository;
	}

}