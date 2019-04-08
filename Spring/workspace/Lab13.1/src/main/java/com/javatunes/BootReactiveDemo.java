/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Import;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javatunes.config.SpringConfig;

@SpringBootApplication
@Import(SpringConfig.class)
public class BootReactiveDemo  {

    public static void main(String[] args) {
    	System.out.println("BootReactiveDemo.main() called");
        SpringApplication.run(BootReactiveDemo.class, args);
    }   
}
