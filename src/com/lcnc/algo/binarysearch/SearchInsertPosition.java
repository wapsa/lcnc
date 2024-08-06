package com.lcnc.algo.binarysearch;

/**
 * First of all, [left, right] is the possible answer range(inclusive) for this
 * question. So initially left = 0; and right = n - 1;
 * 
 * we calculate int mid = left + (right - left)/2; rather than int m = (left +
 * right)/2; to avoid overflow if target is towards the right of a very large
 * array, then left + right will go out of bounds.
 * 
 * if A[m] = target, m is exactly the position we should insert the target
 */
public class SearchInsertPosition {

	public static void main(String[] args) {
		System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 5));
		System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 2));
		System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 7));

		System.out.println("---");

		System.out.println(searchInsertPractice(new int[] { 1, 3, 5, 6 }, 5));
		System.out.println(searchInsertPractice(new int[] { 1, 3, 5, 6 }, 2));
		System.out.println(searchInsertPractice(new int[] { 1, 3, 5, 6 }, 7));
	}

	private static int searchInsertPractice(int[] nums, int target) {
		return -1;
	}

	private static int searchInsert(int[] nums, int target) {
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
		return left;
	}

}
