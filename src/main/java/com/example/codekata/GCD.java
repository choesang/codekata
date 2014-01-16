/**
 * 
 */
package com.example.codekata;


/**
 * @author choesang
 *
 */
public class GCD {
	
	public int euclid(int max, int min) {
		
		int n = 1;
		int remainder = 0;
		while ( (max - (min * n)) > 0 ) {
			remainder = max - min * n;
			n++;
		}

		if (remainder == 0) {
			return min;
		} 
		else {
			return euclid(min, remainder);
		}
	}
	
	public int euclidImproved(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			System.out.println("recursion called..");
			return euclidImproved(b, a % b);
		}
	}

}
