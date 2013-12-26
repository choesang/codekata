package com.example.codekata;

import java.util.Arrays;
import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		String tmp = "";
		for (int i = 1; i <= count; i++) {
			tmp = scanner.next();
			if (tmp.length() % 2 == 0) {
				String[] array = tmp.split("");
				String[] subArray1 = Arrays.copyOfRange(array, 1, array.length / 2 +1);
				String[] subArray2 = Arrays.copyOfRange(array, array.length / 2+1, array.length);
				printArrays("subArray1", subArray1);
				printArrays("subArray2", subArray2);
				
				int index = -1;
				int counter = 0;
				for (String c : subArray1) {
					// index = Arrays.binarySearch(subArray2, c);
					index = Arrays.asList(subArray2).indexOf(c);
					if (index == -1) {
						counter++;
					} else {
						subArray2[index] = "0";
					}
				}
				System.out.println(counter);
			} else {
				System.out.println("-1");
			}

		}
	}
	
	private static void printArrays(String name, String[] array) {
		System.out.print(name + ": ");
		for (int i=0; i < array.length; i++) {
			System.out.print(array[i]);
		}
		System.out.println("");
	}

}
