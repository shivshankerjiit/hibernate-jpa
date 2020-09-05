package com.demo.springboot.hibernatejpademo;

import com.demo.springboot.hibernatejpademo.entity.Person;
import com.demo.springboot.hibernatejpademo.entity.PersonEntity;
import com.demo.springboot.hibernatejpademo.jdbc.PersonJdbcDao;
import com.demo.springboot.hibernatejpademo.jpa.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

// @SpringBootApplication
// 1)This is Spring Context File
// 2)Auto configuration
// 3)Automatic scan of this package
// when sprinBoot starts up springAutoConfigurer will look for specific files in class path and existing configuration for application,
// if it finds Spring-MVC in class path it will configure DispatcherServlet.
//		logging.level.org.springframework = DEBUG
// Most imp feature that spring solves is DI or IOC(take control of code) -> it makes code looselyCoupledApplication and testable

// springboot devtools - automatic restart
//		1)enable the “Make project automatically” option. You can find it in Settings – Build, Execution, Deployment – Compiler
//		2)Press Ctrl-Shift-A/ and select "Registry" from the menu that appears, enable the “compiler.automake.allow.when.app.running”
//CommandLineRunner (present in SpringBoot):
//		extends CommandLineRunner and implement run()
// 		As soon as spring context is created, run() will execute
//JdbcTemplate - > write less code, automatically handle connection close and when exception occur cleanup work
//create class extends RowMapper -> when we don't want whole Person bean to be returned in resultset
//JPA - > 	standards for ORM, Hibernate implements JPA
//			With JPA we map DB tables with beans(Entity) and thus shift the responsibility of writing sql queries from developer to JPA.
//				1)annotate bean with @Entity -> table will be created by 'SchemaUpdate' triggered by SpringBoot auto configuration.
//				2)add @Id and @GeneratedValue
//				3)create -> no arg constructor() {and} without Id constructor()
//				4)annotate @Table(name="person") and @Column(name="location") if name different.

@SpringBootApplication
public class HibernateJpaDemoApplication implements CommandLineRunner {

	//private Logger logger = LoggerFactory.getLogger(this.getClass());

	//use PersonJdbcDao->for JDBC template, or PersonRepository->for JPA
	@Autowired
	PersonJdbcDao dao;

	@Autowired
	PersonRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(HibernateJpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("All users -> " +dao.findAll());
		System.out.println("Find user with id=105 -> " +dao.findById(105));
		System.out.println("Delete user with id=105 -> " +dao.deleteById(105));
		Person person1 = new Person(106,"JOLLY","NL",new Date());
		Person person2 = new Person(103,"JOLLY","NL",new Date());
		System.out.println("Insert user with id=6 -> " +dao.insert(person1));
		System.out.println("Update user with id=3 -> " +dao.update(person2));
		System.out.println("All users findAllRowMapper -> " +dao.findAllRowMapper());
		System.out.println("JPA->Find user with id=1 -> " +repository.findById(101));
		System.out.println("JPA->update user with id=1 -> " +repository.update(new PersonEntity(101,"MUSK","NL",new Date())));
		System.out.println("JPA->insert user with id=1 -> " +repository.insert(new PersonEntity("ELON","NY",new Date())));
		repository.deleteById(102);
		System.out.println("JPA-> All users findAll -> " +repository.findAll());
	}
}

