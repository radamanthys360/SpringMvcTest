package com.springdemo.db.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = {"com.springdemo.db.repository"})
@PropertySource("classpath:/com/springdemo/properties/db.properties")
@EnableTransactionManagement
public class JpaConfig {
	
    @Autowired
    Environment env;
	
	public JpaConfig() {
		super();
	}
	
	@Bean
	public DataSource dataSource() {
	 final DriverManagerDataSource dataSource = new DriverManagerDataSource();
	 dataSource.setDriverClassName(env.getProperty("jdbc.driver"));
	 dataSource.setUrl(env.getProperty("jdbc.url"));
	 dataSource.setUsername(env.getProperty("jdbc.username"));
	 dataSource.setPassword(env.getProperty("jdbc.clave"));
	 return dataSource;
	}
	
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPackagesToScan(new String[] {
            "com.springdemo.db.entity"
        });

        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
        entityManagerFactoryBean.setJpaProperties(additionalProperties());

        return entityManagerFactoryBean;
    }
    
    final Properties additionalProperties() {
        final Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(env.getProperty("hibernate.show_sql"), env.getProperty("hibernate.show_sql.flag"));
        hibernateProperties.setProperty(env.getProperty("hibernate.format_sql"), env.getProperty("hibernate.format_sql.flag"));
        return hibernateProperties;
    }
     
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
    
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
    
}