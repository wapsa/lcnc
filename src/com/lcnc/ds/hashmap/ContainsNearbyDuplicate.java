package com.lcnc.ds.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums and an integer k, return true if there are two
 * distinct indices i and j in the array such that nums[i] == nums[j] and abs(i
 * - j) <= k.
 * 
 * Example 1: Input: nums = [1,2,3,1], k = 3 Output: true
 * 
 * Example 2: Input: nums = [1,0,1,1], k = 1 Output: true
 * 
 * Example 3: Input: nums = [1,2,3,1,2,3], k = 2 Output: false
 */
public class ContainsNearbyDuplicate {

	public static void main(String[] args) {
		System.out.println(containsNearbyDuplicate(new int[] { 1, 2, 3, 1 }, 3));
		System.out.println(containsNearbyDuplicate(new int[] { 1, 0, 1, 1 }, 1));
		System.out.println(containsNearbyDuplicate(new int[] { 1, 2, 3, 1, 2, 3 }, 2));

		System.out.println("---");

		System.out.println(containsNearbyDuplicatePractice(new int[] { 1, 2, 3, 1 }, 3));
		System.out.println(containsNearbyDuplicatePractice(new int[] { 1, 0, 1, 1 }, 1));
		System.out.println(containsNearbyDuplicatePractice(new int[] { 1, 2, 3, 1, 2, 3 }, 2));
	}

	private static boolean containsNearbyDuplicatePractice(int[] nums, int k) {
		return false;
	}

	private static boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer, Integer> numIdxMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (numIdxMap.containsKey(nums[i]) && i - numIdxMap.get(nums[i]) <= k)
				return true;
			numIdxMap.put(nums[i], i);
		}
		return false;
	}

}
