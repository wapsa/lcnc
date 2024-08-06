package com.lcnc.algo.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers, nums, that might contain duplicates, return
 * all possible unique permutations in any order.
 * 
 * Example 1:
 * 
 * Input: nums = [1,1,2] Output: [[1,1,2], [1,2,1], [2,1,1]]
 * 
 * Example 2:
 * 
 * Input: nums = [1,2,3] Output:
 * [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class Permutations2 {

	public static void main(String[] args) {
		System.out.println(permute(new int[] { 1, 1, 1 }, 3));
		System.out.println(permute(new int[] { 1, 1, 2 }, 2));
		System.out.println(permute(new int[] { 1, 1, 2 }, 3));
		System.out.println(permute(new int[] { 0, 1 }, 2));
		System.out.println(permute(new int[] { 1 }, 1));

		System.out.println("---");

		System.out.println(permutePractice(new int[] { 1, 1, 1 }, 3));
		System.out.println(permutePractice(new int[] { 1, 1, 2 }, 2));
		System.out.println(permutePractice(new int[] { 1, 1, 2 }, 3));
		System.out.println(permutePractice(new int[] { 0, 1 }, 2));
		System.out.println(permutePractice(new int[] { 1 }, 1));
	}

	private static List<List<Integer>> permutePractice(int[] nums, int r) {
		List<List<Integer>> res = new ArrayList<>();
		return res;
	}

	private static List<List<Integer>> permute(int[] nums, int r) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		backtrackFixingPosition(nums, new boolean[nums.length], new ArrayList<>(), r, res);
		return res;
	}

	private static void backtrackFixingPosition(int[] nums, boolean[] visitedNums, List<Integer> output, int pos,
			List<List<Integer>> res) {
		if (pos == output.size()) {
			res.add(new ArrayList<>(output));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			// !visitedNums[i - 1] (draw euler tour and see).
			// e.g. aab, for tour of first 'a' we want to consider the second 'a' also in
			// the output during this visitedNums[i] = true;
			// After completing tour of first 'a', it backtracks and comes to second 'a'
			// marking the first 'a' position as visitedNums[i] = false;, so we skip it.
			if (visitedNums[i] || (i > 0 && nums[i] == nums[i - 1] && !visitedNums[i - 1]))
				continue;
			output.add(nums[i]);
			visitedNums[i] = true;
			backtrackFixingPosition(nums, visitedNums, output, pos, res);
			output.remove(output.size() - 1);
			visitedNums[i] = false;

			// instead of || (i > 0 && nums[i] == nums[i - 1] && !visitedNums[i - 1]) we can
			// also do below

//			while (i + 1 < nums.length && nums[i] == nums[i + 1])
//				i++;
		}
	}

}
