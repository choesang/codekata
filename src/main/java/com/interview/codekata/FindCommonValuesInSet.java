package com.interview.codekata;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author choesang
 *
 *	There are 2 sorted sets.Find the common elements of those sets 
	e.g. 
	A={1,2,3,4,5,6} 
	B={5,6,7,8,9} 
	o/p C={5,6} 
	
	Complexity should ne 0(n+m) where n and m is the size of the first and second set respectively 
	
	Which data structure should be used to store the output
 */
public class FindCommonValuesInSet {
	
	public static void main(String[] args) {
		int[] a = {11,20,32,40,50,60,71,80,90,91};
		int[] b = {10,20,30,40,50,60,71,80,90,91};
		
		for (int i : findIntersection(a, b)) {
			System.out.println(i);
		};
	}

	public static List<Integer> findIntersection(int[] A, int[] B) {
		int L = A.length;
		int K = B.length;

		List<Integer> intersectionArr = new ArrayList<>();
		int i = L - 1;
		int j = K - 1;

		while ((i >= 0) && (j >= 0)) {
			if (A[i] > B[j]) {
				i--;
			} else if (B[j] > A[i]) {
				j--;
			} else {
				intersectionArr.add(A[i]);
				i--;
				j--;

			}
		}
		return intersectionArr;
	}
}
