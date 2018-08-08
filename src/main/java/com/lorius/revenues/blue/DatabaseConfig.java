package com.lorius.revenues.blue;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Flavio Santos
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories( basePackages = {"com.lorius.revenues.blue.repository"}, entityManagerFactoryRef = "userEntityManager", transactionManagerRef = "userTransactionManager")
public class DatabaseConfig {

	@Value("${jdbc.driver}")
	private String driver;

	@Value("${jdbc.user}")
	private String username;

	@Value("${jdbc.password}")
	private String password;

	@Value("${jdbc.url}")
	private String url;

	@Value("${hibernate.dialect}")
	private String hibernateDialect;

	@Value("${hibernate.globally_quoted_identifiers}")
	private String hibernateGlobally_quoted_identifiers;

	@Value("${hibernate.hbm2ddl.auto}")
	private String hibernateHbm2ddlAuto;

	// @Bean
	// public LocalSessionFactoryBean sessionFactory() {
	// LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	// sessionFactory.setDataSource(dataSource());
	// sessionFactory.setPackagesToScan(new String[] { "com.lorius.dashboard.entity"
	// });
	// sessionFactory.setHibernateProperties(hibernateProperties());
	//
	// return sessionFactory;
	// }

	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean userEntityManager() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "com.lorius.revenues.blue.entity" });

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaPropertyMap(hibernateProperties());

		return em;
	}

	@Primary
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName(driver);
		driverManagerDataSource.setUrl(url);
		driverManagerDataSource.setUsername(username);
		driverManagerDataSource.setPassword(password);

		return driverManagerDataSource;
	}

	@Primary
	@Bean
	public PlatformTransactionManager userTransactionManager() {

		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(userEntityManager().getObject());
		return transactionManager;
	}

	// @Bean
	// @Autowired
	// public HibernateTransactionManager transactionManager(SessionFactory
	// sessionFactory) {
	//
	// HibernateTransactionManager txManager = new HibernateTransactionManager();
	// txManager.setSessionFactory(sessionFactory);
	//
	// return txManager;
	// }

	private final HashMap<String, Object> hibernateProperties() {
		// return new Properties() {
		// {
		// setProperty("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
		// setProperty("hibernate.dialect", hibernateDialect);
		// setProperty("hibernate.globally_quoted_identifiers",
		// hibernateGlobally_quoted_identifiers);
		// setProperty("hibernate.format_sql", "true");
		// setProperty("hibernate.show_sql", "true");
		// }
		// };
		HashMap<String, Object> properties = new HashMap<String, Object>();
		properties.put("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
		properties.put("hibernate.dialect", hibernateDialect);
		properties.put("hibernate.globally_quoted_identifiers", hibernateGlobally_quoted_identifiers);
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.show_sql", "true");
		return properties;
	}
}
