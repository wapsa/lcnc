package com.lcnc.algo.dp.fibonacci;

import java.util.HashMap;
import java.util.Map;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * Example 1:
 * 
 * Input: n = 2 Output: 2 Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step 2. 2 steps
 * 
 * Example 2:
 * 
 * Input: n = 3 Output: 3 Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step 2. 1 step + 2 steps 3. 2 steps + 1 step
 */
public class ClimbingStairs {

	private static final Map<Integer, Integer> MEMO = new HashMap<>();

	public static void main(String[] args) {
		System.out.println(climbStairsMemoization(1));
		System.out.println(climbStairsMemoization(2));
		System.out.println(climbStairsMemoization(3));
		System.out.println(climbStairsMemoization(5));
		MEMO.clear();

		System.out.println("---");

		System.out.println(climbStairsTabulationON(1));
		System.out.println(climbStairsTabulationON(2));
		System.out.println(climbStairsTabulationON(3));
		System.out.println(climbStairsTabulationON(5));

		System.out.println("---");

		System.out.println(climbStairsTabulationO1(1));
		System.out.println(climbStairsTabulationO1(2));
		System.out.println(climbStairsTabulationO1(3));
		System.out.println(climbStairsTabulationO1(5));

		System.out.println("---");

		System.out.println(climbStairsPractice(1));
		System.out.println(climbStairsPractice(2));
		System.out.println(climbStairsPractice(3));
		System.out.println(climbStairsPractice(5));
		MEMO.clear();
	}

	private static int climbStairsPractice(int n) {
		return -1;
	}

	private static int climbStairsMemoization(int n) {
		if (n == 0 || n == 1)
			return 1;
		if (MEMO.containsKey(n))
			return MEMO.get(n);
		int onep = climbStairsMemoization(n - 1);
		int twop = climbStairsMemoization(n - 2);
		MEMO.put(n, onep + twop);
		return MEMO.get(n);
	}

	// how many different ways can we reach the top, from each point we can do 1
	// jump or 2 jump so add those
	/**
	 * stairs: 5
	 * 
	 * dp: [8, 5, 3, 2, 1, 1]
	 */
	private static int climbStairsTabulationON(int n) {
		if (n == 0 || n == 1)
			return 1;
		int[] dp = new int[n + 1];
		dp[n] = 1;
		dp[n - 1] = 1;
		for (int i = n - 2; i >= 0; i--) {
			dp[i] = dp[i + 1] + dp[i + 2];
		}
		return dp[0];
	}

	private static int climbStairsTabulationO1(int n) {
		if (n == 0 || n == 1)
			return 1;
		int one = 1;
		int two = 1;
		for (int i = n - 2; i >= 0; i--) {
			int temp = one;
			one = one + two;
			two = temp;
		}
		return one;
	}

}