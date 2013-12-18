package com.example.codekata;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class UniqueSubStrings {
	HashSet<String> hashSet = new HashSet<String>();
	
	public Set<String> permutate(String text) {
		
		char[] sliced = text.toCharArray();
		
//		int numberOfMaxPermutation = calculateMaxPermutation(text.length());
//		System.out.println(numberOfMaxPermutation);
		
//		for (int i=0; i< sliced.length; i++) {
//			hashSet.add(text.subSequence(0, i).toString());
//		}
//		
//		for(int i=text.length(); i<=0; i--) {
//			hashSet.add(text.subSequence(0, i).toString());
//		}
		
		
		
		Iterator<String> iterator = hashSet.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		return hashSet;
	}

	private int calculateMaxPermutation(int length) {
		
		int result = 0;
		while (length > 0 ) {
			result += length * (length - 1);
			length--;
		} 
		return result;
	}
	
}
