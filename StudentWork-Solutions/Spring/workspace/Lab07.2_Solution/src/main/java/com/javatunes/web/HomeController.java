package com.javatunes.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

// DONE: Add annotation to declare this as an MVC Controller
// DONE: Map the request to /home
@Controller
@RequestMapping("/home")
public class HomeController {

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String get() {
		return "<h1>Hello Spring MVC</h1>";
	}
}