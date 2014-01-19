/**
 * 
 */
package com.example.codekata;

import java.util.Scanner;

/**
 * @author choesang
 *
 */
public class FibonacciChecker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int loops = scanner.nextInt();
		
		for (int i = 0; i < loops; i++) {
			if (isFibonacci(scanner.nextDouble())) {
				System.out.println("IsFibo");
			} else {
				System.out.println("IsNotFibo");
			}
		}
		
	}

	private static boolean isFibonacci(double number) {
		return (Math.sqrt(5 * Math.pow(number, 2) - 4) % 1 == 0) || Math.sqrt(5 * Math.pow(number, 2) + 4) % 1 == 0;
	}

}
