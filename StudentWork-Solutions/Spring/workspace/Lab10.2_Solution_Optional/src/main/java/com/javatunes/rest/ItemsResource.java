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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatunes.domain.MusicItem;
import com.javatunes.domain.MusicItemCollectionWrapper;
import com.javatunes.service.Catalog;

@RestController // Annotate as REST controller
@RequestMapping("/items") // Annotate to map this controller to /items
public class ItemsResource {
	
	@Autowired
	Catalog cat;

 	@RequestMapping // Annotate as a handler method
	public MusicItemCollectionWrapper getAllItems() { // DONE: Change return type to MusicItemCollectionWrapper 
		Collection<MusicItem> results = cat.findAll();
		return new MusicItemCollectionWrapper(results);
	}

    @RequestMapping("/{id}")   // Annotate as a handler method that matches URI of form /items/5
 	public MusicItem findItem(@PathVariable("id")Long id) {  // Annotate with @PathVariable to bind the URI template variable to the id
	   return cat.findById(id);
	}
}