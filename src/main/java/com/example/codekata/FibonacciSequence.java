package com.example.codekata;

import java.util.Scanner;

public class FibonacciSequence {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = fibonaci(scanner.nextInt());
	}

	private static int fibonaci(int n) {
		System.out.println(n);
		
		if (n == 0 || n == 1) {
			return n;
		} else {
			return fibonaci(n-1) + fibonaci(n-2);
		}
	}

}
