package com.lcnc.algo.dp.fibonacci;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

		System.out.println(coinChangeTabulation(new int[] { 1, 2, 5 }, 11));
		System.out.println(coinChangeTabulation(new int[] { 2 }, 3));
		System.out.println(
				coinChangeTabulation(new int[] { 411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422 }, 9864));

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
		int result = coinChangeMemoization(coins, amount, new HashMap<>());
		return result == Integer.MAX_VALUE ? -1 : result;
	}

	private static int coinChangeMemoization(int[] coins, int amount, Map<Integer, Integer> memo) {
		if (amount == 0)
			return 0;
		if (amount < 0)
			return Integer.MAX_VALUE;
		if (memo.containsKey(amount))
			return memo.get(amount);

		int minCoins = Integer.MAX_VALUE;
		for (int i = 0; i < coins.length; i++) {
			int result = coinChangeMemoization(coins, amount - coins[i], memo);
			if (result != Integer.MAX_VALUE) {
				minCoins = Math.min(minCoins, 1 + result);
			}
		}
		memo.put(amount, minCoins);
		return minCoins;
	}

	/**
	 * <pre>
	 * coins: 1, 2, 5 
	 * 
	 * amount: 11
	 * 
	 * i:		0, 		1,		2, 		3,		4,		5, 		6, 		7, 		8, 		9, 		10, 	11
	 * 
	 * dp:		0,		12,		12,		12,		12, 	12, 	12, 	12, 	12, 	12, 	12, 	12
	 * 
	 * coin 1:	0,		1,		2,		3,		4,		5,		6,		7,		8,		9,		10,		11	
	 * 
	 * coin 2:					1,		2,		2,		3,		3,		4,		4,		5,		5,		6
	 * 
	 * coin 5:											1,		2,		2,		3,		3,		2,		3
	 * 
	 * </pre>
	 */
	private static int coinChangeTabulation(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;
		for (int amt = 1; amt < dp.length; amt++)
			for (int coin : coins)
				if (amt >= coin)
					dp[amt] = Math.min(dp[amt], dp[amt - coin] + 1);
		return dp[dp.length - 1] != amount + 1 ? dp[dp.length - 1] : -1;
	}

}
