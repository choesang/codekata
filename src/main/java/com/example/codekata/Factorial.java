/**
 * 
 */
package com.example.codekata;

import java.util.Scanner;

/**
 * @author choesang
 *
 */
public class Factorial {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		factorial(scanner.nextInt());
	}

	private static void factorial(int n) {
		
		while(n >= 1) {
			System.out.println(n);
			factorial(n * (n - 1));
		}
		
	}

}
