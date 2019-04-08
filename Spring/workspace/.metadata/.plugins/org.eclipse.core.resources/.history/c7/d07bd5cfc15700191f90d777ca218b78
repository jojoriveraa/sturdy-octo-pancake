/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.rest.client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.javatunes.domain.MusicItem;
import com.javatunes.domain.MusicItemCollectionWrapper;

public class RestClient {

	private final static String BASE_URI = "http://localhost:8080/javatunes/rest/items";
	
	// TODO: Finish the declaration below to include a URI Template variable for an item id
	private final static String ID_URI = BASE_URI + "TODO";

	public static void main(String[] args) {
		// TODO: Create instance of RestTemplate
		RestTemplate rt = null;
		
		MusicItem found = null;

        // TODO: Get a MusicItem using RestTemplate's getForObject,the ID_URI and an item id
		found = null;
		System.out.format("\nFound item 2: %s\n\n",found);

		// TODO: Get an item as a string using getForObject(), the ID_URI, and an item id
		// use String.class as the response type in getForObject()
		String foundString = null;
		System.out.format("\nFound item 2 as string: %s\n\n",foundString);
		
		Map<String,String> varsMap = new HashMap<String,String>();
		varsMap.put("id", "2");

		// TODO: Call getForObject using varsMap		
		found = null;
		System.out.format("\nFound item 2 using varsMap: %s\n\n",found);
	
		
		// TODO: Get all the items using getForObject, the BASE_URI, and MusicItemCollectionWrapper.class 
		// as the response type.	
		MusicItemCollectionWrapper items = null;
		System.out.format("\nAll Objects found: %s\n\n",items.getItems());
	}
}
