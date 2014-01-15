/**
 * 
 */
package com.example.codekata;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author choesang
 *
 */
public class GCDTest {

	@Test
	public void test() {
		GCD gcd = new GCD();
//		assertEquals(21, gcd.euclid(1071, 462));
		assertEquals(21, gcd.euclidImproved(1071, 462));
	}

}
