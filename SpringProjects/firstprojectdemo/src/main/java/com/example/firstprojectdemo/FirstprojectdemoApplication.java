package com.example.firstprojectdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

@RestController 
public class FirstprojectdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstprojectdemoApplication.class, args);
	}

	
}