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

// TODO: Annotate so the search and cart model beans are on the session
// TODO: Annotate as a controller class 
// TODO: Map controller to /cart
@Controller
@SessionAttributes({"cart","search"})
@RequestMapping("/cart")
public class CartController {
	
	// Inject a catalog
	@Autowired
	Catalog cat;

	// TODO: Annotate this to add a model bean named search model	
	@ModelAttribute("search")
	public Search createSearch() {
		return new Search();
	}
	
	// TODO: Annotate this to add a bean named cart to the model
	@ModelAttribute("cart")
	public Collection<MusicItem> createCart() {
		return new ArrayList<MusicItem>(); 
	}
	
	// TODO: Annotate to respond to HTTP GET requests (generates basic cart page)
	@RequestMapping(method = RequestMethod.GET)
	public String get(@ModelAttribute("search") Search s) {  // TODO: Annotate so that s is bound to a model bean named search
		return "cart";
	}
	
	// Controller for adding an item into the Cart
	// TODO: Annotate to respond to GET requests for /content/cart/add
	// TODO: Annotate cart parameter to bind it to a model attribute named cart
	// TODO: Initialize id from a RequestParameter named "id" and make it required
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(@RequestParam(value = "id", required = true) Long id, @ModelAttribute("cart") Collection<MusicItem> cart) {
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

	// TODO: Annotate to respond to GET requests for /content/cart/checkout
	// TODO: Add SessionStatus parameter
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String checkout(SessionStatus status) {
		System.out.println("CartController.checkout()");
		// TODO: Use the status to indicate the session is complete.
		status.setComplete();
		return "redirect:/content/cart";
	}
	
}