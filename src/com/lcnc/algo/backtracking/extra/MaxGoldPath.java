package com.lcnc.algo.backtracking.extra;

/**
 * In a gold mine grid of size m x n, each cell in this mine has an integer
 * representing the amount of gold in that cell, 0 if it is empty.
 * 
 * Return the maximum amount of gold you can collect under the conditions:
 * 
 * Every time you are located in a cell you will collect all the gold in that
 * cell. From your position, you can walk one step to the left, right, up, or
 * down. You can't visit the same cell more than once. Never visit a cell with 0
 * gold. You can start and stop collecting gold from any position in the grid
 * that has some gold.
 * 
 * Example 1:
 * 
 * Input: grid = [[0,6,0],[5,8,7],[0,9,0]] Output: 24 Explanation: [[0,6,0],
 * [5,8,7], [0,9,0]] Path to get the maximum gold, 9 -> 8 -> 7.
 * 
 * Example 2:
 * 
 * Input: grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]] Output: 28
 * Explanation: [[1,0,7], [2,0,6], [3,4,5], [0,3,0], [9,0,20]] Path to get the
 * maximum gold, 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7.
 */
public class MaxGoldPath {

	public static void main(String[] args) {
		System.out.println(getMaximumGold(new int[][] { { 0, 6, 0 }, { 5, 8, 7 }, { 0, 9, 0 } }));
		System.out.println(
				getMaximumGold(new int[][] { { 1, 0, 7 }, { 2, 0, 6 }, { 3, 4, 5 }, { 0, 3, 0 }, { 9, 0, 20 } }));

		System.out.println("---");

		System.out.println(getMaximumGoldPractice(new int[][] { { 0, 6, 0 }, { 5, 8, 7 }, { 0, 9, 0 } }));
		System.out.println(getMaximumGoldPractice(
				new int[][] { { 1, 0, 7 }, { 2, 0, 6 }, { 3, 4, 5 }, { 0, 3, 0 }, { 9, 0, 20 } }));
	}

	private static int getMaximumGoldPractice(int[][] grid) {
		return -1;
	}

	private static int getMaximumGold(int[][] grid) {
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int max = 0;
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length; c++) {
				max = Math.max(max, getMaximumGold(grid, visited, r, c));
			}
		}
		return max;
	}

	private static int getMaximumGold(int[][] grid, boolean[][] visited, int r, int c) {
		if (r < 0 || r == grid.length || c < 0 || c == grid[0].length || grid[r][c] == 0 || visited[r][c])
			return 0;
		int gold = grid[r][c];
		visited[r][c] = true;
		int rgold = getMaximumGold(grid, visited, r, c + 1);
		int lgold = getMaximumGold(grid, visited, r, c - 1);
		int dgold = getMaximumGold(grid, visited, r + 1, c);
		int ugold = getMaximumGold(grid, visited, r - 1, c);
		visited[r][c] = false;
		return gold + max(rgold, lgold, dgold, ugold);
	}

	private static int max(int a, int b, int c, int d) {
		int max = a;
		if (b > max)
			max = b;
		if (c > max)
			max = c;
		if (d > max)
			max = d;
		return max;
	}

}
