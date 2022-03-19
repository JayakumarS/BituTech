package com.bitutech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BituTechApp extends SpringBootServletInitializer {
	public static void main(String[] args) {
		System.out.println("BituTech App");
		SpringApplication.run(BituTechApp.class, args);
	}
}
