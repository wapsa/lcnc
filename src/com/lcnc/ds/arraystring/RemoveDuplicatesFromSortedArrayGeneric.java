package com.lcnc.ds.arraystring;

import java.util.Arrays;

/**
 * Given an integer array nums sorted in non-decreasing order, remove some
 * duplicates in-place such that each unique element appears at most 'k' times.
 * The relative order of the elements should be kept the same.
 * 
 * Since it is impossible to change the length of the array in some languages,
 * you must instead have the result be placed in the first part of the array
 * nums. More formally, if there are k elements after removing the duplicates,
 * then the first k elements of nums should hold the final result. It does not
 * matter what you leave beyond the first k elements.
 * 
 * Return k after placing the final result in the first k slots of nums.
 * 
 * Do not allocate extra space for another array. You must do this by modifying
 * the input array in-place with O(1) extra memory.
 * 
 * Example 1: (k = 2)
 * 
 * Input: nums = [1,1,1,2,2,3] Output: 5, nums = [1,1,2,2,3,_] Explanation: Your
 * function should return k = 5, with the first five elements of nums being 1,
 * 1, 2, 2 and 3 respectively. It does not matter what you leave beyond the
 * returned k (hence they are underscores).
 * 
 * Example 2: (k = 2)
 * 
 * Input: nums = [0,0,1,1,1,1,2,3,3] Output: 7, nums = [0,0,1,1,2,3,3,_,_]
 * Explanation: Your function should return k = 7, with the first seven elements
 * of nums being 0, 0, 1, 1, 2, 3 and 3 respectively. It does not matter what
 * you leave beyond the returned k (hence they are underscores).
 */
public class RemoveDuplicatesFromSortedArrayGeneric {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(removeDuplicates(new int[] { 1, 1 }, 1)));
		System.out.println(Arrays.toString(removeDuplicates(new int[] { 1, 1 }, 3)));
		System.out.println(Arrays.toString(removeDuplicates(new int[] { 1, 1, 1, 2, 2, 3 }, 2)));
		System.out.println(Arrays.toString(removeDuplicates(new int[] { 1, 1, 1, 2, 3 }, 2)));
		System.out.println(Arrays.toString(removeDuplicates(new int[] { 0, 0, 0, 1, 1, 1, 1, 2, 3, 3, 3, 3, 3 }, 3)));
		System.out.println(Arrays.toString(removeDuplicates(new int[] { 0, 0, 0, 0, 0, 0, 0, 0 }, 2)));
		System.out.println(Arrays.toString(removeDuplicates(new int[] { 1, 2, 3, 4, 5 }, 1)));

		System.out.println("---");

		System.out.println(Arrays.toString(removeDuplicatesPractice(new int[] { 1, 1 }, 1)));
		System.out.println(Arrays.toString(removeDuplicatesPractice(new int[] { 1, 1 }, 3)));
		System.out.println(Arrays.toString(removeDuplicatesPractice(new int[] { 1, 1, 1, 2, 2, 3 }, 2)));
		System.out.println(Arrays.toString(removeDuplicatesPractice(new int[] { 1, 1, 1, 2, 3 }, 2)));
		System.out.println(
				Arrays.toString(removeDuplicatesPractice(new int[] { 0, 0, 0, 1, 1, 1, 1, 2, 3, 3, 3, 3, 3 }, 3)));
		System.out.println(Arrays.toString(removeDuplicatesPractice(new int[] { 0, 0, 0, 0, 0, 0, 0, 0 }, 2)));
		System.out.println(Arrays.toString(removeDuplicatesPractice(new int[] { 1, 2, 3, 4, 5 }, 1)));
	}

	private static int[] removeDuplicatesPractice(int[] nums, int duplicatesAllowed) {
		return new int[0];
	}

	private static int[] removeDuplicates(int[] nums, int duplicatesAllowed) {
		int j = 1;
		int count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1])
				count = 1;
			else
				count++;
			if (count <= duplicatesAllowed)
				nums[j++] = nums[i];
		}
		for (int i = j; i < nums.length; i++)
			nums[i] = -1;
		return nums;
	}

}
