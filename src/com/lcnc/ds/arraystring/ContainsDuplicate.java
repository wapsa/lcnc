package com.lcnc.ds.arraystring;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums, return true if any value appears at least twice
 * in the array, and return false if every element is distinct.
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,1] Output: true
 * 
 * Example 2:
 * 
 * Input: nums = [1,2,3,4] Output: false
 * 
 * Example 3:
 * 
 * Input: nums = [1,1,1,3,3,4,3,2,4,2] Output: true
 */
public class ContainsDuplicate {

	public static void main(String[] args) {
		System.out.println(containsDuplicate(new int[] { 1, 2, 3, 1 }));
		System.out.println(containsDuplicate(new int[] { 1, 2, 3, 4 }));
		System.out.println(containsDuplicate(new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }));

		System.out.println("---");

		System.out.println(containsDuplicatePractice(new int[] { 1, 2, 3, 1 }));
		System.out.println(containsDuplicatePractice(new int[] { 1, 2, 3, 4 }));
		System.out.println(containsDuplicatePractice(new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }));
	}

	private static boolean containsDuplicatePractice(int[] nums) {
		return false;
	}

	private static boolean containsDuplicate(int[] nums) {
		Set<Integer> store = new HashSet<>();
		for (Integer num : nums) {
			if (store.contains(num))
				return true;
			store.add(num);
		}
		return false;
	}

}
