package com.example.codekata;

import java.util.Scanner;

public class PrimeNumbers {

	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 1000; i++) {
			int number = i;
			boolean prime = isPrime(number);
			if (prime) {
//				System.out.println("The " + number +" is prime: " + prime);
				System.out.print(number + "  ");
			}
		}
		
	}

	private static boolean isPrime(int n) {
		if (n == 1 || n == 2 || n == 3) {
			return true;
		} else {
			return checkForFactors(n, 2);
		}
	}

	private static boolean checkForFactors(int n, int m) {
		if ( (n % 2 == 0) || (n % 3 == 0) ) {
			return false;
		}
		while (Math.sqrt(n) < m) {
			if ( n % m == 0 ) {
				return false;
			}
			m++;
		}
		return true;
	}

}
