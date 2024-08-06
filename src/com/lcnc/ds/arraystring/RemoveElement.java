package com.lcnc.ds.arraystring;

import java.util.Arrays;

/**
 * Given an integer array nums and an integer val, remove all occurrences of val
 * in nums in-place. The order of the elements may be changed. Then return the
 * number of elements in nums which are not equal to val.
 * 
 * Consider the number of elements in nums which are not equal to val be k, to
 * get accepted, you need to do the following things:
 * 
 * Change the array nums such that the first k elements of nums contain the
 * elements which are not equal to val. The remaining elements of nums are not
 * important as well as the size of nums. Return k. Custom Judge:
 * 
 * If all assertions pass, then your solution will be accepted.
 * 
 * Example 1:
 * 
 * Input: nums = [3,2,2,3], val = 3 Output: 2, nums = [2,2,_,_] Explanation:
 * Your function should return k = 2, with the first two elements of nums being
 * 2. It does not matter what you leave beyond the returned k (hence they are
 * underscores).
 * 
 * Example 2:
 * 
 * Input: nums = [0,1,2,2,3,0,4,2], val = 2 Output: 5, nums = [0,1,4,0,3,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements
 * of nums containing 0, 0, 1, 3, and 4. Note that the five elements can be
 * returned in any order. It does not matter what you leave beyond the returned
 * k (hence they are underscores).
 */
public class RemoveElement {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(removeElement(new int[] { 2, 2, 2, 3 }, 3)));
		System.out.println(Arrays.toString(removeElement(new int[] { 3, 2, 2, 3 }, 3)));
		System.out.println(Arrays.toString(removeElement(new int[] { 0, 1, 2, 2, 3, 0, 4, 2 }, 2)));

		System.out.println("---");

		System.out.println(Arrays.toString(removeElementPractice(new int[] { 2, 2, 2, 3 }, 3)));
		System.out.println(Arrays.toString(removeElementPractice(new int[] { 3, 2, 2, 3 }, 3)));
		System.out.println(Arrays.toString(removeElementPractice(new int[] { 0, 1, 2, 2, 3, 0, 4, 2 }, 2)));
	}

	private static int[] removeElementPractice(int[] nums, int val) {
		return new int[0];
	}

	private static int[] removeElement(int[] nums, int val) {
		int j = 0;
		for (int i = 0; i < nums.length; i++)
			if (nums[i] != val)
				nums[j++] = nums[i];
		for (int i = j; i < nums.length; i++)
			nums[i] = -1;
		return nums;
	}

}
