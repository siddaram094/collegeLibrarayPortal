package com.college.library;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CollegelibraryProjectApplication {
private static final Logger logger = LoggerFactory.getLogger(CollegelibraryProjectApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(CollegelibraryProjectApplication.class, args);
		logger.info("Application started");
	}

}
