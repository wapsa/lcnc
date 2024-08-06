package com.lcnc.algo.dp.fibonacci;

import java.util.Arrays;

/**
 * There is a robot on an m x n grid. The robot is initially located at the
 * top-left corner (i.e., grid[0][0]). The robot tries to move to the
 * bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move
 * either down or right at any point in time.
 * 
 * Given the two integers m and n, return the number of possible unique paths
 * that the robot can take to reach the bottom-right corner.
 * 
 * The test cases are generated so that the answer will be less than or equal to
 * 2 * 109.
 * 
 * Example 1:
 * 
 * Input: m = 3, n = 7 Output: 28
 * 
 * Example 2:
 * 
 * Input: m = 3, n = 2 Output: 3
 * 
 * Explanation: From the top-left corner, there are a total of 3 ways to reach
 * the bottom-right corner: 1. Right -> Down -> Down 2. Down -> Down -> Right 3.
 * Down -> Right -> Down
 */
public class UniquePaths1 {

	public static void main(String[] args) {
		System.out.println(uniquePaths(3, 7));
		System.out.println(uniquePaths(3, 2));

		System.out.println("---");

		System.out.println(uniquePathsPractice(3, 7));
		System.out.println(uniquePathsPractice(3, 2));
	}

	private static int uniquePathsPractice(int m, int n) {
		return -1;
	}

	private static void printMatrix(int[][] matrix) {
		for (int r = 0; r < matrix.length; r++)
			System.out.print(Arrays.toString(matrix[r]));
		System.out.println();
	}

	/**
	 * <pre>
	 * 
	 * INPUT: 3,7
	 * 
	 * DP: 
	 * 
	 * [28, 21, 15, 10, 6, 3, 1]
	 * [7, 6, 5, 4, 3, 2, 1]
	 * [1, 1, 1, 1, 1, 1, 1]
	 * 
	 * </pre>
	 */
	private static int uniquePaths(int m, int n) {
		int[][] grid = new int[m][n];
		for (int c = n - 1; c >= 0; c--)
			grid[m - 1][c] = 1;
		for (int r = m - 1; r >= 0; r--)
			grid[r][n - 1] = 1;
		for (int r = m - 2; r >= 0; r--)
			for (int c = n - 2; c >= 0; c--)
				grid[r][c] = grid[r + 1][c] + grid[r][c + 1];
		printMatrix(grid);
		return grid[0][0];
	}

}
