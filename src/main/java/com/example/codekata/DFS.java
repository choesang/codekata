/**
 * 
 */
package com.example.codekata;

import java.util.Scanner;

/**
 * @author choesang
 * 
 */
public class DFS {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int pacman_r = in.nextInt();
		int pacman_c = in.nextInt();

		int food_r = in.nextInt();
		int food_c = in.nextInt();

		int r = in.nextInt();
		int c = in.nextInt();
		

		String grid[] = new String[r];

		for (int i = 0; i < r; i++) {
			grid[i] = in.next();
		}

		dfs(r, c, pacman_r, pacman_c, food_r, food_c, grid);
	}

	private static void dfs(int r, int c, int pacman_r, int pacman_c,
			int food_r, int food_c, String[] grid) {
		
		DFS dfs = new DFS();
		
		Node[] adjacencyLists = new Node[r*c];
		int currentNode = 0;
		for (int i = 0; i < grid.length; i++) {
			String currentRow = grid[i];
			for (int j = 0; j < grid[i].length(); j++) {
				char charValue = currentRow.charAt(j);
				if (charValue != '%') {
					adjacencyLists[currentNode] = new Node(i, j, charValue);
					++currentNode;
				}
			}
		}
	}
	
	class Node {
		Position position;
		Character value;
		boolean isVisited = false;

		public Node( int r, int c, Character charValue) {
			position = new Position(r, c);
			value = charValue;
		}

	}
	
	class Position {
		int r, c;
		
		public Position(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	

}
