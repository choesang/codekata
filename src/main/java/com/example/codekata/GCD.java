/**
 * 
 */
package com.example.codekata;

/**
 * @author choesang
 *
 */
public class GCD {
	
	public int euclid(int x, int y) {
		
		int min = Math.min(x, y);
		int max = Math.max(x, y);

		int n = 1;
		int remainder = 0;
		while ( max - min * n >= 0 ) {
			remainder = max - min * n;
			n++;
		}

		if (remainder == 0) {
			return min;
		} else {
			euclid(min, remainder);
		}
		
		return min;
	}
	
	public int euclidImproved(int a, int b) {
		System.out.println("a: " + a + " b: " + b);
		if (a == 0) {
			return a;
		} else {
			return euclid(b, a % b);
		}
	}

}
