package com.premsh.jpaexperiment.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "channelEntityManagerFactory", transactionManagerRef = "channelTransactionManager", basePackages = {
		"com.premsh.jpaexperiment.data.channelbase.repository" })

public class ChannelBaseDatasourceConfiguration {

	@Primary
	@Bean(name = "channelDataSourceProperties")
	@ConfigurationProperties("channel.datasource")
	public DataSourceProperties channelDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Primary
	@Bean(name = "channelDataSource")
	@ConfigurationProperties("channel.datasource.configuration")
	public DataSource channelDataSource(
			@Qualifier("channelDataSourceProperties") DataSourceProperties channelDataSourceProperties) {
		return channelDataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}

	@Primary
	@Bean(name = "channelEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean channelEntityManagerFactory(
			EntityManagerFactoryBuilder channelEntityManagerFactoryBuilder,
			@Qualifier("channelDataSource") DataSource channelDataSource) {

		Map<String, String> channelJpaProperties = new HashMap<>();
		channelJpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		channelJpaProperties.put("hibernate.hbm2ddl.auto", "update");

		return channelEntityManagerFactoryBuilder.dataSource(channelDataSource)
				.packages("com.premsh.jpaexperiment.data.channelbase.models")
				.persistenceUnit("channelDataSource")
				.properties(channelJpaProperties)
				.build();
	}

	@Primary
	@Bean(name = "channelTransactionManager")
	public PlatformTransactionManager channelTransactionManager(
			@Qualifier("channelEntityManagerFactory") EntityManagerFactory channelEntityManagerFactory) {

		return new JpaTransactionManager(channelEntityManagerFactory);
	}
}
