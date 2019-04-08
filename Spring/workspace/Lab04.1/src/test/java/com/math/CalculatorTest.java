/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.math;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

	Calculator calc;

	@Before
	public void setup() {
		calc = new Calculator();
	}

	@Test
	public void testAddPositive() {
		System.out.println("testAdd");
		assertEquals(5, calc.add(1, 4)); // expected, actual
	}

	// TODO: add divide and isEven tests
	@Test
	public void testDividePositive() {
		System.out.println("testDivide");
		assertEquals(2.5, calc.divide(5, 2), .001F); // expected, actual
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDivideNegative() {
		System.out.println("testDivideNegative");
		assertEquals(2.5, calc.divide(5, 0), .001F); // expected, actual
	}

	@Test
	public void testIsEvenPositive() {
		System.out.println("testIsEven");
		assertTrue(calc.isEven(10)); // expected, actual
	}
}