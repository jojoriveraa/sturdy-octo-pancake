/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.rest.client;

import org.springframework.web.reactive.function.client.WebClient;

import com.javatunes.domain.MusicItem;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ReactiveWebClient {

	private final static String BASE_URI = "http://localhost:8080/javatunes/rest/items";
	
	// Includes URI Template variable for an item id
	private final static String ID_URI = "/{id}";

	public static void main(String[] args) {
		// Create instance of WebClient
		WebClient webClient = WebClient.create(BASE_URI);
		
		Mono<MusicItem> found = null;

        // Get a MusicItem using WebClient.get(), ID_URI and an item id
		// Convert to a Mono.
		found = webClient.get()
				.uri(ID_URI, "2")
				.retrieve()
				.bodyToMono(MusicItem.class);
		System.out.println("found is " + found);
		
		// Subscribe to the Flux, and just print out any values received to the console.
		// This will produce one value.
		found.subscribe(
				successValue -> System.out.println(successValue),
				  error -> System.out.println(error.getMessage()),
				  () -> System.out.println("Mono consumed.")
				);				

		// Pause the program so you can see output.  
		// TYPE return to continue.
		try {
			System.in.read();
		} catch (Exception ignore) {}

		
		Flux<MusicItem> foundAll = null;
		
		// Get a stream of MusicItem using WebClient.get() and BASE_URI
		// Convert to a Flux.
		foundAll = webClient.get()
				.retrieve()
				.bodyToFlux(MusicItem.class);
		System.out.println("foundAll is " + foundAll);
		
		// Subscribe to the Flux, and just print out any values received to the console.
		// This will produce multiple values that are streamed.
		// This client will receive and process them asynchronously as they arrive.
		foundAll.subscribe(
				successValue -> System.out.println("1: " + successValue),
				  error -> System.out.println(error.getMessage()),
				  () -> System.out.println("Flux consumed.")
				);	

/*		
 		// TODO: Uncomment to see a second subscriber.
		// Creates a second subscription to the flux.
		foundAll.subscribe(
				successValue -> System.out.println("2: " + successValue),
				  error -> System.out.println(error.getMessage()),
				  () -> System.out.println("Flux consumed.")
				);	
*/
		
		// Pause the program so you can see output.  
		// TYPE return to continue.
		try {
			System.in.read();
		} catch (Exception ignore) {}
		

		// Get a stream of MusicItem using WebClient.get() and BASE_URI
		// Convert to a Flux.
		// Filter - so you only get items with even id value.
		foundAll = webClient.get()
				.retrieve()
				.bodyToFlux(MusicItem.class)
				.filter(item -> item.getId()%2==0);
		System.out.println("foundAll is " + foundAll);
		
		// Subscribe to the Flux, and just print out any values received to the console.
		// This will produce multiple values that are streamed.
		// This client will receive and process them asynchronously as they arrive.
		foundAll.subscribe(
				successValue -> System.out.println(successValue),
				  error -> System.out.println(error.getMessage()),
				  () -> System.out.println("Flux consumed.")
				);	

		// Pause the program so you can see output.  
		// TYPE return to continue.
		try {
			System.in.read();
		} catch (Exception ignore) {}

	
	}
}
