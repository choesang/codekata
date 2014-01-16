package com.example.codekata;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciSequence {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		for (int number = 0; number <= 1000; number++) {
//			System.out.println(fibonacci(number));
			fibonacciFast(1000);
//		}
	}

	private static int fibonacci(int n) {
		if (n == 0 || n == 1) {
			return n;
		} else {
			return fibonacci(n-2) + fibonacci(n-1);
		}
	}
	
	private static void fibonacciFast(int n) {
		
		BigInteger x = BigInteger.ZERO;
		BigInteger y = BigInteger.ONE;
		BigInteger temp = BigInteger.ZERO;

		for (int i = 0; i < n; i++) {
			System.out.println(x);
			temp = x;
			x = y;
			y = temp.add(y);
		}
	}

}
