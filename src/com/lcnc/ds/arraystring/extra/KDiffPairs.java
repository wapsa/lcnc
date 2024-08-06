package com.lcnc.ds.arraystring.extra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of integers nums and an integer k, return the number of unique
 * k-diff pairs in the array.
 * 
 * A k-diff pair is an integer pair (nums[i], nums[j]), where the following are
 * true:
 * 
 * 0 <= i, j < nums.length i != j |nums[i] - nums[j]| == k Notice that |val|
 * denotes the absolute value of val.
 * 
 * Example 1:
 * 
 * Input: nums = [3,1,4,1,5], k = 2 Output: 2 Explanation: There are two 2-diff
 * pairs in the array, (1, 3) and (3, 5). Although we have two 1s in the input,
 * we should only return the number of unique pairs.
 * 
 * Example 2:
 * 
 * Input: nums = [1,2,3,4,5], k = 1 Output: 4 Explanation: There are four 1-diff
 * pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 * 
 * Example 3:
 * 
 * Input: nums = [1,3,1,5,4], k = 0 Output: 1 Explanation: There is one 0-diff
 * pair in the array, (1, 1).
 */
public class KDiffPairs {

	public static void main(String[] args) {
		System.out.println(findPairs(new int[] { 3, 1, 4, 1, 5 }, 2));
		System.out.println(findPairs(new int[] { 1, 2, 3, 4, 5 }, 1));
		System.out.println(findPairs(new int[] { 1, 3, 1, 5, 4 }, 0));

		System.out.println("---");

		System.out.println(findPairsPractice(new int[] { 3, 1, 4, 1, 5 }, 2));
		System.out.println(findPairsPractice(new int[] { 1, 2, 3, 4, 5 }, 1));
		System.out.println(findPairsPractice(new int[] { 1, 3, 1, 5, 4 }, 0));
	}

	private static List<List<Integer>> findPairsPractice(int[] nums, int k) {
		return null;
	}

	private static List<List<Integer>> findPairs(int[] nums, int k) {
		List<List<Integer>> pairs = new ArrayList<>();
		Map<Integer, Integer> numFreqMap = new HashMap<>();
		for (int num : nums)
			numFreqMap.merge(num, 1, Integer::sum);
		numFreqMap.forEach((num, freq) -> {
			if (k == 0) {
				if (freq > 1) {
					pairs.add(List.of(num, num));
				}
			} else if (k > 0) {
				int req = num + k;
				if (numFreqMap.containsKey(req)) {
					pairs.add(List.of(req, num));
				}
			}
		});
		return pairs;
	}

}
