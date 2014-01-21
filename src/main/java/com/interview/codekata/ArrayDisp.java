package com.interview.codekata;

/**
 * 
 * @author choesang
 *
 *	Display an integer array of [1, 2, 3, 4, 5, 6, 7] in the following format 

	1 4 6 
	2 5 7 
	3 
	
	The method signature takes in an array of integers and the number of columns. 
	In the above example, noOfCols = 3. The columns should contain equal number 
	of elements as much as possible.
 */
public class ArrayDisp {
	public static void main(String arg[]){
		int[] a = {1,2,3,4,5,6,7,8,9,10};
		int[][] represent = ArrayDisp.represent(a, 4);
		
		
	}
	
	public static int[][] represent(int[] a, int cols) {
        int size = a.length;
        int elementsPerCol = size / cols;
        int remain = size % cols;
        int[][] output;

        if (remain <= 0)
            output = new int[elementsPerCol][cols];
        else
            output = new int[elementsPerCol + 1][cols];

        int k = 0;
        for (int i = 0; i < output[0].length; i++) {
            for (int j = 0; j < output.length - 1; j++) {
                if (k >= a.length) {
                	return output;
                }
                output[j][i] = a[k];
                System.out.println("row: " + j + " col: " + i + " = "+ a[k]);
                k++;
            }
            if (remain > 0) {
                output[output.length - 1][i] = a[k];
                System.out.println("row: " + (output.length - 1) + " col: " + i + " = "+ a[k]);
                remain--;
                k++;
            }

        }

        return output;
    }

}
