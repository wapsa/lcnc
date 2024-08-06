package com.lcnc.ds.arraystring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given an integer array nums and an integer k, return the k most frequent
 * elements. You may return the answer in any order.
 * 
 * Example 1:
 * 
 * Input: nums = [1,1,1,2,2,3], k = 2 Output: [1,2]
 * 
 * Example 2:
 * 
 * Input: nums = [1], k = 1 Output: [1]
 */
public class TopKFrequentElements {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2)));
		System.out.println(Arrays.toString(topKFrequent(new int[] { 1 }, 1)));
		System.out.println(Arrays.toString(topKFrequent(new int[] { 5, 3, 1, 1, 1, 3, 73, 1 }, 1)));
		System.out.println(Arrays.toString(topKFrequent(new int[] { 4, 1, -1, 2, -1, 2, 3 }, 2)));

		System.out.println("---");

		System.out.println(Arrays.toString(topKFrequent1(new int[] { 1, 1, 1, 2, 2, 3 }, 2)));
		System.out.println(Arrays.toString(topKFrequent1(new int[] { 1 }, 1)));
		System.out.println(Arrays.toString(topKFrequent1(new int[] { 5, 3, 1, 1, 1, 3, 73, 1 }, 1)));
		System.out.println(Arrays.toString(topKFrequent1(new int[] { 4, 1, -1, 2, -1, 2, 3 }, 2)));

		System.out.println("---");

		System.out.println(Arrays.toString(topKFrequentPractice(new int[] { 1, 1, 1, 2, 2, 3 }, 2)));
		System.out.println(Arrays.toString(topKFrequentPractice(new int[] { 1 }, 1)));
		System.out.println(Arrays.toString(topKFrequentPractice(new int[] { 5, 3, 1, 1, 1, 3, 73, 1 }, 1)));
		System.out.println(Arrays.toString(topKFrequentPractice(new int[] { 4, 1, -1, 2, -1, 2, 3 }, 2)));

	}

	private static int[] topKFrequentPractice(int[] nums, int k) {
		return new int[0];
	}

	@SuppressWarnings("unchecked")
	private static int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> numFreqMap = new HashMap<>();
		for (int num : nums)
			numFreqMap.merge(num, 1, Integer::sum);
		List<Integer>[] freqNumMap = new ArrayList[nums.length + 1];
		numFreqMap.forEach((key, val) -> {
			if (freqNumMap[val] == null)
				freqNumMap[val] = new ArrayList<>();
			freqNumMap[val].add(key);
		});
		int[] res = new int[k];
		int placeIdx = 0;
		for (int i = freqNumMap.length - 1; i >= 0; i--) {
			List<Integer> vals = freqNumMap[i];
			if (vals != null) {
				for (int j = 0; j < vals.size() && placeIdx < k; j++) {
					res[placeIdx++] = vals.get(j);
				}
			}
		}
		return res;
	}

	private static int[] topKFrequent1(int[] nums, int k) {
		Map<Integer, Integer> freq = new HashMap<>();
		for (int num : nums)
			freq.merge(num, 1, Integer::sum);

		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
				(a, b) -> Integer.compare(b.getValue(), a.getValue()));
		pq.addAll(freq.entrySet());
		int[] res = new int[k];
		for (int i = 0; i < k; i++)
			res[i] = pq.poll().getKey();
		return res;
	}

}
