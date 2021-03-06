package com.example.BestMetroRoute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.BestMetroRoute.services.ExcelToDataBaseService;

@SpringBootApplication
@EnableAutoConfiguration
public class BestMetroRouteApplication {
	public static void main(String[] args) {
		SpringApplication.run(BestMetroRouteApplication.class, args);
	}

}
