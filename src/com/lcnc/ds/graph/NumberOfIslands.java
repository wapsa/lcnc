package com.lcnc.ds.graph;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and
 * '0's (water), return the number of islands.
 * 
 * An island is surrounded by water and is formed by connecting adjacent lands
 * horizontally or vertically. You may assume all four edges of the grid are all
 * surrounded by water.
 * 
 * Example 1:
 * 
 * Input: grid = [ ["1","1","1","1","0"], ["1","1","0","1","0"],
 * ["1","1","0","0","0"], ["0","0","0","0","0"] ] Output: 1
 * 
 * Example 2:
 * 
 * Input: grid = [ ["1","1","0","0","0"], ["1","1","0","0","0"],
 * ["0","0","1","0","0"], ["0","0","0","1","1"] ] Output: 3
 */
public class NumberOfIslands {

	public static void main(String[] args) {
		System.out.println(numIslands(new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' },
				{ '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } }));
		System.out.println(numIslands(new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } }));

		System.out.println("---");

		System.out.println(numIslandsPractice(new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' },
				{ '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } }));
		System.out.println(numIslandsPractice(new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } }));

	}

	private static int numIslandsPractice(char[][] grid) {
		return 0;
	}

	private static int numIslands(char[][] grid) {
		int islands = 0;
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length; c++) {
				if (grid[r][c] == '1') {
					numIslands(grid, r, c);
					islands++;
				}
			}
		}
		return islands;
	}

	private static void numIslands(char[][] grid, int r, int c) {
		if (r < 0 || r == grid.length || c < 0 || c == grid[0].length || grid[r][c] == '0')
			return;
		grid[r][c] = '0';
		numIslands(grid, r, c + 1);
		numIslands(grid, r, c - 1);
		numIslands(grid, r + 1, c);
		numIslands(grid, r - 1, c);
	}

}
