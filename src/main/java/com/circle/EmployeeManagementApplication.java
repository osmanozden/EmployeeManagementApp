package com.circle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.TimeZone;

@SpringBootApplication
public class EmployeeManagementApplication {
	static{
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
    public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}
}
