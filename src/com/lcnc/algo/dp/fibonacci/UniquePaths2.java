package com.lcnc.algo.dp.fibonacci;

import java.util.Arrays;

/**
 * You are given an m x n integer array grid. There is a robot initially located
 * at the top-left corner (i.e., grid[0][0]). The robot tries to move to the
 * bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move
 * either down or right at any point in time.
 * 
 * An obstacle and space are marked as 1 or 0 respectively in grid. A path that
 * the robot takes cannot include any square that is an obstacle.
 * 
 * Return the number of possible unique paths that the robot can take to reach
 * the bottom-right corner.
 * 
 * The testcases are generated so that the answer will be less than or equal to
 * 2 * 109.
 * 
 * Example 1:
 * 
 * Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]] Output: 2 Explanation: There
 * is one obstacle in the middle of the 3x3 grid above. There are two ways to
 * reach the bottom-right corner: 1. Right -> Right -> Down -> Down 2. Down ->
 * Down -> Right -> Right
 * 
 * Example 2:
 * 
 * Input: obstacleGrid = [[0,1],[0,0]] Output: 1
 */
public class UniquePaths2 {

	public static void main(String[] args) {
		System.out.println(uniquePaths(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } }));
		System.out.println(uniquePaths(new int[][] { { 0, 1 }, { 0, 0 } }));

		System.out.println("---");

		System.out.println(uniquePathsPractice(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } }));
		System.out.println(uniquePathsPractice(new int[][] { { 0, 1 }, { 0, 0 } }));
	}

	private static int uniquePathsPractice(int[][] grid) {
		return -1;
	}

	private static void printMatrix(int[][] matrix) {
		for (int r = 0; r < matrix.length; r++)
			System.out.print(Arrays.toString(matrix[r]));
		System.out.println();
	}

	/**
	 * <pre>
	 * INPUT:
	 * 
	 * { 0, 0, 0 } 
	 * { 0, 1, 0 } 
	 * { 0, 0, 0 }
	 * 
	 * DP:
	 * 
	 * [2, 1, 1]
	 * [1, 0, 1]
	 * [1, 1, 1]
	 * </pre>
	 */
	private static int uniquePaths(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1)
			return 0;
		int[][] dp = new int[m][n];
		for (int r = m - 1; r >= 0; r--) {
			if (grid[r][n - 1] == 1)
				break;
			dp[r][n - 1] = 1;
		}
		for (int c = n - 1; c >= 0; c--) {
			if (grid[m - 1][c] == 1)
				break;
			dp[m - 1][c] = 1;
		}
		for (int r = m - 2; r >= 0; r--) {
			for (int c = n - 2; c >= 0; c--) {
				if (grid[r][c] == 1)
					dp[r][c] = 0;
				else
					dp[r][c] = dp[r + 1][c] + dp[r][c + 1];
			}
		}
		printMatrix(dp);
		return dp[0][0];
	}

}
