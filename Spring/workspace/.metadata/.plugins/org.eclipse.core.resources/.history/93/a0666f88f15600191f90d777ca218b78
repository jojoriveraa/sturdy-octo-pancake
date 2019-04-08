/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2006-12 LearningPatterns Inc.
 */
 
package com.javatunes.web;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.javatunes.domain.MusicItem;
import com.javatunes.service.Catalog;

// TODO: Annotate so the search and cart model beans are on the session
// TODO: Annotate as a controller class 
// TODO: Map controller to /cart
public class CartController {
	
	// Inject a catalog
	@Autowired
	Catalog cat;

	// TODO: Annotate this to add a model bean named search model	
	public Search createSearch() {
		return new Search();
	}
	
	// TODO: Annotate this to add a bean named cart to the model
	public Collection<MusicItem> createCart() {
		return new ArrayList<MusicItem>(); 
	}
	
	// TODO: Annotate to respond to HTTP GET requests (generates basic cart page)
	public String get(Search s) {  // TODO: Annotate so that s is bound to a model bean named search
		return "TODO";
	}
	
	// Controller for adding an item into the Cart
	// TODO: Annotate to respond to GET requests for /content/cart/add
	// TODO: Annotate cart parameter to bind it to a model attribute named cart
	// TODO: Initialize id from a RequestParameter named "id" and make it required
	public String add(Long id, Collection<MusicItem> cart) {
		System.out.println("CartController.add()");
		MusicItem item = cat.findById(id);
		// cart parameter is initialized when handler is called - just use it. 
		if (!cart.contains(item))  // based on equals() method of MusicItem
		{
			System.out.println("Adding item: " + item);
			cart.add(item);
		}
		return "TODO";
	}

	// TODO: Annotate to respond to GET requests for /content/cart/checkout
	// TODO: Add SessionStatus parameter
	public String checkout() {
		System.out.println("CartController.checkout()");
		// TODO: Use the status to indicate the session is complete.
		
		return "redirect:/content/cart";
	}
	
}