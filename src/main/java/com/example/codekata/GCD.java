/**
 * 
 */
package com.example.codekata;


/**
 * @author choesang
 *
 */
public class GCD {
	
	public int euclid1(int max, int min) {
		int n = 1;
		int remainder = 0;
		while ( (max - (min * n)) > 0 ) {
			remainder = max - min * n;
			n++;
		}

		if (remainder == 0) {
			return min;
		} else {
			return euclid1(min, remainder);
		}
	}
	
	public int euclid2(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			System.out.println("recursion called..");
			return euclid2(b, a % b);
		}
	}

}
