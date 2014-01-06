package com.example.codekata;

import java.util.Set;

public class CommonElementsInSets {
	
	public void commonElements(Set<String> set1, Set<String> set2) {
		set1.removeAll(set2);
		for (String string : set1) {
			System.out.println(string);
		}
	}

}
