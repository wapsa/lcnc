package com.lcnc.ds.hashmap;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

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
public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		System.out.println(longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));
		System.out.println(longestConsecutive(new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 }));

		System.out.println("---");

		System.out.println(longestConsecutivePractice(new int[] { 100, 4, 200, 1, 3, 2 }));
		System.out.println(longestConsecutivePractice(new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 }));
	}

	private static int longestConsecutivePractice(int[] nums) {
		return -1;
	}

	private static int longestConsecutive(int[] nums) {
		Set<Integer> data = Arrays.stream(nums).boxed().collect(Collectors.toSet());
		int longestConsecutiveSeq = 0;
		for (int num : data) {
			if (data.contains(num - 1))
				continue;
			int count = 0;
			while (data.contains(num++))
				count++;
			longestConsecutiveSeq = Math.max(longestConsecutiveSeq, count);
		}
		return longestConsecutiveSeq;
	}

}
