package com.lcnc.ds.graph;

// same as max gold island.
public class MaxAreaOfIsland {

	public static void main(String[] args) {
		System.out.println(maxAreaOfIsland(new int[][] { { 10, 20, 0, 0, 5 }, { 10, 30, 0, 0, 10 }, { 0, 0, 0, 0, 0 },
				{ 0, 10, 15, 30, 0 }, { 0, 0, 10, 10, 0 } }));
		System.out.println(maxAreaOfIsland(new int[][] { { 10, 20, 0, 0, 5 }, { 10, 30, 0, 0, 10 }, { 0, 0, 0, 0, 0 },
				{ 0, 10, 15, 10, 0 }, { 0, 0, 10, 10, 0 } }));

		System.out.println("---");

		System.out.println(maxAreaOfIslandPractice(new int[][] { { 10, 20, 0, 0, 5 }, { 10, 30, 0, 0, 10 },
				{ 0, 0, 0, 0, 0 }, { 0, 10, 15, 30, 0 }, { 0, 0, 10, 10, 0 } }));
		System.out.println(maxAreaOfIslandPractice(new int[][] { { 10, 20, 0, 0, 5 }, { 10, 30, 0, 0, 10 },
				{ 0, 0, 0, 0, 0 }, { 0, 10, 15, 10, 0 }, { 0, 0, 10, 10, 0 } }));
	}

	private static int maxAreaOfIslandPractice(int[][] grid) {
		return 0;
	}

	private static int maxAreaOfIsland(int[][] grid) {
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int max = 0;
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length; c++) {
				max = Math.max(max, maxAreaOfIsland(grid, visited, r, c));
			}
		}
		return max;
	}

	private static int maxAreaOfIsland(int[][] grid, boolean[][] visited, int r, int c) {
		if (r < 0 || r == grid.length || c < 0 || c == grid[0].length || grid[r][c] == 0 || visited[r][c])
			return 0;
		int gold = grid[r][c];
		visited[r][c] = true;
		gold += maxAreaOfIsland(grid, visited, r, c + 1);
		gold += maxAreaOfIsland(grid, visited, r, c - 1);
		gold += maxAreaOfIsland(grid, visited, r + 1, c);
		gold += maxAreaOfIsland(grid, visited, r - 1, c);
		return gold;
	}

}
