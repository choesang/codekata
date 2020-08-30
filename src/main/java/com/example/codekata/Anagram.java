/**
 * 
 */
package com.example.codekata;

import java.util.Scanner;

/**
 * @author choesang
 *
 */
public class Anagram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
	        int rows = scanner.nextInt();
	        String words, a, b;
	        for ( int i = 0; i <= rows; i++ ) {
	        	words = scanner.next();
	        	System.out.println(isAnagram(words));
	        }
	}

	/**
	 * @param words
	 */
	private static int isAnagram(String words) {
		String a;
		String b;
		int mid = words.length() / 2;
		a = words.substring(0, mid);
		b = words.substring(mid);
		System.out.println(a.length() + " "+ b.length());
		
		if ( Math.abs(a.length()) - Math.abs(b.length()) <= 1) {
			return -1;
		} else {
			return b.length();
		}
	}

}
