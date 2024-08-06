package com.lcnc.ds.arraystring;

/**
 * Given an array nums of size n, return the majority element.
 * 
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You
 * may assume that the majority element always exists in the array.
 * 
 * Example 1: Input: nums = [3,2,3] Output: 3
 * 
 * Example 2: Input: nums = [2,2,1,1,1,2,2] Output: 2
 */
public class MajorityElement {

	public static void main(String[] args) {
		System.out.println(majorityElement(new int[] { 3, 2, 3 }));
		System.out.println(majorityElement(new int[] { 2, 2, 1, 1, 1, 2, 2 }));

		System.out.println("---");

		System.out.println(majorityElementPractice(new int[] { 3, 2, 3 }));
		System.out.println(majorityElementPractice(new int[] { 2, 2, 1, 1, 1, 2, 2 }));
	}

	private static int majorityElementPractice(int[] nums) {
		return -1;
	}

	private static int majorityElement(int[] nums) {
		int count = 1;
		int candidate = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (count == 0)
				candidate = nums[i];

			if (nums[i] == candidate)
				count++;
			else
				count--;
		}
		return candidate;
	}

}
