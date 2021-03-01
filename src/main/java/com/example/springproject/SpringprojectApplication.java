package com.example.springproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringprojectApplication {

	public static void main(String[] args)
	{
		System.setProperty("server.port", "8081");
		SpringApplication.run(SpringprojectApplication.class, args);
	}

}
