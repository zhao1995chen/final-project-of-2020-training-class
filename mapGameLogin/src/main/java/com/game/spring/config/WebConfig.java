package com.game.spring.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.game.spring.dao" })
@ComponentScan(basePackages = { "com.game.spring", "com.game.spring.service", "com.game.spring.service.impl",
		"com.game.spring.component" })
public class WebConfig implements WebMvcConfigurer {

	private static final Logger log = LoggerFactory.getLogger(WebConfig.class);

	/**
	 * add resource location
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/test/**").addResourceLocations("/test/");
	}

	/**
	 * dispatcher enable
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	/**
	 * setup connection pool
	 * 
	 * @return
	 */

	@Bean
	public DataSource getDataSource() {
		BasicDataSource dbs = new BasicDataSource();
		try {
			dbs.setDriverClassName("com.mysql.cj.jdbc.Driver");
			dbs.setUrl(
					"jdbc:mysql://localhost:3306/mapgame?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC");
			dbs.setUsername("root");
			dbs.setPassword("1234");
			dbs.setMaxTotal(100);
			dbs.setMaxIdle(1);

		} catch (Exception e) {
			log.error("datasource init error!!", e);
		}
		return dbs;
	}

	/**
	 * get db configuration
	 * 
	 * @return
	 */
	private Properties additionalProperties() {
		Properties properties = new Properties();
		try {
			properties.setProperty("hibernate.hbm2ddl.auto", "validate");
			properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
			properties.setProperty("hibernate.current_session_context_class", "thread");
			properties.setProperty("hibernate.show_sql", "false");
			// properties.put("hibernate.ejb.interceptor", auditInterceptor);
		} catch (Exception e) {
			log.error("get db initial data error!!", e);
		}
		return properties;
	}

	/**
	 * get factory of entitymanager
	 * 
	 * @param dataSource
	 * @param env
	 * @return
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(getDataSource());
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactoryBean.setPackagesToScan("com.game.spring.entity");
		entityManagerFactoryBean.setJpaProperties(additionalProperties());
		return entityManagerFactoryBean;
	}

	/**
	 * get manager of transaction
	 * 
	 * @param entityManagerFactory
	 * @return
	 */
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}

}
