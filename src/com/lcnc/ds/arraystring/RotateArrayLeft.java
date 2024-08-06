package com.lcnc.ds.arraystring;

import java.util.Arrays;

/**
 * Given an integer array nums, rotate the array to the right by k steps, where
 * k is non-negative.
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,4,5,6,7], k = 3 Output: [4,5,6,7,1,2,3] Explanation:
 * rotate 1 steps to the left: [2,3,4,5,6,7,1] rotate 2 steps to the left:
 * [3,4,5,6,7,1,2] rotate 3 steps to the left: [4,5,6,7,1,2,3]
 * 
 * Example 2:
 * 
 * Input: nums = [3,4,5,6,7,1,2], k = 2 Output: [5,6,7,1,2,3,4] Explanation:
 * rotate 1 steps to the left: [4,5,6,7,1,2,3] rotate 2 steps to the left:
 * [5,6,7,1,2,3,4]
 */
public class RotateArrayLeft {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(rotate(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 3)));
		System.out.println(Arrays.toString(rotate(new int[] { 3, 4, 5, 6, 7, 1, 2 }, 2)));
	}

	private static int[] rotate(int[] nums, int k) {
		k = k % nums.length;
		k = nums.length - k;
		RotateArrayRight.rotate(nums, k);
		return nums;
	}

}
