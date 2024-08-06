package com.lcnc.algo.dp.string;

import java.util.Arrays;

/**
 * Given two strings text1 and text2, return the length of their longest common
 * subsequence. If there is no common subsequence, return 0.
 * 
 * A subsequence of a string is a new string generated from the original string
 * with some characters (can be none) deleted without changing the relative
 * order of the remaining characters.
 * 
 * For example, "ace" is a subsequence of "abcde". A common subsequence of two
 * strings is a subsequence that is common to both strings.
 * 
 * Example 1:
 * 
 * Input: text1 = "abcde", text2 = "ace" Output: 3 Explanation: The longest
 * common subsequence is "ace" and its length is 3.
 * 
 * Example 2:
 * 
 * Input: text1 = "abc", text2 = "abc" Output: 3 Explanation: The longest common
 * subsequence is "abc" and its length is 3.
 * 
 * Example 3:
 * 
 * Input: text1 = "abc", text2 = "def" Output: 0 Explanation: There is no such
 * common subsequence, so the result is 0.
 */
public class LongestCommonSubsequence {

	public static void main(String[] args) {
		System.out.println(longestCommonSubsequence("abcde", "ace"));
		System.out.println(longestCommonSubsequence("abc", "abc"));
		System.out.println(longestCommonSubsequence("abc", "def"));
		System.out.println(longestCommonSubsequence("babad", "dabab"));

		System.out.println("---");

		System.out.println(longestCommonSubsequencePractice("abcde", "ace"));
		System.out.println(longestCommonSubsequencePractice("abc", "abc"));
		System.out.println(longestCommonSubsequencePractice("abc", "def"));
		System.out.println(longestCommonSubsequencePractice("babad", "dabab"));
	}

	private static int longestCommonSubsequencePractice(String text1, String text2) {
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
	 * input: "abcde", "ace"
	 * 
	 *    a  c  e
	 * a [3, 2, 1, 0]
	 * b [2, 2, 1, 0]
	 * c [2, 2, 1, 0]
	 * d [1, 1, 1, 0]
	 * e [1, 1, 1, 0]
	 *   [0, 0, 0, 0]
	 * 
	 * </pre>
	 */
	public static int longestCommonSubsequence(String text1, String text2) {
		int[][] dp = new int[text1.length() + 1][text2.length() + 1];
		for (int r = dp.length - 2; r >= 0; r--) {
			for (int c = dp[0].length - 2; c >= 0; c--) {
				if (text1.charAt(r) == text2.charAt(c))
					// diagonal
					dp[r][c] = 1 + dp[r + 1][c + 1];
				else
					// max of right & down
					dp[r][c] = Math.max(dp[r][c + 1], dp[r + 1][c]);
			}
		}
		printMatrix(dp);
		System.out.println(reconstructTheLCS(text1, text2, dp));
		return dp[0][0];
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
