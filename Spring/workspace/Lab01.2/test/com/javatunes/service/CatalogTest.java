/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.service;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javatunes.domain.MusicItem;

public class CatalogTest {

	private ClassPathXmlApplicationContext ctx;
	private Catalog catalog;

	@Before
	public void setup() {
		// TODO: pass applicationContext.xml to the constructor
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		// TODO: Create the context, lookup the catalog.
		catalog = ctx.getBean(Catalog.class);
	}

	@After
	public void teardown() {
		// TODO: Close the context.
		ctx.close();
	}

	@Test
	public void testContextIsNotNull() {
		assertNotNull("spring container should not be null", ctx);
	}

	@Test
	public void testCatalogLookupPositive() {
		// TODO:
		/*
		 * Look up the musicCatalog, assert that it's not null and invoke its toString
		 * method. Don't forget to close spring context
		 */

		assertNotNull("Catalog should not be null", catalog);
		System.out.println(catalog);

		/*
		 * Catalog catalog2 = (Catalog) ctx.getBean("musicCatalog");
		 * assertNotNull("Catalog should not be null", catalog2);
		 * System.out.println(catalog2);
		 * 
		 * Catalog catalog3 = ctx.getBean(CatalogImpl.class);
		 * assertNotNull("Catalog should not be null", catalog3);
		 * System.out.println(catalog3);
		 */
	}

	// TODO: Not until Dependency Injection Lab - annotate as test method
	@Test
	public void testCatalogPositive() {
		// TODO: DI Lab - call the size method test that it's greater than zero, and
		// output its value

		long catSize = catalog.size();
		assertNotEquals(0, catSize);
		System.out.println(catSize);

		// TODO: DI Lab - call the findByKeyword method with "a", test that there is at
		// least
		// one item found, and output the found items

		Collection<MusicItem> catKeyword = catalog.findByKeyword("a");
		assertTrue("At least one item was found", catKeyword.size() >= 1);
		System.out.println(catKeyword);
	}

}
