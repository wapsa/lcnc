package com.lcnc.algo.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a 1-indexed array of integers numbers that is already sorted in
 * non-decreasing order, find two numbers such that they add up to a specific
 * target number. Let these two numbers be numbers[index1] and numbers[index2]
 * where 1 <= index1 < index2 <= numbers.length.
 * 
 * Return the indices of the two numbers, index1 and index2, added by one as an
 * integer array [index1, index2] of length 2.
 * 
 * The tests are generated such that there is exactly one solution. You may not
 * use the same element twice.
 * 
 * Your solution must use only constant extra space.
 * 
 * Example 1:
 * 
 * Input: numbers = [2,7,11,15], target = 9 Output: [1,2] Explanation: The sum
 * of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
 * 
 * Example 2:
 * 
 * Input: numbers = [2,3,4], target = 6 Output: [1,3] Explanation: The sum of 2
 * and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
 * 
 * Example 3:
 * 
 * Input: numbers = [-1,0], target = -1 Output: [1,2] Explanation: The sum of -1
 * and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
 */
public class TwoSum {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum(new int[] { 2, 7, 11, 15 }, 9)));
		System.out.println(Arrays.toString(twoSum(new int[] { 2, 3, 4 }, 6)));
		System.out.println(Arrays.toString(twoSum(new int[] { -3, -2, 4 }, -6)));
		System.out.println(Arrays.toString(twoSum(new int[] { -6, -5, -4, -3, -2, -1 }, -6)));
		System.out.println(Arrays.toString(twoSum(new int[] { -1, 0 }, -1)));
		System.out.println(Arrays.toString(twoSum(new int[] { -1 }, -1)));

		System.out.println("---");

		System.out.println((twoSumAll(new int[] { 2, 7, 11, 15 }, 9)));
		System.out.println((twoSumAll(new int[] { 2, 3, 4 }, 6)));
		System.out.println((twoSumAll(new int[] { -3, -2, 4 }, -6)));
		System.out.println((twoSumAll(new int[] { -6, -5, -4, -3, -2, -1 }, -6)));
		System.out.println((twoSumAll(new int[] { -1, 0 }, -1)));
		System.out.println((twoSumAll(new int[] { -1 }, -1)));

		System.out.println("---");

		System.out.println(Arrays.toString(twoSumPractice(new int[] { 2, 7, 11, 15 }, 9)));
		System.out.println(Arrays.toString(twoSumPractice(new int[] { 2, 3, 4 }, 6)));
		System.out.println(Arrays.toString(twoSumPractice(new int[] { -3, -2, 4 }, -6)));
		System.out.println(Arrays.toString(twoSumPractice(new int[] { -6, -5, -4, -3, -2, -1 }, -6)));
		System.out.println(Arrays.toString(twoSumPractice(new int[] { -1, 0 }, -1)));
		System.out.println(Arrays.toString(twoSumPractice(new int[] { -1 }, -1)));

		System.out.println("---");

		System.out.println((twoSumAllPractice(new int[] { 2, 7, 11, 15 }, 9)));
		System.out.println((twoSumAllPractice(new int[] { 2, 3, 4 }, 6)));
		System.out.println((twoSumAllPractice(new int[] { -3, -2, 4 }, -6)));
		System.out.println((twoSumAllPractice(new int[] { -6, -5, -4, -3, -2, -1 }, -6)));
		System.out.println((twoSumAllPractice(new int[] { -1, 0 }, -1)));
		System.out.println((twoSumAllPractice(new int[] { -1 }, -1)));

	}

	private static int[] twoSumPractice(int[] nums, int target) {
		return new int[0];
	}

	private static List<List<Integer>> twoSumAllPractice(int[] nums, int target) {
		return null;
	}

	private static int[] twoSum(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int currentSum = nums[left] + nums[right];
			if (currentSum == target)
				return new int[] { left + 1, right + 1 };
			if (currentSum < target)
				left++;
			else
				right--;
		}
		return new int[0];
	}

	private static List<List<Integer>> twoSumAll(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int twoSum = nums[left] + nums[right];
			if (twoSum == target) {
				res.add(List.of(nums[left], nums[right]));
				left++;
				right--;
			} else if (twoSum < target) {
				left++;
			} else {
				right--;
			}
		}
		return res;
	}

}
