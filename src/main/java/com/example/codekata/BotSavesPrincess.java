package com.example.codekata;

import java.util.Scanner;

public class BotSavesPrincess {
	/* Head ends here */
	static void displayPathtoPrincess(int n, String[] grid) {
		Location princess = null, bot = null;
		for (int i = 0; i < grid.length; i++) {
			if (-1 != grid[i].indexOf("m")) {
			//	System.out.println(i + "," + grid[i].indexOf("m"));
				bot = new Location(grid[i].indexOf("m"), i);
			}

			if (-1 != grid[i].indexOf("p")) {
			//	System.out.println(i + "," + grid[i].indexOf("p"));
				princess = new Location(grid[i].indexOf("p"), i);
			}
		}
		
		computePathToPrincess(princess, bot); 

	}

	private static void computePathToPrincess(Location princess, Location bot) {
		upDownMove(princess, bot);
		rightLeftMove(princess, bot);
	}

	private static void upDownMove(Location princess, Location bot) {
		while (princess.y != bot.y) {
			if (princess.y > bot.y) {
				print("DOWN");
				bot.y++;
			} else {
				print("UP");
				bot.y--;
			}
			upDownMove(princess, bot);
		}
	}

	private static void rightLeftMove(Location princess, Location bot) {
		while (princess.x != bot.x) {
			if (princess.x > bot.x) {
				print("RIGHT");
				bot.x++;
			} else {
				print("LEFT");
				bot.x--;
			}
			rightLeftMove(princess, bot);
		}
	}

	private static void print(String move) {
		System.out.println(move);
	}

	/* Tail starts here */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m;
		m = in.nextInt();
		String grid[] = new String[m];
		for (int i = 0; i < m; i++) {
			grid[i] = in.next();
		}

		displayPathtoPrincess(m, grid);
	}
	
	public static class Location {
		int x, y;
		
		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
