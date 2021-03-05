package com.example.springproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories("com.example.springproject")
@SpringBootApplication
public class SpringprojectApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(SpringprojectApplication.class, args);

	}
	}


