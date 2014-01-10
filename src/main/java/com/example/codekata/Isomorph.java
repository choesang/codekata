package com.example.codekata;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Isomorph {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String first = scanner.next();
		String second = scanner.next();
		
		char[] firstCharArray = first.toCharArray();
		char[] secondCharArray = second.toCharArray();
		
		if (firstCharArray.length == secondCharArray.length) {
			
			int[] firstNumberArray = convertToNumberArray(firstCharArray);
			int[] secondNumberArray = convertToNumberArray(secondCharArray);
			System.out.println("firstNumberArray " + Arrays.toString(firstNumberArray) );
			System.out.println("secondNumberArray " + Arrays.toString(secondNumberArray) );
			
			if (Arrays.equals(firstNumberArray, secondNumberArray)) {
				System.out.println(true);
			} else {
				System.out.println(false);
			}
			
		} else {
			System.out.println(false);
		}
		
	}

	private static int[] convertToNumberArray(char[] charArray) {
		int[] numberArray = new int[charArray.length];
		Map<String,Integer> hashMap = new HashMap<String, Integer>();

		for (int i = 0; i < charArray.length; i++) {
			String character = String.valueOf(charArray[i]);
			if (hashMap.containsKey(character)) {
				int number = hashMap.get(character);
				numberArray[i] = number;
			} else {
				hashMap.put(character, i);
				numberArray[i] = i;
			}
		}
		
		return numberArray;
	}

}
