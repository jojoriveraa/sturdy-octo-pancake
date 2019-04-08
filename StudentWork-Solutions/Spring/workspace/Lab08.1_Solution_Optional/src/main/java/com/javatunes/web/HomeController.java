/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.web;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javatunes.domain.MusicCategory;
import com.javatunes.service.Catalog;

@Controller
@RequestMapping("/home")      // Map controller to /home
public class HomeController {
	
	// Inject a catalog
	@Autowired
	Catalog cat;

	// DONE: Optional - Method to add reference data into model
	@ModelAttribute("categories")
	public Collection<MusicCategory> populateCategories() {
		ArrayList<MusicCategory> categories = new ArrayList<MusicCategory>();
		for (MusicCategory cat : MusicCategory.values()) {
			categories.add(cat);
		}
		return categories;
	}

    // DONE: Annotate method parameter
	@RequestMapping(method = RequestMethod.GET)
	public String get(@ModelAttribute("search")  Search search) {
	
		// DONE: set keyword to "Diva"
		search.setKeyword("Diva");
	    
		return "home";
	}

//	// Handler method to process the search form submission
//	// DONE Annotate method parameter
//	@RequestMapping(method = RequestMethod.POST)
//	public String processSearch(@ModelAttribute("search") Search search) {
//		System.out.println("SearchController.processSearch()");
//		
//		// DONE: Get keyword from Search bean
//		// DONE: Do search using catalog object
//		// DONE: Add results into the model's matches property
//		String keyword = search.getKeyword();
//		System.out.println("keyword = " + keyword);
//		search.setMatches(cat.findByKeyword(keyword));
//
//		return "home";
//	}
	
	// Handler method to process the search form submission
	// DONE Annotate method parameter
	@RequestMapping(method = RequestMethod.POST)
	public String processSearch(@ModelAttribute("search") Search search) {
		System.out.println("SearchController.processSearch()");
		String keyword = search.getKeyword();
		System.out.println("keyword = " + keyword);
		if (keyword==null || keyword.length()==0) {  // No keyword?  Then use category
			System.out.println("search.getCategory() = " + search.getCategory());
			search.setMatches(cat.findByCategory(search.getCategory()));
		} else {
			search.setMatches(cat.findByKeyword(keyword));
		}
		return "home";
	}	
}