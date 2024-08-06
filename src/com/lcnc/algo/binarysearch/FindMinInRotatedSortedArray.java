package com.lcnc.algo.binarysearch;

/**
 * Suppose an array of length n sorted in ascending order is rotated between 1
 * and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
 * 
 * [4,5,6,7,0,1,2] if it was rotated 4 times. [0,1,2,4,5,6,7] if it was rotated
 * 7 times. Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time
 * results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 * 
 * Given the sorted rotated array nums of unique elements, return the minimum
 * element of this array.
 * 
 * You must write an algorithm that runs in O(log n) time.
 * 
 * Example 1:
 * 
 * Input: nums = [3,4,5,1,2] Output: 1 Explanation: The original array was
 * [1,2,3,4,5] rotated 3 times.
 * 
 * Example 2:
 * 
 * Input: nums = [4,5,6,7,0,1,2] Output: 0 Explanation: The original array was
 * [0,1,2,4,5,6,7] and it was rotated 4 times.
 * 
 * Example 3:
 * 
 * Input: nums = [11,13,15,17] Output: 11 Explanation: The original array was
 * [11,13,15,17] and it was rotated 4 times.
 * 
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/solutions/158940/beat-100-very-simple-python-very-detailed-explanation/
 */
public class FindMinInRotatedSortedArray {

	public static void main(String[] args) {
		System.out.println(findMin(new int[] { 3, 4, 5, 1, 2 }));
		System.out.println(findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 }));
		System.out.println(findMin(new int[] { 11, 13, 15, 17 }));

		System.out.println("---");

		System.out.println(findMinPractice(new int[] { 3, 4, 5, 1, 2 }));
		System.out.println(findMinPractice(new int[] { 4, 5, 6, 7, 0, 1, 2 }));
		System.out.println(findMinPractice(new int[] { 11, 13, 15, 17 }));
	}

	private static int findMinPractice(int[] nums) {
		return -1;
	}

	private static int findMin(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			/*
			 * the main idea for our checks is to converge the left and right bounds on the
			 * start of the pivot, and never disqualify the index for a possible minimum
			 * value. in normal binary search, we have a target to match exactly, and would
			 * have a specific branch for if nums[mid] == target. we do not have a specific
			 * target here, so we just have simple if/else.
			 */
			if (nums[mid] > nums[right])
				/*
				 * we KNOW the pivot must be to the right of the middle: if nums[mid] >
				 * nums[right], we KNOW that the pivot/minimum value must have occurred
				 * somewhere to the right of mid, which is why the values wrapped around and
				 * became smaller.
				 * 
				 * example: [3,4,5,6,7,8,9,1,2] in the first iteration, when we start with mid
				 * index = 4, right index = 9. if nums[mid] > nums[right], we know that at some
				 * point to the right of mid, the pivot must have occurred, which is why the
				 * values wrapped around so that nums[right] is less then nums[mid]
				 * 
				 * we know that the number at mid is greater than at least one number to the
				 * right, so we can use mid + 1 and never consider mid again; we know there is
				 * at least one value smaller than it on the right
				 */
				left = mid + 1;
			else
				/*
				 * here, nums[mid] <= nums[right]: we KNOW the pivot must be at mid or to the
				 * left of mid: if nums[mid] <= nums[right], we KNOW that the pivot was not
				 * encountered to the right of middle, because that means the values would wrap
				 * around and become smaller (which is caught in the above if statement). this
				 * leaves the possible pivot point to be at index <= mid.
				 * 
				 * example: [8,9,1,2,3,4,5,6,7] in the first iteration, when we start with mid
				 * index = 4, right index = 9. if nums[mid] <= nums[right], we know the numbers
				 * continued increasing to the right of mid, so they never reached the pivot and
				 * wrapped around. therefore, we know the pivot must be at index <= mid.
				 * 
				 * we know that nums[mid] <= nums[right]. therefore, we know it is possible for
				 * the mid index to store a smaller value than at least one other index in the
				 * list (at right), so we do not discard it by doing right = mid - 1. it still
				 * might have the minimum value.
				 */
				right = mid;
		}
		/*
		 * at this point, left and right converge to a single index (for minimum value)
		 * since our if/else forces the bounds of left/right to shrink each iteration:
		 * 
		 * when left bound increases, it does not disqualify a value that could be
		 * smaller than something else (we know nums[mid] > nums[right], so nums[right]
		 * wins and we ignore mid and everything to the left of mid).
		 * 
		 * when right bound decreases, it also does not disqualify a value that could be
		 * smaller than something else (we know nums[mid] <= nums[right], so nums[mid]
		 * wins and we keep it for now).
		 * 
		 * so we shrink the left/right bounds to one value, without ever disqualifying a
		 * possible minimum
		 */
		return nums[left];
	}

}
