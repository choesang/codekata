/**
 * 
 */
package com.example.codekata;

import org.junit.Test;

/**
 * @author choesang
 *
 */
public class FormattedTextTest {

	@Test
	public void test() {
		String input = "Cracking the Coding Interview: 150 Programming Interview Questions "
				+ "and Answers focuses on mastering the programming interview. Topics include: "
				+ "strategies to handle tough algorithm questions, preparation techniques, "
				+ "behavioral questions, and 150 programming interview questions and answers.";
		int lineSize = 20;
		
		FormattedString formattedString = new FormattedString();
		System.out.println("---------Line size of: " + 20);
		formattedString.format(20, input);
		System.out.println("---------Line size of: " + 30);
		formattedString.format(30, input);
	}

}
