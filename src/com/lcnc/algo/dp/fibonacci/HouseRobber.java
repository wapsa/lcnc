package com.lcnc.algo.dp.fibonacci;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security systems
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * 
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the
 * police.
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,1] Output: 4 Explanation: Rob house 1 (money = 1) and
 * then rob house 3 (money = 3). Total amount you can rob = 1 + 3 = 4.
 * 
 * Example 2:
 * 
 * Input: nums = [2,7,9,3,1] Output: 12 Explanation: Rob house 1 (money = 2),
 * rob house 3 (money = 9) and rob house 5 (money = 1). Total amount you can rob
 * = 2 + 9 + 1 = 12.
 * 
 * <pre>
 * suppose we want to skip atleast two houses after robbing a house
 * 
 * dp[0][i] = nums[i] + dp[1][i-2]
 * dp[1][i] = Math.max(dp[0][i-1], dp[1][i-1])
 * 
 * INPUT: 
 * 7,9,1,1,1,9,2
 * DP: 
 * 0,0,7,9,1,8,10,18,11
 * 0,0,0,7,9,9,9,10,18
 * 
 * INPUT:
 * 2,7,9,3,1,4
 * DP:
 * 0,0,2,7,9,5,8,13
 * 0,0,0,2,7,9,9,9
 * </pre>
 */
public class HouseRobber {

	public static void main(String[] args) {
		System.out.println(robPractice(new int[] { 1, 2, 3, 1 }));
		System.out.println(robPractice(new int[] { 2, 7, 9, 3, 1 }));

		System.out.println("---");

		System.out.println(rob(new int[] { 1, 2, 3, 1 }));
		System.out.println(rob(new int[] { 2, 7, 9, 3, 1 }));

		System.out.println("---");

		System.out.println(robMemoization(new int[] { 1, 2, 3, 1 }));
		System.out.println(robMemoization(new int[] { 2, 7, 9, 3, 1 }));

		System.out.println("---");

		System.out.println(robTabulation1(new int[] { 1, 2, 3, 1 }));
		System.out.println(robTabulation1(new int[] { 2, 7, 9, 3, 1 }));

		System.out.println("---");

		System.out.println(robTabulation2(new int[] { 1, 2, 3, 1 }));
		System.out.println(robTabulation2(new int[] { 2, 7, 9, 3, 1 }));
	}

	private static int robPractice(int[] nums) {
		return -1;
	}

	private static void printMatrix(int[][] matrix) {
		for (int r = 0; r < matrix.length; r++)
			System.out.print(Arrays.toString(matrix[r]));
		System.out.println();
	}

	private static int rob(int[] nums) {
		return rob(nums, 0);
	}

	/**
	 * as per the question constraint, we can not rob houses next to each other.
	 * that means we can either include or exclude the current house to get to max
	 * solution.
	 * 
	 * current element can either be included or excluded.
	 * 
	 * if included then next house cannot be considered, we consider the next to
	 * next. (i+2)
	 * 
	 * if excluded, then the next house can be considered. (i+1)
	 */
	private static int rob(int[] nums, int i) {
		if (i >= nums.length)
			return 0;

		// rob current house and move to i + 2,
		int robCurrent = nums[i] + rob(nums, i + 2);
		// or skip current house and move to i + 1
		int skipCurrent = rob(nums, i + 1);
		return Math.max(robCurrent, skipCurrent);
	}

	private static int robMemoization(int[] nums) {
		return robMemoization(nums, 0, new HashMap<>());
	}

	private static int robMemoization(int[] nums, int i, Map<Integer, Integer> memo) {
		if (i >= nums.length)
			return 0;
		if (memo.containsKey(i))
			return memo.get(i);
		// rob current house and move to i + 2,
		int robCurrent = nums[i] + rob(nums, i + 2);
		// or skip current house and move to i + 1
		int skipCurrent = rob(nums, i + 1);
		memo.put(i, Math.max(robCurrent, skipCurrent));
		return memo.get(i);
	}

	/**
	 * <pre>
	 * NUMS: 
	 * 
	 * 2, 7, 9, 3, 1
	 * 
	 * DP:
	 * 
	 * [2, 7, 11, 10, 12]
	 * [0, 2, 7, 11, 11]
	 * 
	 * </pre>
	 */
	public static int robTabulation1(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		if (nums.length == 2)
			return Math.max(nums[0], nums[1]);

		// first row > include, second row > exclude
		int[][] dp = new int[2][nums.length];
		dp[0][0] = nums[0]; // include
		dp[1][0] = 0; // exclude

		for (int c = 1; c < nums.length; c++) {
			dp[0][c] = nums[c] + dp[1][c - 1];
			dp[1][c] = Math.max(dp[0][c - 1], dp[1][c - 1]);
		}
		printMatrix(dp);
		return Math.max(dp[0][nums.length - 1], dp[1][nums.length - 1]);
	}

	public static int robTabulation2(int[] nums) {
		int maxInclude = 0;
		int maxExclude = 0;
		for (int i = 0; i < nums.length; i++) {
			int temp = maxInclude;
			maxInclude = nums[i] + maxExclude;
			maxExclude = Math.max(temp, maxExclude);
		}
		return Math.max(maxInclude, maxExclude);
	}

}
