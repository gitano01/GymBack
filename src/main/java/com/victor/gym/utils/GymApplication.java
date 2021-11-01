package com.victor.gym.utils;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


//@ComponentScan(basePackages = {"com.victor.gym", "com.victor.gym.service.PersonaRepository"})

@SpringBootApplication
@ComponentScan(basePackages="com.*")

public class GymApplication {

	public static void main(String[] args) {
		SpringApplication.run(GymApplication.class, args);
		
	}
	
	@ConfigurationProperties(prefix="spring.datasource")
	@Bean
	@Qualifier("data_pgsql")
	public DataSource getDataSource() {
		return DataSourceBuilder
				.create()
				.build();
	}

}
