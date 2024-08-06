package com.lcnc.ds.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Design a class to find the kth largest element in a stream. Note that it is
 * the kth largest element in the sorted order, not the kth distinct element.
 * 
 * Implement KthLargest class:
 * 
 * KthLargest(int k, int[] nums) Initializes the object with the integer k and
 * the stream of integers nums. int add(int val) Appends the integer val to the
 * stream and returns the element representing the kth largest element in the
 * stream.
 * 
 * Example 1:
 * 
 * Input ["KthLargest", "add", "add", "add", "add", "add"] [[3, [4, 5, 8, 2]],
 * [3], [5], [10], [9], [4]] Output [null, 4, 5, 5, 8, 8]
 * 
 * Explanation KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3); // return 4 kthLargest.add(5); // return 5
 * kthLargest.add(10); // return 5 kthLargest.add(9); // return 8
 * kthLargest.add(4); // return 8
 */
public class KthLargestElementInStream {

	public static void main(String[] args) {
		KthLargestElementInStream kthLargest = new KthLargestElementInStream(3, new int[] { 4, 5, 8, 2 });
		System.out.println(kthLargest.add(3)); // return 4
		System.out.println(kthLargest.add(5)); // return 5
		System.out.println(kthLargest.add(10)); // return 5
		System.out.println(kthLargest.add(9)); // return 8
		System.out.println(kthLargest.add(4)); // return 8
	}

	private final int k;
	private final Queue<Integer> pq;

	private KthLargestElementInStream(int k, int[] nums) {
		this.k = k;
		pq = new PriorityQueue<>(k);
		for (int val : nums) {
			pq.offer(val);
			if (pq.size() > k)
				pq.poll();
		}
	}

	private int add(int val) {
		pq.add(val);
		if (pq.size() > k)
			pq.poll();
		return pq.peek();
	}

}
