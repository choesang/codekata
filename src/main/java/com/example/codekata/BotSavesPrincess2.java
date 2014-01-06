package com.example.codekata;

import java.util.Scanner;
import java.math.*;

public class BotSavesPrincess2 {
	
	/* Head ends here */
	static void nextMove(int n, int r, int c, String[] grid) {
		int r1 = -1,c1 = -1;
		
		for (int i = 0; i < n; i++) {
			int positionOfPrincess = grid[i].indexOf("p");
			if (-1 != positionOfPrincess) {
				r1 = i;
				c1 = positionOfPrincess;
			}
		}
		
		String move = computeMove(r, c, r1, c1);
		System.out.println(move);
		
	}

	private static String computeMove(int r, int c, int r1, int c1) {
		
		int upOrDown = r - r1;
		int leftOrRight = c - c1;
		
		if (Math.abs(upOrDown) > Math.abs(leftOrRight)) {
			if (upOrDown > 0) {
				return "UP";
			} else {
				return "DOWN";
			}
		} else {
			if (leftOrRight > 0) {
				return "LEFT";
			} else {
				return "RIGHT";
			}
		}
	}

	/* Tail starts here */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n, r, c;
		n = in.nextInt();
		r = in.nextInt();
		c = in.nextInt();
		in.useDelimiter("\n");
		String grid[] = new String[n];

		for (int i = 0; i < n; i++) {
			grid[i] = in.next();
		}

		nextMove(n, r, c, grid);

	}
}