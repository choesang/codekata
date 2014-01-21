/**
 * 
 */
package com.example.codekata;


/**
 * @author choesang
 *
 */
public class FormattedString {
	
	public void format(int lineSize, String input) {
		StringBuilder sb = new StringBuilder();
		String[] strings = input.split(" ");
		int position = 0;
		
		for (String string : strings) {
			if ( position + string.length() > lineSize ) {
				sb.append("\n");
				position = 0;
			}
			sb.append(string);
			sb.append(" ");
			position = position + string.length();
		}
		System.out.println(sb);
	}

}
