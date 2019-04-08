package com.javatunes.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // Add annotation to declare this as an MVC Controller
@RequestMapping("/home") // Map the request to /home
public class HomeController {

	@RequestMapping(method = RequestMethod.GET)
	// DONE: remove the @ResponseBody annotation	
	public String get() {
		return "home"; 	// DONE: return logical "home"
	}
}