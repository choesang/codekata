package com.example.codekata;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

// Write a ransom note by cutting words out of a magazine
public class RansomNote {
	
	public boolean isNotePossible(String ransomNote, String magazine) {
		Map<Character, Integer> magazineMap = new TreeMap<Character, Integer>();
		Map<Character, Integer> noteMap = new TreeMap<Character, Integer>();
		
		magazineMap = characterCounter(magazine, magazineMap);
		noteMap = characterCounter(ransomNote, noteMap);
		
		for (Entry<Character, Integer> element : noteMap.entrySet()) {
			if ( element.getValue() > magazineMap.get(element.getKey()) ) {
				return false;
			}
		}

		return true;
	}

	private Map<Character, Integer> characterCounter(String text, Map<Character, Integer> map) {
		for (char character : text.toCharArray()) {
			if ( map.containsKey(character) ) {
				int counter = (int) map.get(character);
				map.put(character, ++counter);
			} else {
				map.put(character, 1);
			}
		}
		return map;
	}

}
