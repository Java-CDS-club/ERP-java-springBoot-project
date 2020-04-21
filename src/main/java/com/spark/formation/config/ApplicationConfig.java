/**
 * 
 */
package com.spark.formation.config;

import org.apache.catalina.mapper.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Application Config
 */
@Configuration
public class ApplicationConfig {

	/**
	 * Model mapping bean
	 * 
	 * @return
	 */
	@Bean
	public Mapper modelMapper() {
		return new Mapper();
	}

}
