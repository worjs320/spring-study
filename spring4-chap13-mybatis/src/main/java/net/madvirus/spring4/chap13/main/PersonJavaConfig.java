package net.madvirus.spring4.chap13.main;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import net.madvirus.spring4.chap13.store.dao.*;
import net.madvirus.spring4.chap13.store.service.PersonService;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@EnableTransactionManagement
public class PersonJavaConfig {

	@Bean
	public PersistenceExceptionTranslationPostProcessor postProcessor() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	@Bean(destroyMethod = "getLogWriter")
	public DataSource dataSource() {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		try {
			ds.setDriverClass("org.h2.Driver");
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
		ds.setJdbcUrl("jdbc:h2:tcp://localhost/~/person");
		ds.setUser("admin");
		ds.setPassword("admin");
		return ds;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager tm = new DataSourceTransactionManager();
		tm.setDataSource(dataSource());
		return tm;
	}

	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource());
		Resource[] mapperLocations = new Resource[1];
		mapperLocations[0] = new ClassPathResource("/mybatis/persondao.xml");
		factoryBean.setMapperLocations(mapperLocations);
		return factoryBean;
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate() throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory().getObject());
	}

	@Bean
	public MyBatisPersonDao personDao() throws Exception {
		MyBatisPersonDao personDao = new MyBatisPersonDao();
		personDao.setSqlSession(sqlSessionTemplate());
		return personDao;
	}

	@Bean
	public PersonService personService() throws Exception {
		PersonService personService = new PersonService();
		personService.setPersonDao(personDao());
		return personService;
	}
}
