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
public class GCDTest {

	@Test
	public void test() {
		GCD gcd = new GCD();
		assertEquals(21, gcd.euclid1(1071, 462));
		assertEquals(21, gcd.euclid2(1071, 462));
	}

}
