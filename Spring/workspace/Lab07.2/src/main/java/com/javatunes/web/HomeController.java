package com.javatunes.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javatunes.domain.MusicItem;
import com.javatunes.service.Catalog;

// TODO: Add annotation to declare this as an MVC Controller
// TODO: Map the request to /home
@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	Catalog catalog;

	@RequestMapping(method = RequestMethod.GET)
	public String get() {
//		return "<h1>Hello Spring MVC</h1>";
		return "home";
	}

//	@RequestMapping(value="/search", method = RequestMethod.POST)
//	public ModelAndView processSearch(
//			@RequestParam ("keyword") String keyword) {
//		Collection<MusicItem> items = catalog.findByKeyword(keyword);
//		return new ModelAndView("home", "matches", items);
//		
//	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String processSearch(
			@RequestParam("keyword") String keyword, 
			Model model) {
		Collection<MusicItem> items = catalog.findByKeyword(keyword);
		model.addAttribute("matches", items);
		return "home";
	}
}