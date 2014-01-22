/**
 * 
 */
package com.example.codekata;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author choesang
 *
 */
public class FactorialTest {
	
	@Test
	public void testFactorial() {
		Factorial fac = new Factorial();
		assertEquals(6, fac.factorial(3));
	}

}
