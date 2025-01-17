package com.jpaproject.jpaproject;

import com.jpaproject.jpaproject.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaprojectApplication implements CommandLineRunner {

	@Autowired
	CourseRepository repository;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(JpaprojectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("findById -> {}",repository.findById(1001L));
	}
}
