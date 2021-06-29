package net.madvirus.spring4.chap04.config;

import net.madvirus.spring4.chap04.ConnectionProvider;
import net.madvirus.spring4.chap04.JdbcConnectionProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

@Configuration
@PropertySources(@PropertySource("classpath:/jgkim.properties"))
public class ConfigByEnv {

	@Autowired
	private Environment env;

	@Bean(initMethod = "init")
	public ConnectionProvider connectionProvider() {
		JdbcConnectionProvider connectionProvider = new JdbcConnectionProvider();
		connectionProvider.setDriver(env.getProperty("jgkim.driver"));
		connectionProvider.setUrl(env.getProperty("jgkim.jdbcUrl"));
		connectionProvider.setUser(env.getProperty("jgkim.user"));
		connectionProvider.setPassword(env.getProperty("jgkim.password"));
		return connectionProvider;
	}
}
