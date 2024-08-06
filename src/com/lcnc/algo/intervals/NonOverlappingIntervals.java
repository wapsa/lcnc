package com.lcnc.algo.intervals;

import java.util.Arrays;

/**
 * Given an array of intervals intervals where intervals[i] = [starti, endi],
 * return the minimum number of intervals you need to remove to make the rest of
 * the intervals non-overlapping.
 * 
 * Example 1:
 * 
 * Input: intervals = [[1,2],[2,3],[3,4],[1,3]] Output: 1 Explanation: [1,3] can
 * be removed and the rest of the intervals are non-overlapping.
 * 
 * Example 2:
 * 
 * Input: intervals = [[1,2],[1,2],[1,2]] Output: 2 Explanation: You need to
 * remove two [1,2] to make the rest of the intervals non-overlapping.
 * 
 * Example 3:
 * 
 * Input: intervals = [[1,2],[2,3]] Output: 0 Explanation: You don't need to
 * remove any of the intervals since they're already non-overlapping.
 */
public class NonOverlappingIntervals {

	public static void main(String[] args) {
		System.out.println(eraseOverlapIntervals(new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } }));
		System.out.println(eraseOverlapIntervals(new int[][] { { 1, 2 }, { 1, 2 }, { 1, 2 } }));
		System.out.println(eraseOverlapIntervals(new int[][] { { 1, 2 }, { 2, 3 } }));

		System.out.println("---");

		System.out.println(eraseOverlapIntervalsPractice(new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } }));
		System.out.println(eraseOverlapIntervalsPractice(new int[][] { { 1, 2 }, { 1, 2 }, { 1, 2 } }));
		System.out.println(eraseOverlapIntervalsPractice(new int[][] { { 1, 2 }, { 2, 3 } }));
	}

	private static int eraseOverlapIntervalsPractice(int[][] intervals) {
		return -1;
	}

	private static int eraseOverlapIntervals(int[][] intervals) {
		if (intervals.length < 2)
			return 0;
		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
		int erased = 0;
		int[] prev = intervals[0];
		for (int i = 1; i < intervals.length; i++) {
			int[] curr = intervals[i];
			if (curr[0] < prev[1]) {
				prev = prev[1] < curr[1] ? prev : curr;
				erased++;
			} else
				prev = curr;
		}
		return erased;
	}

}
