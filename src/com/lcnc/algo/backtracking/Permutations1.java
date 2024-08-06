package com.lcnc.algo.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of distinct integers, return all the possible
 * permutations. You can return the answer in any order.
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3] Output:
 * [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 
 * Example 2:
 * 
 * Input: nums = [0,1] Output: [[0,1],[1,0]]
 * 
 * Example 3:
 * 
 * Input: nums = [1] Output: [[1]]
 * 
 * nPr = n!/(n-r)!
 * 
 * nPr = nCr * r!
 */
public class Permutations1 {

	public static void main(String[] args) {
		System.out.println(permute(new int[] { 1, 2, 3 }, 2));
		System.out.println(permute(new int[] { 1, 2, 3 }, 3));
		System.out.println(permute(new int[] { 0, 1 }, 2));
		System.out.println(permute(new int[] { 1 }, 1));

		System.out.println("---");

		System.out.println(permutePractice(new int[] { 1, 2, 3 }, 2));
		System.out.println(permutePractice(new int[] { 1, 2, 3 }, 3));
		System.out.println(permutePractice(new int[] { 0, 1 }, 2));
		System.out.println(permutePractice(new int[] { 1 }, 1));
	}

	private static List<List<Integer>> permutePractice(int[] nums, int r) {
		List<List<Integer>> res = new ArrayList<>();
		return res;
	}

	private static List<List<Integer>> permute(int[] nums, int r) {
		List<List<Integer>> res = new ArrayList<>();
		backtrackFixingPosition(nums, new boolean[nums.length], new ArrayList<>(), r, res);
		return res;
	}

	private static void backtrackFixingPosition(int[] nums, boolean[] visitedNums, List<Integer> output, int r,
			List<List<Integer>> res) {
		if (output.size() == r) {
			res.add(new ArrayList<>(output));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!visitedNums[i]) {
				output.add(nums[i]);
				visitedNums[i] = true;
				backtrackFixingPosition(nums, visitedNums, output, r, res);
				output.remove(output.size() - 1);
				visitedNums[i] = false;
			}
		}
	}

}
