package com.premsh.jpaexperiment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:custom.properties")
@PropertySource("classpath:channel-datasource.properties")
@PropertySource("classpath:user-datasource.properties")
public class JpaexperimentApplication {
	public static void main(String[] args) {
		SpringApplication.run(JpaexperimentApplication.class, args);
	}
}
