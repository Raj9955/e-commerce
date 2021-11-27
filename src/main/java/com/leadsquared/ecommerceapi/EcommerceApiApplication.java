package com.leadsquared.ecommerceapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommerceApiApplication {

	private static final Logger logger=LoggerFactory.getLogger(EcommerceApiApplication.class);


	public static void main(String[] args) {
		logger.info("Rest Api path ======> ",Constants.REST_API_BOOKS_FULL_PATH);
		SpringApplication.run(EcommerceApiApplication.class, args);
	}

}
