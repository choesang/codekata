package com.example.codekata;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

// Write a ransom note by cutting words out of a magazine
public class RansomNote {
	
	public static void main(String[] args) {
		String ransomNote = "if you want to have your child, come and visit me behind the church at mid night";
		String magazine = "In January 2012, two Yale students named Harry Yu and Peter Xu built a replacement to Yale’s official course selection website. They it called YBB+ (Yale Bluebook Plus), a “plus” version of the Yale-owned site, called Yale Bluebook. YBB+ offered different functionality from the official site, allowing students to sort courses by average rating and workload. The official Yale Bluebook, rather, showed a visual graph of the distribution of student ratings as well as a list of written student reviews. YBB+ offered a more lightweight user interface and facilitated easier comparison of course statistics. Students loved it. A significant portion of the student body started using it.";
		
		System.out.println(isNotePossible(ransomNote, magazine));
	}
	
	public static boolean isNotePossible(String ransomNote, String magazine) {
		Map<Character, Integer> magazineMap = new TreeMap<Character, Integer>();
		Map<Character, Integer> noteMap = new TreeMap<Character, Integer>();
		
		magazineMap = characterCounter(magazine, magazineMap);
		noteMap = characterCounter(ransomNote, noteMap);
		
		for (Entry<Character, Integer> element : noteMap.entrySet()) {
			System.out.println("RANSOME character: " + element.getKey() + " counter: " + element.getValue());
			System.out.println("MAGAZINE character: " + element.getKey() + " counter: " + magazineMap.get(element.getKey()));
			if ( element.getValue() > magazineMap.get(element.getKey()) ) {
				return false;
			}
		}

		return true;
	}

	private static Map<Character, Integer> characterCounter(String text, Map<Character, Integer> map) {
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
