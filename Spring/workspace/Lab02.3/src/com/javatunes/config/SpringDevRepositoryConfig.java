/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.javatunes.persistence.InMemoryItemRepository;
import com.javatunes.persistence.ItemRepository;

@Configuration
// TODO: Annotate this class for profile "dev"
@Profile("dev")
public class SpringDevRepositoryConfig extends SpringBaseRepositoryConfig {

	@Bean
	ItemRepository itemRepository() {		
		// TODO: create an instance of the dev repository
		// TODO: set the max search results to maxSearchResults
		// TODO: return the instance reference
		InMemoryItemRepository inMemoryItemRepository = new InMemoryItemRepository();
		inMemoryItemRepository.setMaxSearchResults(maxSearchResults);
		return inMemoryItemRepository;
	}

}