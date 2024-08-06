package com.lcnc.ds.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * You can return the answer in any order.
 * 
 * Example 1: Input: nums = [2,7,11,15], target = 9 Output: [0,1] Explanation:
 * Because nums[0] + nums[1] == 9, we return [0, 1].
 * 
 * Example 2: Input: nums = [3,2,4], target = 6 Output: [1,2]
 * 
 * Example 3: Input: nums = [3,3], target = 6 Output: [0,1]
 */
public class TwoSum {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum(new int[] { 2, 7, 11, 15 }, 9)));
		System.out.println(Arrays.toString(twoSum(new int[] { 3, 2, 4 }, 6)));
		System.out.println(Arrays.toString(twoSum(new int[] { 3, 3 }, 6)));

		System.out.println("---");

		System.out.println(Arrays.toString(twoSumPractice(new int[] { 2, 7, 11, 15 }, 9)));
		System.out.println(Arrays.toString(twoSumPractice(new int[] { 3, 2, 4 }, 6)));
		System.out.println(Arrays.toString(twoSumPractice(new int[] { 3, 3 }, 6)));
	}

	private static int[] twoSumPractice(int[] nums, int target) {
		return new int[0];
	}

	private static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> idxMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int diff = target - nums[i];
			if (idxMap.containsKey(diff))
				return new int[] { idxMap.get(diff), i };
			idxMap.put(nums[i], i);
		}
		return new int[0];
	}

}
