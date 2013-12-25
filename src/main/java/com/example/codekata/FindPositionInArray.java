package com.example.codekata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//About the Challenges
//The challenges will describe some topic and then ask you to code a solution. As you progress through the challenges, you will learn concepts in algorithms. On each challenge, you will receive input on STDIN and you will need to print the correct output to STDOUT.
//
//For many challenges, helper methods will be provided for you to process the input into a useful format, like an array. You can use these methods to get started with your program, or you can write your own input methods if you want. Your code just needs to print the right output to each test case.
//
//Sample Challenge 
//This is a simple challenge to get things started. Given a sorted array (ar) and a number (V), can you print the index location of V in the array?
//
//{The next section describes the input format. You can often skip it if you are using included methods. }
//
//Input Format
//There will be three lines of input:
//
//V - the value you are looking for.
//n - the size of the array.
//ar - n numbers that makes up the array.
//Output Format
//Output the index of V in the array.
//
//{The next section describes the constraints and ranges of the input. Occasionally you want to check here to see how big the input could be. }
//
//Constraints
//1<=n<=1000 
//-1000 <=x <= 1000 , x ∈ ar
//
//{This “sample” shows the first input case. It is often useful to skip to the sample to understand a challenge. }
//
//Sample Input
//
//4
//6
//1 4 5 7 9 12
//Sample Output
//
//1
//Explanation
//V = 4. The 4 is located in the 1th spot on the array, so the answer is 1.

public class FindPositionInArray {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
		int size = scanner.nextInt();
		int[] array = new int[0];
			
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));

			String input;
			int i = 0;
			
			while ((input = br.readLine()) != null) {
				switch (i) {
				case 0:
					number = Integer.parseInt(input);
					break;

				case 1:
					size = Integer.parseInt(input);
					break;

				case 2:
					array = fillArray(input);
					break;
				}
				i++;
			}

		} catch (IOException io) {
			io.printStackTrace();
		}

		computeLocation(number, size, array);
	}

	/**
	 * @param number
	 * @param array
	 */
	public static int computeLocation(int number, int size, int[] array) {
		for (int i = 0; i <size; i++) {
			if (number == array[i]) {
				System.out.println(i);
				return i;
			}
		}
		return 0;
	}

	private static int[] fillArray(String input) {

		String[] strings = input.split(" ");
		int length = strings.length;
		int[] intArray = new int[length];
		for (int i=0; i<length; i++) {
			intArray[i] = Integer.parseInt(strings[i]);
		}

		return intArray;
	}
}