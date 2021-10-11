package net.madvirus.spring4.chap15.conf;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import net.madvirus.spring4.chap15.hr.dao.EmployeeDao;
import net.madvirus.spring4.chap15.hr.dao.JdbcEmployeeDao;
import net.madvirus.spring4.chap15.hr.service.EmployeeRegistryService;
import net.madvirus.spring4.chap15.hr.service.EmployeeRegistryServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
public class SpringAppConfig {

	@Bean
	public PersistenceExceptionTranslationPostProcessor postProcessor() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		try {
			ds.setDriverClass("org.h2.Driver");
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
		ds.setJdbcUrl("jdbc:h2:tcp://localhost/~/chap15");
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
	public EmployeeDao employeeDao() {
		return new JdbcEmployeeDao(dataSource());
	}

	@Bean
	public EmployeeRegistryService employeeRegistryService() {
		EmployeeRegistryServiceImpl regService = new EmployeeRegistryServiceImpl();
		regService.setEmpDao(employeeDao());
		return regService;
	}

}
