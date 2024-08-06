package com.lcnc.ds.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an integer array nums and an integer k, return the kth largest element
 * in the array.
 * 
 * Note that it is the kth largest element in the sorted order, not the kth
 * distinct element.
 * 
 * Can you solve it without sorting?
 * 
 * Example 1:
 * 
 * Input: nums = [3,2,1,5,6,4], k = 2 Output: 5
 * 
 * Example 2:
 * 
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4 Output: 4
 */
public class KthLargestElementInArray {

	public static void main(String[] args) {
		System.out.println(findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
		System.out.println(findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4));

		System.out.println("---");

		System.out.println(findKthLargestPractice(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
		System.out.println(findKthLargestPractice(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4));
	}

	private static int findKthLargestPractice(int[] nums, int k) {
		return -1;
	}

	private static int findKthLargest(int[] nums, int k) {
		Queue<Integer> pq = new PriorityQueue<>();
		for (int val : nums) {
			pq.offer(val);
			if (pq.size() > k)
				pq.poll();
		}
		return pq.peek();
	}

}
