package com.example.codekata;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectHTMLAttributes {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int numberOfLines = scanner.nextInt();
//		Map<String, String[]> treeMap = new TreeMap<String, String[]>();
		
//		for (int i = 0; i <= numberOfLines+1; i++) {
			while (scanner.hasNextLine()) {
				String string = scanner.nextLine();
				System.out.println(string);
			}
			
			
//			System.out.println(matcher.toString());
//		}
	}

}
