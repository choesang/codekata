package com.example.codekata;

import java.util.Scanner;

public class BotClean {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		
		String[] board = new String[5];
		
		for (int i = 0; i < board.length; i++) {
			board[i] = scanner.next();
		}
		
		nextMove(x, y, board);
		
	}

	private static String nextMove(int x, int y, String[] board) {
		for (int i = 0; i < board.length; i++) {
			System.out.println(board[i]);
		}
		return null;
	}

}
