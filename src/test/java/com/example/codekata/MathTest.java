package com.example.codekata;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MathTest {
	
	private Math math;

	@Before
	public void setUp() throws Exception {
		math = new Math();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMultiply() {
		int result = math.multiply(5,4);
		assertEquals(20, result);
	}

}
