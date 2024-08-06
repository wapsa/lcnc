package com.lcnc.algo.dp.fibonacci;

import java.util.List;

/**
 * Given a triangle array, return the minimum path sum from top to bottom.
 * 
 * For each step, you may move to an adjacent number of the row below. More
 * formally, if you are on index i on the current row, you may move to either
 * index i or index i + 1 on the next row.
 * 
 * Example 1:
 * 
 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]] Output: 11 Explanation: The
 * triangle looks like: 2 3 4 6 5 7 4 1 8 3 The minimum path sum from top to
 * bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
 * 
 * Example 2:
 * 
 * Input: triangle = [[-10]] Output: -10
 */
public class Triangle {

	public static void main(String[] args) {
		System.out.println(minimumTotal(List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3))));
		System.out.println(minimumTotal(List.of(List.of(-10))));

		System.out.println("---");

		System.out.println(
				minimumTotalPractice(List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3))));
		System.out.println(minimumTotalPractice(List.of(List.of(-10))));
	}

	private static int minimumTotalPractice(List<List<Integer>> triangle) {
		return -1;
	}

	private static int minimumTotal(List<List<Integer>> triangle) {
		List<Integer> lastRow = triangle.get(triangle.size() - 1);
		int[] dp = new int[lastRow.size()];
		for (int i = 0; i < lastRow.size(); i++) {
			dp[i] = lastRow.get(i);
		}
		for (int i = triangle.size() - 2; i >= 0; i--) {
			lastRow = triangle.get(i);
			for (int j = 0; j < lastRow.size(); j++) {
				dp[j] = lastRow.get(j) + Math.min(dp[j], dp[j + 1]);
			}
		}
		return dp[0];
	}

}
