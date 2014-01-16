package com.example.codekata;


public class PrimeNumbers {

	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			int number = i;
			boolean prime = isPrime(number);
			if (prime) {
				System.out.println(Long.toBinaryString(number) + "  ");
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
		while (m <= Math.sqrt(n)) {
			if ( n % m == 0 ) {
				return false;
			}
			m++;
		}
		return true;
	}

}
