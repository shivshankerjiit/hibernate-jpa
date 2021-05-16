package com.example.jpa.jpa;

import com.example.jpa.jpa.entity.Course;
import com.example.jpa.jpa.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        Course course = repository.findById(1000L);
        logger.info("Course : {}",course);

        //repository.deleteById(1001L);

        //course.setName("JPA updated");
        //Course courseSave = repository.save(course);
    }
}
