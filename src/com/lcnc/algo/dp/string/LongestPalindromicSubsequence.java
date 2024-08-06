package com.lcnc.algo.dp.string;

import java.util.Arrays;

/**
 * Given a string s, find the longest palindromic subsequence's length in s.
 * 
 * A subsequence is a sequence that can be derived from another sequence by
 * deleting some or no elements without changing the order of the remaining
 * elements.
 * 
 * Example 1:
 * 
 * Input: s = "bbbab" Output: 4 Explanation: One possible longest palindromic
 * subsequence is "bbbb".
 * 
 * Example 2:
 * 
 * Input: s = "cbbd" Output: 2 Explanation: One possible longest palindromic
 * subsequence is "bb".
 */
public class LongestPalindromicSubsequence {

	public static void main(String[] args) {
		System.out.println(longestPalindromeSubseq("bbbab"));
		System.out.println(longestPalindromeSubseq("cbbd"));
		System.out.println(longestPalindromeSubseq("babad"));

		System.out.println("---");

		System.out.println(longestPalindromeSubseqPractice("bbbab"));
		System.out.println(longestPalindromeSubseqPractice("cbbd"));
		System.out.println(longestPalindromeSubseqPractice("babad"));
	}

	private static int longestPalindromeSubseqPractice(String text1) {
		return -1;
	}

	private static void printMatrix(int[][] matrix) {
		for (int r = 0; r < matrix.length; r++)
			System.out.print(Arrays.toString(matrix[r]));
		System.out.println();
	}

	public static int longestPalindromeSubseq(String text1) {
		String text2 = new StringBuilder(text1).reverse().toString();
		int[][] dp = longestPalindromeSubseq(text1, text2);
		System.out.println(reconstructTheLCS(text1, text2, dp));
		return dp[0][0];
	}

	/**
	 * <pre>
	 * 
	 * input: "bbbab", "babbb"
	 * 
	 *    b  b  b  a  b
	 * b [4, 3, 3, 2, 1, 0]
	 * b [3, 3, 3, 2, 1, 0]
	 * b [3, 2, 2, 2, 1, 0]
	 * a [2, 2, 1, 1, 1, 0]
	 * b [1, 1, 1, 1, 1, 0]
	 *   [0, 0, 0, 0, 0, 0]
	 * 
	 * </pre>
	 */
	private static int[][] longestPalindromeSubseq(String text1, String text2) {
		int[][] dp = new int[text1.length() + 1][text2.length() + 1];

		for (int r = dp.length - 2; r >= 0; r--) {
			for (int c = dp[0].length - 2; c >= 0; c--) {
				if (text1.charAt(r) == text2.charAt(c))
					dp[r][c] = 1 + dp[r + 1][c + 1];
				else
					// max of right or down
					dp[r][c] = Math.max(dp[r][c + 1], dp[r + 1][c]);
			}
		}
		printMatrix(dp);
		return dp;
	}

	private static String reconstructTheLCS(String text1, String text2, int[][] dp) {
		StringBuilder lcsBuilder = new StringBuilder();
		int r = 0;
		int c = 0;
		while (r < text1.length() && c < text2.length()) {
			if (text1.charAt(r) == text2.charAt(c)) {
				lcsBuilder.append(text1.charAt(r));
				r++;
				c++;
			} else if (dp[r][c + 1] >= dp[r + 1][c])
				c++;
			else
				r++;
		}
		return lcsBuilder.toString();
	}

}
