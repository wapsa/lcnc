package com.lcnc.algo.backtracking.extra;

/**
 * You are given an integer array coins representing coins of different
 * denominations and an integer amount representing a total amount of money.
 * 
 * Return the fewest number of coins that you need to make up that amount. If
 * that amount of money cannot be made up by any combination of the coins,
 * return -1.
 * 
 * You may assume that you have an infinite number of each kind of coin.
 * 
 * Example 1:
 * 
 * Input: coins = [1,2,5], amount = 11 Output: 3 Explanation: 11 = 5 + 5 + 1
 * 
 * Example 2:
 * 
 * Input: coins = [2], amount = 3 Output: -1
 * 
 * Example 3:
 * 
 * Input: coins = [1], amount = 0 Output: 0
 */
public class CoinChange {

	public static void main(String[] args) {
		System.out.println(coinChange(new int[] { 1, 2, 5 }, 11));
		System.out.println(coinChange(new int[] { 2 }, 3));
		System.out.println(coinChange(new int[] { 411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422 }, 9864));

		System.out.println("---");

		System.out.println(coinChange1(new int[] { 1, 2, 5 }, 11));
		System.out.println(coinChange1(new int[] { 2 }, 3));
		// System.out.println(coinChange1(new int[] { 411, 412, 413, 414, 415, 416, 417,
		// 418, 419, 420, 421, 422 }, 9864)); // takes too long.

		System.out.println("---");

		System.out.println(coinChangePractice(new int[] { 1, 2, 5 }, 11));
		System.out.println(coinChangePractice(new int[] { 2 }, 3));
		System.out.println(
				coinChangePractice(new int[] { 411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422 }, 9864));

	}

	private static int coinChangePractice(int[] coins, int amount) {
		return -1;
	}

	private static int coinChange(int[] coins, int amount) {
		int minCoins = coinChange(coins, 0, amount, 0);
		return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
	}

	private static int coinChange(int[] coins, int offset, int amount, int coinCount) {
		if (amount == 0)
			return coinCount;
		if (amount < 0)
			return Integer.MAX_VALUE;
		int minCoins = Integer.MAX_VALUE;
		for (int i = offset; i < coins.length; i++)
			minCoins = Math.min(minCoins, coinChange(coins, i, amount - coins[i], coinCount + 1));
		return minCoins;
	}

	private static int coinChange1(int[] coins, int amount) {
		int result = coinChangeHelper(coins, amount);
		return result == Integer.MAX_VALUE ? -1 : result;
	}

	private static int coinChangeHelper(int[] coins, int amount) {
		if (amount == 0)
			return 0;
		if (amount < 0)
			return Integer.MAX_VALUE;

		int minCoins = Integer.MAX_VALUE;
		for (int i = 0; i < coins.length; i++) {
			int result = coinChangeHelper(coins, amount - coins[i]);
			if (result != Integer.MAX_VALUE) {
				minCoins = Math.min(minCoins, 1 + result);
			}
		}
		return minCoins;
	}

}
