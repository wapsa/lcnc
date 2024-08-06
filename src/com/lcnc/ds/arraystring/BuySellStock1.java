package com.lcnc.ds.arraystring;

/**
 * You are given an array prices where prices[i] is the price of a given stock
 * on the ith day.
 * 
 * You want to maximize your profit by choosing a single day to buy one stock
 * and choosing a different day in the future to sell that stock.
 * 
 * Return the maximum profit you can achieve from this transaction. If you
 * cannot achieve any profit, return 0.
 * 
 * Example 1: Input: prices = [7,1,5,3,6,4] Output: 5 Explanation: Buy on day 2
 * (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5. Note that buying
 * on day 2 and selling on day 1 is not allowed because you must buy before you
 * sell.
 * 
 * Example 2: Input: prices = [7,6,4,3,1] Output: 0 Explanation: In this case,
 * no transactions are done and the max profit = 0.
 */
public class BuySellStock1 {

	public static void main(String[] args) {
		System.out.println(buysell(new int[] { 7, 1, 5, 3, 6, 4 }));
		System.out.println(buysell(new int[] { 7, 6, 4, 3, 1 }));
		System.out.println(buysell(new int[] { 7, 10, 6, 4, 3, 1 }));

		System.out.println("---");

		System.out.println(buysell1(new int[] { 7, 1, 5, 3, 6, 4 }));
		System.out.println(buysell1(new int[] { 7, 6, 4, 3, 1 }));
		System.out.println(buysell1(new int[] { 7, 10, 6, 4, 3, 1 }));

		System.out.println("---");

		System.out.println(buysellPractice(new int[] { 7, 1, 5, 3, 6, 4 }));
		System.out.println(buysellPractice(new int[] { 7, 6, 4, 3, 1 }));
		System.out.println(buysellPractice(new int[] { 7, 10, 6, 4, 3, 1 }));
	}

	private static int buysellPractice(int[] prices) {
		return -1;
	}

	private static int buysell(int[] prices) {
		int boughtAt = prices[0];
		int maxProfit = 0;
		for (int i = 1; i < prices.length; i++) {
			boughtAt = Math.min(boughtAt, prices[i]);
			maxProfit = Math.max(maxProfit, prices[i] - boughtAt);
		}
		return maxProfit;
	}

	private static int buysell1(int[] prices) {
		int buy = prices[0];
		int maxProfit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < buy)
				buy = prices[i];
			if (prices[i] > buy)
				maxProfit = Math.max(maxProfit, prices[i] - buy);
		}
		return maxProfit;
	}

}
