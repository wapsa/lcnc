package com.lcnc.ds.arraystring.extra;

import java.util.Arrays;

/**
 * Given an array nums with n objects colored red, white, or blue, sort them
 * in-place so that objects of the same color are adjacent, with the colors in
 * the order red, white, and blue.
 * 
 * We will use the integers 0, 1, and 2 to represent the color red, white, and
 * blue, respectively.
 * 
 * You must solve this problem without using the library's sort function.
 * 
 * Example 1:
 * 
 * Input: nums = [2,0,2,1,1,0] Output: [0,0,1,1,2,2]
 * 
 * Example 2:
 * 
 * Input: nums = [2,0,1] Output: [0,1,2]
 */
public class SortColors {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(sortColors(new int[] { 2, 0, 2, 1, 1, 0 })));
		System.out.println(Arrays.toString(sortColors(new int[] { 2, 0, 1 })));

		System.out.println("---");

		System.out.println(Arrays.toString(sortColorsPractice(new int[] { 2, 0, 2, 1, 1, 0 })));
		System.out.println(Arrays.toString(sortColorsPractice(new int[] { 2, 0, 1 })));
	}

	private static int[] sortColorsPractice(int[] nums) {
		return new int[0];
	}

	private static int[] sortColors(int[] nums) {

		return nums;
	}
}
