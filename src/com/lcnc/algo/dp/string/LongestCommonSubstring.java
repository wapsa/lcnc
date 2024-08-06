package com.lcnc.algo.dp.string;

import java.util.Arrays;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		System.out.println(longestCommonSubstring("babad", "dabab"));
		System.out.println(longestCommonSubstring("aabxyzbaa", "aabxyzbaa"));
		System.out.println(longestCommonSubstring("abc", "xyz"));

		System.out.println("---");

		System.out.println(longestCommonSubstringPractice("babad", "dabab"));
		System.out.println(longestCommonSubstring("aabxyzbaa", "aabxyzbaa"));
		System.out.println(longestCommonSubstring("abc", "xyz"));
	}

	private static int longestCommonSubstringPractice(String text1, String text2) {
		return -1;
	}

	/**
	 * 
	 * input: "babad", "dabab"
	 * 
	 * <pre>
	 *    b  a  b  a  d
	 * d [0, 0, 0, 0, 1, 0] 
	 * a [0, 3, 0, 1, 0, 0] 
	 * b [3, 0, 2, 0, 0, 0] 
	 * a [0, 2, 0, 1, 0, 0]
	 * b [1, 0, 1, 0, 0, 0] 
	 *   [0, 0, 0, 0, 0, 0]
	 * </pre>
	 */
	private static int longestCommonSubstring(String text1, String text2) {
		int[][] dp = new int[text1.length() + 1][text2.length() + 1];
		int len = 0;
		int start = 0;
		for (int r = dp.length - 2; r >= 0; r--) {
			for (int c = dp[0].length - 2; c >= 0; c--) {
				if (text1.charAt(r) == text2.charAt(c)) {
					dp[r][c] = 1 + dp[r + 1][c + 1];
					if (dp[r][c] > len) {
						len = dp[r][c];
						start = r;
					}
				}
			}
		}
		printMatrix(dp);
		System.out.println(text1.substring(start, start + len));
		return len;
	}

	private static void printMatrix(int[][] matrix) {
		for (int r = 0; r < matrix.length; r++)
			System.out.print(Arrays.toString(matrix[r]));
		System.out.println();
	}

}
