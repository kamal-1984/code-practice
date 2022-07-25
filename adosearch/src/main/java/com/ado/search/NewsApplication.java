/*
 * 
 */
package com.ado.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// TODO: Auto-generated Javadoc
/**
 * The Class NewsApplication.
 */
@SpringBootApplication
@EnableCaching
public class NewsApplication implements WebMvcConfigurer {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(NewsApplication.class, args);
	}
}
