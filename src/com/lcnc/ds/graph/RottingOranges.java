package com.lcnc.ds.graph;

/**
 * You are given an m x n grid where each cell can have one of three values:
 * 
 * 0 representing an empty cell, 1 representing a fresh orange, or 2
 * representing a rotten orange. Every minute, any fresh orange that is
 * 4-directionally adjacent to a rotten orange becomes rotten.
 * 
 * Return the minimum number of minutes that must elapse until no cell has a
 * fresh orange. If this is impossible, return -1.
 * 
 * Example 1:
 * 
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]] Output: 4
 * 
 * Example 2:
 * 
 * Input: grid = [[2,1,1],[0,1,1],[1,0,1]] Output: -1 Explanation: The orange in
 * the bottom left corner (row 2, column 0) is never rotten, because rotting
 * only happens 4-directionally.
 * 
 * Example 3:
 * 
 * Input: grid = [[0,2]] Output: 0 Explanation: Since there are already no fresh
 * oranges at minute 0, the answer is just 0.
 */
public class RottingOranges {

	public static void main(String[] args) {
		System.out.println(orangesRotting(new int[][] { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } }));
		System.out.println(orangesRotting(new int[][] { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } }));
		System.out.println(orangesRotting(new int[][] { { 0, 2, 2 } }));

		System.out.println("---");

		System.out.println(orangesRottingPractice(new int[][] { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } }));
		System.out.println(orangesRottingPractice(new int[][] { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } }));
		System.out.println(orangesRottingPractice(new int[][] { { 0, 2, 2 } }));

	}

	private static int orangesRottingPractice(int[][] grid) {
		return 0;
	}

	private static int orangesRotting(int[][] grid) {
		int offset = 7;
		for (int r = 0; r < grid.length; r++)
			for (int c = 0; c < grid[0].length; c++)
				if (grid[r][c] == 2) {
					grid[r][c] = offset;
					rotOranges(grid, r, c, offset);
				}
		int minutes = offset;
		for (int[] row : grid) {
			for (int cell : row) {
				if (cell == 1)
					return -1;
				minutes = Math.max(minutes, cell);
			}
		}
		return minutes - offset;
	}

	/**
	 * r < 0 || r == grid.length || c < 0 || c == grid[0].length -> if going outside
	 * grid, return back
	 * 
	 * grid[r][c] == 0 || grid[r][c] == 2 -> if empty or already rotten no need to
	 * process.
	 * 
	 * (grid[r][c] > 2 && grid[r][c] < minutes) -> if (grid[r][c] > 2) means orange
	 * is rotten due to being in path of some previous rotten orange. If previous
	 * orange path was able to rot the orange before (grid[r][c] < minutes) current
	 * path can then return.
	 */
	private static void rotOranges(int[][] grid, int r, int c, int minutes) {
		if (r < 0 || r == grid.length || c < 0 || c == grid[0].length || grid[r][c] == 0 || grid[r][c] == 2
				|| (grid[r][c] > 2 && grid[r][c] < minutes))
			return;
		grid[r][c] = minutes;
		rotOranges(grid, r, c + 1, minutes + 1);
		rotOranges(grid, r, c - 1, minutes + 1);
		rotOranges(grid, r + 1, c, minutes + 1);
		rotOranges(grid, r - 1, c, minutes + 1);
	}

}
