package com.lcnc.algo.slidingwindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * You are given an array of integers nums, there is a sliding window of size k
 * which is moving from the very left of the array to the very right. You can
 * only see the k numbers in the window. Each time the sliding window moves
 * right by one position.
 * 
 * Return the max sliding window.
 * 
 * Example 1:
 * 
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3 Output: [3,3,5,5,6,7]
 * 
 * Explanation: Window position Max --------------- ----- [1 3 -1] -3 5 3 6 7 3
 * 
 * 1 [3 -1 -3] 5 3 6 7 3
 * 
 * 1 3 [-1 -3 5] 3 6 7 5
 * 
 * 1 3 -1 [-3 5 3] 6 7 5
 * 
 * 1 3 -1 -3 [5 3 6] 7 6
 * 
 * 1 3 -1 -3 5 [3 6 7] 7
 * 
 * Example 2:
 * 
 * Input: nums = [1], k = 1 Output: [1]
 */
public class SlidingWindowMaximum {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3)));
		System.out.println(Arrays.toString(maxSlidingWindow(new int[] { 1 }, 1)));
		System.out.println(Arrays.toString(maxSlidingWindow(new int[] { 1, 3, 1, 2, 0, 5 }, 3)));

		System.out.println("---");

		System.out.println(Arrays.toString(maxSlidingWindowPractice(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3)));
		System.out.println(Arrays.toString(maxSlidingWindowPractice(new int[] { 1 }, 1)));
		System.out.println(Arrays.toString(maxSlidingWindowPractice(new int[] { 1, 3, 1, 2, 0, 5 }, 3)));
	}

	private static int[] maxSlidingWindowPractice(int[] nums, int k) {
		return new int[0];
	}

	// push > addFirst
	// offer > addLast
	// pop > removeFirst
	// { 1, 3, 1, 2, 0, 5 }
	private static int[] maxSlidingWindow(int[] nums, int k) {
		Deque<Integer> queue = new ArrayDeque<>();
		int[] maxSlidingWindow = new int[nums.length - k + 1];
		int i = 0;
		int left = 0;
		int right = 0;
		while (right < nums.length) {
			// remove all elements not in current window of left - right.
			while (!queue.isEmpty() && queue.getFirst() < left) {
				queue.removeFirst();
			}
			// remove all elements from queue which are less than equal to
			// rightMostNum(current num)
			while (!queue.isEmpty() && nums[queue.getLast()] <= nums[right]) {
				queue.removeLast();
			}
			// adding rightMostNum index to queue.
			queue.addLast(right);

			// when window size equals k
			if (right - left + 1 == k) {
				maxSlidingWindow[i++] = nums[queue.getFirst()];
				left++;
			}
			right++;
		}
		return maxSlidingWindow;
	}

}
