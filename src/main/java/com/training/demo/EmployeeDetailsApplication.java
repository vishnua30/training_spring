package com.training.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeDetailsApplication.class, args);
		System.setProperty("log4j.configurationFile", "/EmployeeDetails/src/main/resources/log4j.properties");

	}

}
