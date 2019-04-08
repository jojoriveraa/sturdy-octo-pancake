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

import com.javatunes.persistence.ItemRepository;
import com.javatunes.persistence.ProductionItemRepository;

@Configuration
// TODO: annotate this class for profile "prod"
@Profile("prod")
public class SpringProdRepositoryConfig extends SpringBaseRepositoryConfig {
	
	@Bean
	ItemRepository itemRepository() {
		// TODO: Create an instance of the production repository
		// TODO: Set the max search results to maxSearchResults
		// TODO: Return the instance reference
		ProductionItemRepository productionItemRepository = new ProductionItemRepository();
		productionItemRepository.setMaxSearchResults(maxSearchResults);
		return productionItemRepository;
	}

}