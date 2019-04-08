package com.javatunes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javatunes.service.Catalog;

@Controller // Add annotation to declare this as an MVC Controller
@RequestMapping("/home") // Map the request to /home
public class HomeController {

	// DONE: inject the Catalog
	@Autowired
	Catalog catalog;
	
	@RequestMapping(method = RequestMethod.GET)
	public String get() {
		return "home"; 	// DONE: return logical "home"
	}

//	// DONE: Handler method to process the search form submission	
//	@RequestMapping(value="/search", method = RequestMethod.POST)
//	public ModelAndView processSearch(@RequestParam(value="keyword", required=true) String keyword) {
//		System.out.println("SearchController.processSearch()");
//		return new ModelAndView("home", "matches", catalog.findByKeyword(keyword));		
//	}

	// OPTIONAL DONE: use Model as parameter, return logical view "home"
	@RequestMapping(value="/search", method = RequestMethod.POST)
	public String processSearch(@RequestParam(value="keyword", required=true) String keyword, Model model) {
		System.out.println("SearchController.processSearch()");
		model.addAttribute("matches", catalog.findByKeyword(keyword));
		return "home";
	}	

}