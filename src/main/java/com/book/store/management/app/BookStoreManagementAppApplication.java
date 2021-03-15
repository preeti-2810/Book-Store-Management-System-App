package com.book.store.management.app;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookStoreManagementAppApplication {
private final static  Logger log = LoggerFactory.getLogger(BookStoreManagementAppApplication.class);
	public static void main(String[] args) {
		log.info("Book Store Application Started");
		SpringApplication.run(BookStoreManagementAppApplication.class, args);
		log.info("Book Store Application Stopped");
	}

}
