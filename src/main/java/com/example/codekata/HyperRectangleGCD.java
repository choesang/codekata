/**
 * 
 */
package com.example.codekata;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author choesang
 *
 */
public class HyperRectangleGCD {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		int dimensions;
		for (int i = 0; i < cases; i++) {
			dimensions = scanner.nextInt();
			
//			List<Integer> list = new ArrayList<Integer>();
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			
			int sum = computeGCD(x, y);
			System.out.println(sum);
		}
		
	}
	
	private static int computeGCD(int x, int y) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		
		for ( int i = 1; i <= x; i++ ) {
			for ( int j = 1; j <= y; j++ ) {
				int gcd = euclidImproved(i, j);
//				System.out.println("i: " + i + " i: " + j + " gcd: " + gcd);
				arrayList.add( gcd );
			}
		}
		
		int sum = 0;
		for (Integer integer : arrayList) {
			
			sum += integer;
		}
		return sum;
	}

	public static int euclidImproved(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return euclidImproved(b, a % b);
		}
	}

}
