package com.lcnc.algo.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible subsets
 * (the power set).
 * 
 * The solution set must not contain duplicate subsets. Return the solution in
 * any order.
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3] Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 
 * Example 2:
 * 
 * Input: nums = [0] Output: [[],[0]]
 * 
 * ----
 * 
 * Power set methodologies: include-exclude (permutation possible), pascal
 * identity expansion (permutation not possible)
 * 
 * Permutation methodologies: by fixing position, by fixing input (whichever is
 * smaller pick that)
 * 
 * Combination methodologies: power set: include-exclude (natural way of getting
 * combinations), via permutation
 * 
 * Subset: A collection of some or all of the elements in a set
 * 
 * Power set: A collection of all the subsets in a set, including the set itself
 * and the empty set
 * 
 * powerset = nC0 + nC1 + nC2 + nC3 .... nCn = 2^n
 * 
 */
public class Subsets1 {

	public static void main(String[] args) {
		System.out.println(subsetsWithoutDup(new int[] { 1, 2, 3 }));
		System.out.println(subsetsWithoutDup(new int[] { 0 }));

		System.out.println("---");

		System.out.println(subsetsWithoutDupPractice(new int[] { 1, 2, 3 }));
		System.out.println(subsetsWithoutDupPractice(new int[] { 0 }));
	}

	private static List<List<Integer>> subsetsWithoutDupPractice(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		return res;
	}

	private static List<List<Integer>> subsetsWithoutDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		subsets(nums, 0, new ArrayList<>(), res);
		return res;
	}

	private static void subsets(int[] nums, int offset, List<Integer> output, List<List<Integer>> res) {
		res.add(new ArrayList<>(output));
		for (int i = offset; i < nums.length; i++) {
			output.add(nums[i]);
			subsets(nums, i + 1, output, res);
			output.remove(output.size() - 1);
		}
	}

}
