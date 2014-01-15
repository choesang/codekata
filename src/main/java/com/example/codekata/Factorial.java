/**
 * 
 */
package com.example.codekata;

/**
 * @author choesang
 *
 */
public class Factorial {

	/**
	 * @param args
	 */
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		factorial(scanner.nextInt());
//	}

//		4 3 2 1
	public int factorial(int n) {
		while (n >= 1) {
			n = n * factorial(n - 1);
		}
		
		System.out.println(n);
		return n;
	}

}
