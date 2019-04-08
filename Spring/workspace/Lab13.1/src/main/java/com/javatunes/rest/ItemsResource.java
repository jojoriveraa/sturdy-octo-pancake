/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatunes.domain.MusicItem;
import com.javatunes.persistence.ItemRepository;
import com.javatunes.persistence.PausingMusicItemCollection;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

// Annotate as REST controller
// Annotate to map this controller to /items
@RestController
@RequestMapping("/items")
public class ItemsResource {
	
	@Autowired
	ItemRepository repo;

	// Annotate as a handler method
	// Return a Flux initialized with our data
 	@RequestMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<MusicItem> getAllItems() {
 		Collection<MusicItem> items = repo.findAll();
 		// We wrap the collection with our own collection that introduces pauses upon iteration
 		return Flux.fromIterable(new PausingMusicItemCollection(items));  
	}

	// Annotate as a handler method that matches URI of form /items/5
	// Annotate to bind the URI template variable to the id parameter	
 	// Return a Mono created from the MusicItem
    @RequestMapping("/{id}") 
 	public Mono<MusicItem> findItem(@PathVariable("id")Long id) {
    	   return Mono.justOrEmpty(repo.findOne(id));
	}
}