package com.example.codekata;

import java.util.Arrays;

public class ArrayToDictionary {

	public static void main(String[] args) {
		int[] array = new int[]{1,2,2,3,3,3,4,4,4,4,4,6,7,9};
		
		int[] dictionary = new int[array[array.length-1]+1];
		
		int x = -1, occurrencesX = 0;
		for (int i=0; i<array.length; i++) {
			if(array[i] != x) {
				x = array[i];
				occurrencesX = 1;
			} else {
				occurrencesX++;
			}
			
			if(x>-1) {
				dictionary[x] = occurrencesX;
			}
			
		}
		
		System.out.println(Arrays.toString(dictionary));
		
	}

}
