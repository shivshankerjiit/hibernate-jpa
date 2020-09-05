package com.jpaproject.jpaproject;

import com.jpaproject.jpaproject.entity.Course;
import com.jpaproject.jpaproject.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes=JpaprojectApplication.class)
class JpaprojectApplicationTests {

	Logger logger = LoggerFactory.getLogger(JpaprojectApplicationTests.class);

	@Autowired
	CourseRepository repository;

	@Test
	void testFindById_basic() {
		Course course = repository.findById(1001L);
		assertEquals("ROSE",course.getName());
	}
	@Test
	@DirtiesContext
	void testDeleteById_basic() {
		repository.deleteById(1001L);
		assertNull(repository.findById(1001L));
	}
	@Test
	@Transactional
	@DirtiesContext
	void testSave_basic() {
		Course course = repository.findById(1001L);
		assertEquals("ROSE",course.getName());

		course.setName("JASMINE");
		repository.save(course);

		Course course1 = repository.findById(1001L);
		assertEquals("JASMINE",course1.getName());
	}
	@Test
	void testPlayWithEntityManager(){
		repository.playWithEntityManager();
		logger.info("Testing");
	}

}
