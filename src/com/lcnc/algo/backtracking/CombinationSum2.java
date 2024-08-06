package com.lcnc.algo.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number
 * (target), find all unique combinations in candidates where the candidate
 * numbers sum to target.
 * 
 * Each number in candidates may only be used once in the combination.
 * 
 * Note: The solution set must not contain duplicate combinations.
 * 
 * Example 1:
 * 
 * Input: candidates = [10,1,2,7,6,1,5], target = 8 Output: [ [1,1,6], [1,2,5],
 * [1,7], [2,6] ]
 * 
 * Example 2:
 * 
 * Input: candidates = [2,5,2,1,2], target = 5 Output: [ [1,2,2], [5] ]
 */
public class CombinationSum2 {

	public static void main(String[] args) {
		System.out.println(combinationSum(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8));
		System.out.println(combinationSum(new int[] { 2, 5, 2, 1, 2 }, 5));
		System.out.println(combinationSum(new int[] { 2, 3, 6, 7 }, 7));
		System.out.println(combinationSum(new int[] { 2, 3, 5 }, 8));
		System.out.println(combinationSum(new int[] { 2 }, 1));

		System.out.println("---");

		System.out.println(combinationSumPractice(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8));
		System.out.println(combinationSumPractice(new int[] { 2, 5, 2, 1, 2 }, 5));
		System.out.println(combinationSumPractice(new int[] { 2, 3, 6, 7 }, 7));
		System.out.println(combinationSumPractice(new int[] { 2, 3, 5 }, 8));
		System.out.println(combinationSumPractice(new int[] { 2 }, 1));
	}

	private static List<List<Integer>> combinationSumPractice(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		return res;
	}

	private static List<List<Integer>> combinationSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		backtrack(nums, 0, new ArrayList<>(), target, res);
		return res;
	}

	private static void backtrack(int[] nums, int offset, List<Integer> output, int target, List<List<Integer>> res) {
		if (target == 0) {
			res.add(new ArrayList<>(output));
			return;
		}
		for (int i = offset; i < nums.length; i++) {
			if (i > offset && nums[i] == nums[i - 1])
				continue; // skip duplicates
			if (nums[i] <= target) {
				output.add(nums[i]);
				// i+1, because "Each number in nums may only be used once in the output".
				backtrack(nums, i + 1, output, target - nums[i], res);
				output.remove(output.size() - 1);
			}
		}
	}

}
