/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class JavaTunesWebAppInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected String[] getServletMappings() {
    return new String[] { "/content/*"  };  // DONE: set the mapping to /content/*
  }
	  
  @Override
  protected Class<?>[] getRootConfigClasses() {
    // DONE: Return the root Spring config class
    return new Class<?>[] { SpringConfig.class  }; 
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    // DONE: Return the Web config class
    return new Class<?>[] { WebConfig.class  };
  }
}
