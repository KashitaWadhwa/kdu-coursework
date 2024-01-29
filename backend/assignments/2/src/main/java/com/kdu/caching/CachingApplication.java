package com.kdu.caching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Main class of the application
 */
@SpringBootApplication
@EnableCaching
public class CachingApplication {

	/**
	 * @param args Command line arguments
	 * Main method of the application
	 */
	public static void main(String[] args) {
		SpringApplication.run(CachingApplication.class, args);
	}

}
