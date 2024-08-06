package com.lcnc.algo.dp.fibonacci;

import java.util.Arrays;

/**
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed. All houses at this place are
 * arranged in a circle. That means the first house is the neighbor of the last
 * one. Meanwhile, adjacent houses have a security system connected, and it will
 * automatically contact the police if two adjacent houses were broken into on
 * the same night.
 * 
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the
 * police.
 * 
 * Example 1:
 * 
 * Input: nums = [2,3,2] Output: 3 Explanation: You cannot rob house 1 (money =
 * 2) and then rob house 3 (money = 2), because they are adjacent houses.
 * 
 * Example 2:
 * 
 * Input: nums = [1,2,3,1] Output: 4 Explanation: Rob house 1 (money = 1) and
 * then rob house 3 (money = 3). Total amount you can rob = 1 + 3 = 4.
 * 
 * Example 3:
 * 
 * Input: nums = [1,2,3] Output: 3
 */
public class HouseRobber2 {

	public static void main(String[] args) {
		System.out.println(robTabulation(new int[] { 2, 3, 2 }));
		System.out.println(robTabulation(new int[] { 1, 2, 3, 1 }));
		System.out.println(robTabulation(new int[] { 1, 2, 3 }));

		System.out.println("---");

		System.out.println(robTabulationPractice(new int[] { 2, 3, 2 }));
		System.out.println(robTabulationPractice(new int[] { 1, 2, 3, 1 }));
		System.out.println(robTabulationPractice(new int[] { 1, 2, 3 }));
	}

	private static int robTabulationPractice(int[] nums) {
		return -1;
	}

	/**
	 * nums: 2,1,8,7,6,1
	 * 
	 * dp: 16,9,14,8,6,1
	 */
	private static int robTabulation(int[] nums) {
		int[] first = Arrays.copyOfRange(nums, 0, nums.length - 1);
		int[] second = Arrays.copyOfRange(nums, 1, nums.length);
		return Math.max(HouseRobber.robTabulation1(first), HouseRobber.robTabulation1(second));
	}

}
