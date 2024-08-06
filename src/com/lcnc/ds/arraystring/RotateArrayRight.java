package com.lcnc.ds.arraystring;

import java.util.Arrays;

/**
 * Given an integer array nums, rotate the array to the right by k steps, where
 * k is non-negative.
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,4,5,6,7], k = 3 Output: [5,6,7,1,2,3,4] Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6] rotate 2 steps to the right:
 * [6,7,1,2,3,4,5] rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * 
 * Example 2:
 * 
 * Input: nums = [-1,-100,3,99], k = 2 Output: [3,99,-1,-100] Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3] rotate 2 steps to the right:
 * [3,99,-1,-100]
 */
public class RotateArrayRight {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(rotate(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 3)));
		System.out.println(Arrays.toString(rotate(new int[] { -1, -100, 3, 99 }, 2)));

		System.out.println("---");

		System.out.println(Arrays.toString(rotateJugglingAlgorithm(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 3)));
		System.out.println(Arrays.toString(rotateJugglingAlgorithm(new int[] { -1, -100, 3, 99 }, 2)));

		System.out.println("---");

		System.out.println(Arrays.toString(rotatePractice(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 3)));
		System.out.println(Arrays.toString(rotatePractice(new int[] { -1, -100, 3, 99 }, 2)));
	}

	public static int[] rotatePractice(int[] nums, int k) {
		return new int[0];
	}

	public static int[] rotate(int[] nums, int k) {
		k = k % nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
		return nums;
	}

	private static void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}

	/**
	 * juggling/dolphin algorithm
	 * 
	 * three-reversal algorithm is more cache-friendly because it processes the
	 * array in contiguous blocks which can be easily managed in cache.
	 * 
	 * The Juggling algorithm may have less predictable memory access patterns,
	 * potentially leading to more cache misses.
	 */
	public static int[] rotateJugglingAlgorithm(int[] nums, int k) {
		int n = nums.length;
		k = k % n;
		int count = 0;
		// loop needs to start the transitive-iteration cycles in sequence until we
		// reach to the total count of elements.
		// the number of cycles will be the GCD of k & nums.length
		for (int i = 0; count < n; i++) {
			count += iterateTransitiveCycle(nums, i, n, k);
		}
		return nums;
	}

	private static int iterateTransitiveCycle(int[] nums, int startIdx, int n, int k) {
		int count = 0;
		int pos = startIdx;
		int nextIdx = Integer.MIN_VALUE;
		int curr = nums[pos];
		// nextIdx == startIdx = one complete cycle.
		while (nextIdx != startIdx) {
			nextIdx = (pos + k) % n;
			// rotate the element
			int temp = nums[nextIdx];
			nums[nextIdx] = curr;
			curr = temp;
			pos = nextIdx;
			count++;
		}
		return count;
	}

}
