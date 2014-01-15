package com.example.codekata;

import java.util.Scanner;

public class FibonacciSequence {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		for (int number = 0; number <= 6; number++) {
			System.out.println(fibonaci(number));
		}
	}

	private static int fibonaci(int n) {
		
		if (n == 0 || n == 1) {
			return n;
		} else {
			return fibonaci(n-2) + fibonaci(n-1);
		}
	}

}
