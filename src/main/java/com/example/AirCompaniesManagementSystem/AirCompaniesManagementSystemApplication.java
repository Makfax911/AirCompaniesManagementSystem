package com.example.AirCompaniesManagementSystem;

import com.example.AirCompaniesManagementSystem.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class AirCompaniesManagementSystemApplication

{
@Autowired
	AirplaneService service ;
	public static void main(String[] args) {
		SpringApplication.run(AirCompaniesManagementSystemApplication.class, args);
	}
}
