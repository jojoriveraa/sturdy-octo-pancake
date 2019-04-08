/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


// DONE: Enable web MVC
// DONE: Enable component scanning for com.javatunes.web package
@Configuration
@EnableWebMvc
@ComponentScan("com.javatunes.web")
public class WebConfig {}