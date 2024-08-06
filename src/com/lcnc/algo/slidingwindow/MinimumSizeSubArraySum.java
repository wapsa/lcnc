package com.lcnc.algo.slidingwindow;

/**
 * Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a subarray whose sum is greater than or equal to
 * target. If there is no such subarray, return 0 instead.
 * 
 * Example 1:
 * 
 * Input: target = 7, nums = [2,3,1,2,4,3] Output: 2 Explanation: The subarray
 * [4,3] has the minimal length under the problem constraint.
 * 
 * Example 2:
 * 
 * Input: target = 4, nums = [1,4,4] Output: 1
 * 
 * Example 3:
 * 
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1] Output: 0
 */
public class MinimumSizeSubArraySum {

	public static void main(String[] args) {
		System.out.println(minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 }));
		System.out.println(minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 0 }));
		System.out.println(minSubArrayLen(4, new int[] { 1, 4, 4 }));
		System.out.println(minSubArrayLen(11, new int[] { 1, 1, 1, 1, 1, 1, 1, 1 }));

		System.out.println("---");

		System.out.println(minSubArrayLenPractice(7, new int[] { 2, 3, 1, 2, 4, 3 }));
		System.out.println(minSubArrayLenPractice(7, new int[] { 2, 3, 1, 2, 4, 0 }));
		System.out.println(minSubArrayLenPractice(4, new int[] { 1, 4, 4 }));
		System.out.println(minSubArrayLenPractice(11, new int[] { 1, 1, 1, 1, 1, 1, 1, 1 }));
	}

	private static int minSubArrayLenPractice(int target, int[] nums) {
		return -1;
	}

	private static int minSubArrayLen(int target, int[] nums) {
		int left = 0;
		int right = 0;
		int currentWindowSum = 0;
		int minSubArraySize = Integer.MAX_VALUE;
		while (right < nums.length) {
			currentWindowSum += nums[right];
			while (currentWindowSum >= target) {
				minSubArraySize = Math.min(minSubArraySize, (right - left + 1));
				currentWindowSum -= nums[left++];
			}
			right++;
		}
		return minSubArraySize == Integer.MAX_VALUE ? 0 : minSubArraySize;
	}

}
