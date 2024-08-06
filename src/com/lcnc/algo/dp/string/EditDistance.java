package com.lcnc.algo.dp.string;

import java.util.Arrays;

/**
 * Given two strings word1 and word2, return the minimum number of operations
 * required to convert word1 to word2.
 * 
 * You have the following three operations permitted on a word:
 * 
 * Insert a character Delete a character Replace a character
 * 
 * Example 1:
 * 
 * Input: word1 = "horse", word2 = "ros" Output: 3 Explanation: horse -> rorse
 * (replace 'h' with 'r') rorse -> rose (remove 'r') rose -> ros (remove 'e')
 * 
 * Example 2:
 * 
 * Input: word1 = "intention", word2 = "execution" Output: 5 Explanation:
 * intention -> inention (remove 't') inention -> enention (replace 'i' with
 * 'e') enention -> exention (replace 'n' with 'x') exention -> exection
 * (replace 'n' with 'c') exection -> execution (insert 'u')
 */
public class EditDistance {

	public static void main(String[] args) {
		System.out.println(minDistance("horse", "ros"));
		System.out.println(minDistance("intention", "execution"));

		System.out.println("---");

		System.out.println(minDistancePractice("horse", "ros"));
		System.out.println(minDistancePractice("intention", "execution"));
	}

	private static int minDistancePractice(String word1, String word2) {
		int m = word1.length() + 1;
		int n = word2.length() + 1;
		int[][] dp = new int[m][n];
		for (int r = m - 2; r >= 0; r--) {
			dp[r][n - 1] = 1 + dp[r + 1][n - 1];
		}
		for (int c = n - 2; c >= 0; c--) {
			dp[m - 1][c] = 1 + dp[m - 1][c + 1];
		}
		for (int r = m - 2; r >= 0; r--) {
			for (int c = n - 2; c >= 0; c--) {
				if (word1.charAt(r) == word2.charAt(c)) {
					dp[r][c] = dp[r + 1][c + 1];
				} else {
					dp[r][c] = 1 + Math.min(dp[r + 1][c + 1], Math.min(dp[r + 1][c], dp[r][c + 1]));
				}
			}
		}
		printMatrix(dp);
		return dp[0][0];
	}

	private static void printMatrix(int[][] matrix) {
		for (int r = 0; r < matrix.length; r++)
			System.out.print(Arrays.toString(matrix[r]));
		System.out.println();
	}

	private static int minDistance(String word1, String word2) {
		int m = word1.length() + 1;
		int n = word2.length() + 1;
		int[][] dp = new int[m][n];
		dp[m - 1][n - 1] = 0;
		for (int r = m - 2; r >= 0; r--)
			dp[r][n - 1] = 1 + dp[r + 1][n - 1];
		for (int c = n - 2; c >= 0; c--)
			dp[m - 1][c] = 1 + dp[m - 1][c + 1];

		for (int r = m - 2; r >= 0; r--) {
			for (int c = n - 2; c >= 0; c--) {
				if (word1.charAt(r) == word2.charAt(c))
					dp[r][c] = dp[r + 1][c + 1];
				else
					// insert: dp[r][c + 1]
					// delete: dp[r + 1][c]
					// replace: dp[r + 1][c + 1]
					dp[r][c] = 1 + Math.min(dp[r + 1][c], Math.min(dp[r][c + 1], dp[r + 1][c + 1]));
			}
		}
		printMatrix(dp);
		return dp[0][0];
	}

}
