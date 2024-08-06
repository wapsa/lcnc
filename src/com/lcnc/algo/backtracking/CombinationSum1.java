package com.lcnc.algo.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen
 * numbers sum to target. You may return the combinations in any order.
 * 
 * The same number may be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the frequency of at least one of the chosen
 * numbers is different.
 * 
 * The test cases are generated such that the number of unique combinations that
 * sum up to target is less than 150 combinations for the given input.
 * 
 * Example 1:
 * 
 * Input: candidates = [2,3,6,7], target = 7 Output: [[2,2,3],[7]] Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple
 * times. 7 is a candidate, and 7 = 7. These are the only two combinations.
 * 
 * Example 2:
 * 
 * Input: candidates = [2,3,5], target = 8 Output: [[2,2,2,2],[2,3,3],[3,5]]
 * 
 * Example 3:
 * 
 * Input: candidates = [2], target = 1 Output: []
 */
public class CombinationSum1 {

	public static void main(String[] args) {
		System.out.println(combinationSum(new int[] { 2, 3, 6, 7 }, 7));
		System.out.println(combinationSum(new int[] { 2, 3, 5 }, 8));
		System.out.println(combinationSum(new int[] { 2 }, 1));

		System.out.println("---");

		System.out.println(combinationSumPractice(new int[] { 2, 3, 6, 7 }, 7));
		System.out.println(combinationSumPractice(new int[] { 2, 3, 5 }, 8));
		System.out.println(combinationSumPractice(new int[] { 2 }, 1));
	}

	private static List<List<Integer>> combinationSumPractice(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		return res;
	}

	private static List<List<Integer>> combinationSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		backtrack(nums, 0, target, new ArrayList<>(), result);
		return result;
	}

	private static void backtrack(int[] nums, int offset, int target, List<Integer> output, List<List<Integer>> res) {
		if (target == 0) {
			res.add(new ArrayList<>(output));
			return;
		}
		for (int i = offset; i < nums.length; i++) {
			if (nums[i] <= target) {
				output.add(nums[i]);
				// same i, because we can reuse same number to reach target.
				backtrack(nums, i, target - nums[i], output, res);
				output.remove(output.size() - 1);
			}
		}
	}

}
