/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.rest.client;

import org.springframework.web.client.RestTemplate;

import com.javatunes.domain.MusicItem;

public class RestClient {

	private final static String BASE_URI = "http://localhost:8080/javatunes/rest/items";
	
	// DONE: Finish the declaration below to include a URI Template variable for an item id
	private final static String ID_URI = BASE_URI + "/{id}";

	public static void main(String[] args) {
		// DONE: Create instance of RestTemplate
		RestTemplate rt = new RestTemplate();
		
		MusicItem found = null;

        // DONE: Get a MusicItem using RestTemplate's getForObject,the ID_URI and an item id
		found = rt.getForObject(ID_URI, MusicItem.class, "2");
		System.out.format("\nFound item 2: %s\n\n",found);
	
		
		// Get all the items using getForObject, the BASE_URI, and string  
		// as the response type for simplicity.
		String items = rt.getForObject(BASE_URI, String.class);
		System.out.format("\nAll Objects found: %s\n\n",items);
	}
}
