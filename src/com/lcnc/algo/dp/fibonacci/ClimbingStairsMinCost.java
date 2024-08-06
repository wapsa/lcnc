package com.lcnc.algo.dp.fibonacci;

/**
 * You are given an integer array cost where cost[i] is the cost of ith step on
 * a staircase. Once you pay the cost, you can either climb one or two steps.
 * 
 * You can either start from the step with index 0, or the step with index 1.
 * 
 * Return the minimum cost to reach the top of the floor.
 * 
 * Example 1:
 * 
 * Input: cost = [10,15,20] Output: 15 Explanation: You will start at index 1. -
 * Pay 15 and climb two steps to reach the top. The total cost is 15.
 * 
 * Example 2:
 * 
 * Input: cost = [1,100,1,1,1,100,1,1,100,1] Output: 6 Explanation: You will
 * start at index 0. - Pay 1 and climb two steps to reach index 2. - Pay 1 and
 * climb two steps to reach index 4. - Pay 1 and climb two steps to reach index
 * 6. - Pay 1 and climb one step to reach index 7. - Pay 1 and climb two steps
 * to reach index 9. - Pay 1 and climb one step to reach the top. The total cost
 * is 6.
 */
public class ClimbingStairsMinCost {

	public static void main(String[] args) {
		System.out.println(minCostClimbingStairs(new int[] { 10, 15, 20 }));
		System.out.println(minCostClimbingStairs(new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 }));

		System.out.println("---");

		System.out.println(minCostClimbingStairsPractice(new int[] { 10, 15, 20 }));
		System.out.println(minCostClimbingStairsPractice(new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 }));
	}

	private static int minCostClimbingStairsPractice(int[] cost) {
		return -1;
	}

	/**
	 * <pre>
	 * INPUT: { 10, 15, 20 }, DP: [25, 15, 20, 0]
	 * 
	 * INPUT: { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 }, DP: [6, 105, 5, 5, 4, 102, 3, 2, 100, 1, 0]
	 * </pre>
	 */
	private static int minCostClimbingStairs(int[] cost) {
		int[] dp = new int[cost.length + 1];
		dp[dp.length - 2] = cost[cost.length - 1];
		for (int i = dp.length - 3; i >= 0; i--)
			dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
		return Math.min(dp[0], dp[1]);
	}

}