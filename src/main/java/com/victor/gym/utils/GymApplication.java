package com.victor.gym.utils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


//@ComponentScan(basePackages = {"com.victor.gym", "com.victor.gym.service.PersonaRepository"})

@SpringBootApplication
@ComponentScan(basePackages="com.*")

public class GymApplication {

	public static void main(String[] args) {
		SpringApplication.run(GymApplication.class, args);
		
	}

}
