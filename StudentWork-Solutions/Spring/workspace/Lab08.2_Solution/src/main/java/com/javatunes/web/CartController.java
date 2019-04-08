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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.javatunes.domain.MusicItem;
import com.javatunes.service.Catalog;

// DONE: Annotate so the search model bean is on the session
// DONE: Annotate as a controller class 
// DONE: Map controller to /cart
@Controller
@SessionAttributes({"search","cart"})
@RequestMapping("/cart")      // Map controller to /cart
public class CartController {
	
	// Inject a catalog
	@Autowired
	Catalog cat;

	// DONE: Annotate this to add a model bean named search to the model
	@ModelAttribute("search")
	public Search createSearch() {
		return new Search();
	}

	// DONE: Annotate this to add a bean named cart to the model
	@ModelAttribute("cart")
	public Collection<MusicItem> createCart() {
		return new ArrayList<MusicItem>(); 
	}
	
	// DONE: Annotate to respond to HTTP GET requests (generates basic cart page)
	@RequestMapping(method = RequestMethod.GET)
	public String get(@ModelAttribute("search") Search s) {  // DONE: Annotate so that s is bound to a model bean named search
		return "cart";
	}

	
	// Controller for adding an item into the Cart
	// DONE: Annotate to respond to GET requests for /content/cart/add
	@RequestMapping(value="/add", method = RequestMethod.GET)
	// DONE: Annotate cart parameter to bind it to a model attribute named cart
	// DONE: Initialize id from a RequestParameter named "id" and make it required	
	public String add(@RequestParam(value="id", required=true) Long id, @ModelAttribute("cart") Collection<MusicItem> cart) {
		System.out.println("CartController.add()");
		MusicItem item = cat.findById(id);
		// cart parameter is initialized when handler is called - just use it. 
		if (!cart.contains(item))  // based on equals() method of MusicItem
		{
			System.out.println("Adding item: " + item);
			cart.add(item);
		}
		return "home";
	}	
	

	// DONE: Annotate to respond to GET requests for /content/cart/checkout
	@RequestMapping(value="/checkout", method = RequestMethod.GET)
	// DONE: Add SessionStatus parameter
	public String checkout(SessionStatus status) {
		System.out.println("CartController.checkout()");
		// DONE: Use the status to indicate the session is complete.
		status.setComplete();
		return "redirect:/content/cart";
	}
}