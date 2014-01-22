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
		System.out.println(n);

		if (n == 1) {
			return 1;
		} else{
			return  n * factorial(n - 1);
		}
		
	}

}
