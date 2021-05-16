package com.example.jpa.jpa.repository;

import com.example.jpa.jpa.entity.Course;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

// @RunWith(SpringRunner.class) - used to launch springboot context, but not needed now with Junit 5
@SpringBootTest // launches spring context and runs test and destros spring context
class CourseRepositoryTests {
	 private Logger logger = LoggerFactory.getLogger(this.getClass());

	 @Autowired
	 private CourseRepository repository;

	@Test
	void findById_basic() {
		Course course = repository.findById(1000L);
		assertEquals(course.getName(),"JPA course");
	}
	@Test
	@DirtiesContext
	void deleteById_basic() {
		repository.deleteById(1001L);
		assertNull(repository.findById(1001L));
	}
	@Test
	@DirtiesContext
	void save_insert() {
		Course course = repository.findById(1002L);
		course.setName("Name updated");
		repository.save(course);
		assertEquals(course.getName(),"Name updated");
	}
	@Test
	@DirtiesContext
	void save_update() {
		Course course = new Course();
		course.setName("Course created");
		repository.save(course);
		assertEquals(course.getName(),"Course created");
	}
}
