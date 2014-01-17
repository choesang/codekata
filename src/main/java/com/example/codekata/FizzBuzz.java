package com.example.codekata;

public class FizzBuzz {

	public static void main(String[] args) {
		for (int i = 1; i <= 100; i++) {
			String value = "";
			if (i % 3 == 0) {
				value += "FIZZ";
			}

			if (i % 5 == 0) {
				value += "BUZZ";
			}
			if (value.isEmpty()) {
				value = String.valueOf(i);
			}
			System.out.println(value);
		}
	}

}
