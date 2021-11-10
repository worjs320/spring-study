package net.madvirus.spring4.chap15.conf;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import net.madvirus.spring4.chap15.member.application.ChangePasswordService;
import net.madvirus.spring4.chap15.member.application.ChangePasswordServiceImpl;
import net.madvirus.spring4.chap15.member.application.NewMemberRegService;
import net.madvirus.spring4.chap15.member.application.NewMemberRegServiceImpl;
import net.madvirus.spring4.chap15.member.web.DataLoader;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "net.madvirus.spring4.chap15.member.domain")
public class SpringAppConfig {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		try {
			ds.setDriverClassName("org.h2.Driver");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		ds.setUrl("jdbc:h2:tcp://localhost/~/chap15-2");
		ds.setUsername("admin");
		ds.setPassword("admin");
		return ds;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager tm = new JpaTransactionManager();
		tm.setEntityManagerFactory(emf);
		return tm;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		emf.setPackagesToScan("net.madvirus.spring4.chap15.member.domain");
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.H2);
		adapter.setShowSql(true);
		emf.setJpaVendorAdapter(adapter);

		HashMap<String, Object> map = new HashMap<>();
		map.put("hibernate.hbm2ddl.auto", "create-drop");
		map.put("hibernate.format_sql", "true");
		emf.setJpaPropertyMap(map);
		return emf;
	}

	@Bean
	public ChangePasswordService changePasswordService() {
		ChangePasswordServiceImpl service = new ChangePasswordServiceImpl();
		return service;
	}

	@Bean
	public NewMemberRegService newMemberRegService() {
		return new NewMemberRegServiceImpl();
	}

	@Bean
	public DataLoader dataLoader() {
		DataLoader dataLoader = new DataLoader();
		return dataLoader;
	}

}
