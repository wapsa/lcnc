package com.lcnc.algo.dp.unboundedknapsack;

/**
 * You are given an integer array coins representing coins of different
 * denominations and an integer amount representing a total amount of money.
 * 
 * Return the number of combinations that make up that amount. If that amount of
 * money cannot be made up by any combination of the coins, return 0.
 * 
 * You may assume that you have an infinite number of each kind of coin.
 * 
 * The answer is guaranteed to fit into a signed 32-bit integer.
 * 
 * Example 1:
 * 
 * Input: amount = 5, coins = [1,2,5] Output: 4 Explanation: there are four ways
 * to make up the amount: 5=5 5=2+2+1 5=2+1+1+1 5=1+1+1+1+1
 * 
 * Example 2:
 * 
 * Input: amount = 3, coins = [2] Output: 0 Explanation: the amount of 3 cannot
 * be made up just with coins of 2.
 * 
 * Example 3:
 * 
 * Input: amount = 10, coins = [10] Output: 1
 */
public class CoinChange2 {

	public static void main(String[] args) {
		System.out.println(coinChange(new int[] { 1, 2, 5 }, 11));
		System.out.println(coinChange(new int[] { 2 }, 3));
		System.out.println(coinChange(new int[] { 411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422 }, 9864));

		System.out.println("---");

		System.out.println(coinChangePractice(new int[] { 1, 2, 5 }, 11));
		System.out.println(coinChangePractice(new int[] { 2 }, 3));
		System.out.println(
				coinChangePractice(new int[] { 411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422 }, 9864));
	}

	private static int coinChangePractice(int[] coins, int amount) {
		return -1;
	}

	/**
	 * 1,2,5
	 * 
	 * dp: [1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 10, 11]
	 */
	private static int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		dp[0] = 1;
		for (int coin : coins) {
			for (int i = coin; i <= amount; i++) {
				dp[i] += dp[i - coin];
			}
		}
		return dp[amount];
	}

}
