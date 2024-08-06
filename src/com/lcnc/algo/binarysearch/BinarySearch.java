package com.lcnc.algo.binarysearch;

/**
 * Given an array of integers nums which is sorted in ascending order, and an
 * integer target, write a function to search target in nums. If target exists,
 * then return its index. Otherwise, return -1.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * Example 1:
 * 
 * Input: nums = [-1,0,3,5,9,12], target = 9 Output: 4 Explanation: 9 exists in
 * nums and its index is 4
 * 
 * Example 2:
 * 
 * Input: nums = [-1,0,3,5,9,12], target = 2 Output: -1 Explanation: 2 does not
 * exist in nums so return -1
 */
public class BinarySearch {

	public static void main(String[] args) {
		System.out.println(search(new int[] { -1, 0, 3, 5, 9, 12 }, 9));
		System.out.println(search(new int[] { -1, 0, 3, 5, 9, 12 }, 2));

		System.out.println("---");

		System.out.println(searchPractice(new int[] { -1, 0, 3, 5, 9, 12 }, 9));
		System.out.println(searchPractice(new int[] { -1, 0, 3, 5, 9, 12 }, 2));
	}

	private static int searchPractice(int[] nums, int target) {
		return -1;
	}

	private static int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (target == nums[mid])
				return mid;
			if (target < nums[mid])
				right = mid - 1;
			else
				left = mid + 1;
		}
		return -1;
	}

}
