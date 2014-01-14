package com.example.codekata;

import java.util.Scanner;

public class FibonacciSequence {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		computeFibonacci(scanner.nextInt());
	}

	private static void computeFibonacci(int n) {
//		List<Integer> fibonacciSequence = new ArrayList<Integer>();
		
//		if (nextInt <= 1) {
//			fibonacciSequence.add(1);
//			fibonacciSequence.add(0);
//		} else {
//			
//		}
		
//		int n = 0;
		
		while (n >= 1) {
			computeFibonacci((n-2) + (n-1));
			n++;
		}
		
	}

}
