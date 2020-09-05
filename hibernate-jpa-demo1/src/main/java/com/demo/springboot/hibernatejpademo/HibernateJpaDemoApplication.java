package com.demo.springboot.hibernatejpademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication
// 1)This is Spring Context File
// 2)Auto configuration
// 3)Automatic scan of this package
// when sprinBoot starts up springAutoConfigurer will look for specific files in class path and existing configuration for application,
// if it finds Spring-MVC in class path it will configure DispatcherServlet.
//		logging.level.org.springframework = DEBUG
// Most imp feature that spring solves is DI or IOC(take control of code) -> it makes code looselyCoupledApplication and testable
@SpringBootApplication
public class HibernateJpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateJpaDemoApplication.class, args);
	}

}
