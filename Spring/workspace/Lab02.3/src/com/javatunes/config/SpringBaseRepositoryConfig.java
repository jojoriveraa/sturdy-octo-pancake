package com.javatunes.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBaseRepositoryConfig {
	
	@Autowired
	protected Integer maxSearchResults;

}
