package com.example.codekata;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class UniqueSubStrings {
	Set<String> hashSet = new HashSet<String>();
	
	public Set<String> permutate(String text) {
		int lastIndex = text.length() - 1;
		
		for (int i=0; i<=lastIndex; i++) {
			for(int j=i+1; j<=lastIndex+1; j++) {
				String substring = text.substring(i, j);
				hashSet.add(substring);
			}
		}
		
		Iterator<String> iterator = hashSet.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		return hashSet;
	}

	
}
