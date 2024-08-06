package com.lcnc.algo.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j],
 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
 * nums[k] == 0.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * Example 1:
 * 
 * Input: nums = [-1,0,1,2,-1,-4] Output: [[-1,-1,2],[-1,0,1]] Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0. nums[1] + nums[2] + nums[4] =
 * 0 + 1 + (-1) = 0. nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0. The
 * distinct triplets are [-1,0,1] and [-1,-1,2]. Notice that the order of the
 * output and the order of the triplets does not matter.
 * 
 * Example 2:
 * 
 * Input: nums = [0,1,1] Output: [] Explanation: The only possible triplet does
 * not sum up to 0.
 * 
 * Example 3:
 * 
 * Input: nums = [0,0,0] Output: [[0,0,0]] Explanation: The only possible
 * triplet sums up to 0.
 */
public class ThreeSum {

	public static void main(String[] args) {
		System.out.println(threeSum(new int[] { -1, 0, 1, 2, -1, -4 }, 0));
		System.out.println(threeSum(new int[] { 0, 1, -1 }, 0));
		System.out.println(threeSum(new int[] { 0, 1, 1 }, 0));
		System.out.println(threeSum(new int[] { 0, 0, 0 }, 0));
		System.out.println(threeSum(new int[] { -1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4 }, 0));
		System.out.println(threeSum(new int[] { 4, 2, 5, 1, 8, 7 }, 0));

		System.out.println("---");

		System.out.println(threeSumPractice(new int[] { -1, 0, 1, 2, -1, -4 }, 0));
		System.out.println(threeSumPractice(new int[] { 0, 1, -1 }, 0));
		System.out.println(threeSumPractice(new int[] { 0, 1, 1 }, 0));
		System.out.println(threeSumPractice(new int[] { 0, 0, 0 }, 0));
		System.out.println(threeSumPractice(new int[] { -1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4 }, 0));
		System.out.println(threeSumPractice(new int[] { 4, 2, 5, 1, 8, 7 }, 0));
	}

	private static List<List<Integer>> threeSumPractice(int[] nums, int target) {
		return null;
	}

	private static List<List<Integer>> threeSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			int currentNum = nums[i];
			int diff = target - currentNum;
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				int twoSum = nums[left] + nums[right];
				if (twoSum == diff) {
					res.add(List.of(currentNum, nums[left], nums[right]));
					left++;
					right--;
					while (left < right && nums[left] == nums[left - 1])
						left++;
					while (right > left && nums[right] == nums[right + 1])
						right--;
				} else if (twoSum < diff) {
					left++;
				} else {
					right--;
				}
			}
		}
		return res;
	}

}
