package com.lcnc.ds.arraystring;

import java.util.Arrays;

/**
 * Given an integer array nums, return an array answer such that answer[i] is
 * equal to the product of all the elements of nums except nums[i].
 * 
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
 * integer.
 * 
 * You must write an algorithm that runs in O(n) time and without using the
 * division operation.
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,4] Output: [24,12,8,6]
 * 
 * Example 2:
 * 
 * Input: nums = [-1,1,0,-3,3] Output: [0,0,9,0,0]
 */
public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(productExceptSelf(new int[] { 1, 2, 3, 4 })));
		System.out.println(Arrays.toString(productExceptSelf(new int[] { -1, 1, 0, -3, 3 })));

		System.out.println("---");

		System.out.println(Arrays.toString(productExceptSelfPractice(new int[] { 1, 2, 3, 4 })));
		System.out.println(Arrays.toString(productExceptSelfPractice(new int[] { -1, 1, 0, -3, 3 })));
	}

	private static int[] productExceptSelfPractice(int[] nums) {
		return new int[0];
	}

	private static int[] productExceptSelf(int[] nums) {
		int[] left = new int[nums.length];
		left[0] = 1;
		int[] right = new int[nums.length];
		right[nums.length - 1] = 1;
		for (int i = 1, j = nums.length - 2; i < nums.length; i++, j--) {
			left[i] = left[i - 1] * nums[i - 1];
			right[j] = right[j + 1] * nums[j + 1];
		}
		int[] res = new int[nums.length];
		for (int i = 0; i < nums.length; i++)
			res[i] = left[i] * right[i];
		return res;
	}

}
