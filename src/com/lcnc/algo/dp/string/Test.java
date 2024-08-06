package com.lcnc.algo.dp.string;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("abbafkghabbba"));
	}

	public static String longestPalindrome(String s) {
		if (s.length() <= 1) {
			return s;
		}
		int maxLen = 1;
		int start = 0;
		int end = 0;
		int[][] dp = new int[s.length()][s.length()];

		for (int c = 0; c < s.length(); c++) {
			dp[c][c] = 1;
			for (int r = 0; r < c; r++) {
				if (s.charAt(r) == s.charAt(c) && (c - r <= 2 || dp[r + 1][c - 1] == 1)) {
					dp[r][c] = 1;
					if (c - r + 1 > maxLen) {
						maxLen = c - r + 1;
						start = r;
						end = c;
					}
				}
			}
		}

		for (int[] x : dp) {
			System.out.println(Arrays.toString(x));
		}

		return s.substring(start, end + 1);
	}

}
