/**
 * 
 */
package com.example.codekata;

import java.util.Arrays;

/**
 * @author choesang
 * 
 */
public class BinarySearch {
	public static void main(String[] args) {
		int x = 5;
		int[] a = new int[] { 1, 2, 3, 4, 5, 6 };

		System.out.println(binarySearchRecursion(x, a));
		System.out.println(binarySearchNoRecursion(x, a));
		System.out.println(binarySearchNoRecursionDoWhile(x, a));

	}

	public static int binarySearchRecursion(int x, int[] a) {
		int minIndex = 0;
		int maxIndex = a.length;

		int midIndex = (maxIndex + minIndex) / 2;
		if ( a[midIndex] == x ) {
			return a[midIndex];
		} else if (x > a[midIndex]) {
			return binarySearchRecursion(x, Arrays.copyOfRange(a, midIndex, maxIndex));
		} else {
			return binarySearchRecursion(x, Arrays.copyOfRange(a, minIndex, midIndex));
		}
	}

	public static int binarySearchNoRecursion(int x, int[] a) {

		int minIndex = 0;
		int maxIndex = a.length - 1;
		int midIndex = (minIndex + maxIndex) / 2;

		while (x != a[midIndex]) {
			if (x > a[midIndex]) {
				minIndex = midIndex;
			} else {
				maxIndex = midIndex;
			}
			midIndex = (minIndex + maxIndex) / 2;
		}
		return a[midIndex];
	}

	public static int binarySearchNoRecursionDoWhile(int x, int[] a) {

		int minIndex = 0;
		int maxIndex = a.length - 1;
		int midIndex;

		do {
			midIndex = (minIndex + maxIndex) / 2;
			if (a[midIndex] == x) {
				break;
			} else if (x > a[midIndex]) {
				minIndex = midIndex;
			} else {
				maxIndex = midIndex;
			}

		} while (x != a[midIndex]);

		return a[midIndex];
	}

}
