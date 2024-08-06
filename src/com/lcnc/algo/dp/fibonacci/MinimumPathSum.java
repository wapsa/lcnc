package com.lcnc.algo.dp.fibonacci;

import java.util.Arrays;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right, which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * Example 1:
 * 
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]] Output: 7
 * 
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 * 
 * Example 2:
 * 
 * Input: grid = [[1,2,3],[4,5,6]] Output: 12
 */
public class MinimumPathSum {

	public static void main(String[] args) {
		System.out.println(minPathSum(new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } }));
		System.out.println(minPathSum(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }));

		System.out.println("---");

		System.out.println(minPathSumPractice(new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } }));
		System.out.println(minPathSumPractice(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }));
	}

	private static int minPathSumPractice(int[][] grid) {
		return -1;
	}

	private static void printMatrix(int[][] matrix) {
		for (int r = 0; r < matrix.length; r++)
			System.out.print(Arrays.toString(matrix[r]));
		System.out.println();
	}

	/**
	 * <pre>
	 * Input: 
	 * {1, 3, 1} 
	 * {1, 5, 1} 
	 * {4, 2, 1}
	 * 
	 * DP: 
	 * [7, 6, 3]
	 * [8, 7, 2]
	 * [7, 3, 1]
	 * </pre>
	 */
	private static int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m][n];
		dp[m - 1][n - 1] = grid[m - 1][n - 1];
		for (int r = m - 2; r >= 0; r--)
			dp[r][n - 1] = grid[r][n - 1] + dp[r + 1][n - 1];
		for (int c = n - 2; c >= 0; c--)
			dp[m - 1][c] = grid[m - 1][c] + dp[m - 1][c + 1];
		for (int r = m - 2; r >= 0; r--)
			for (int c = n - 2; c >= 0; c--)
				dp[r][c] = grid[r][c] + Math.min(dp[r + 1][c], dp[r][c + 1]);
		printMatrix(dp);
		return dp[0][0];
	}

}
