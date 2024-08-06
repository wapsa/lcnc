package com.lcnc.algo.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given an array of non-overlapping intervals intervals where
 * intervals[i] = [starti, endi] represent the start and the end of the ith
 * interval and intervals is sorted in ascending order by starti. You are also
 * given an interval newInterval = [start, end] that represents the start and
 * end of another interval.
 * 
 * Insert newInterval into intervals such that intervals is still sorted in
 * ascending order by starti and intervals still does not have any overlapping
 * intervals (merge overlapping intervals if necessary).
 * 
 * Return intervals after the insertion.
 * 
 * Note that you don't need to modify intervals in-place. You can make a new
 * array and return it.
 * 
 * Example 1:
 * 
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5] Output: [[1,5],[6,9]]
 * 
 * Example 2:
 * 
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]] Explanation: Because the new interval [4,8]
 * overlaps with [3,5],[6,7],[8,10].
 */
public class InsertInterval {

	public static void main(String[] args) {
		printMatrix(insert(new int[][] { { 1, 3 }, { 6, 9 } }, new int[] { 2, 5 }));
		printMatrix(insert(new int[][] { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } }, new int[] { 4, 8 }));
		printMatrix(insert(new int[][] { { 1, 5 } }, new int[] { 2, 3 }));

		System.out.println("---");

		printMatrix(insertPractice(new int[][] { { 1, 3 }, { 6, 9 } }, new int[] { 2, 5 }));
		printMatrix(insertPractice(new int[][] { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } },
				new int[] { 4, 8 }));
		printMatrix(insertPractice(new int[][] { { 1, 5 } }, new int[] { 2, 3 }));
	}

	private static void printMatrix(int[][] matrix) {
		for (int r = 0; r < matrix.length; r++)
			System.out.print(Arrays.toString(matrix[r]));
		System.out.println();
	}

	private static int[][] insertPractice(int[][] intervals, int[] newInterval) {
		return new int[0][0];
	}

	private static int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> res = new ArrayList<>();
		int i = 0;
		int n = intervals.length;
		// no overlappings
		while (i < n && intervals[i][1] < newInterval[0])
			res.add(intervals[i++]);
		// overlapping start
		if (i < n)
			newInterval[0] = Math.min(newInterval[0], intervals[i][0]);

		while (i < n && newInterval[1] >= intervals[i][0]) {
			newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
			i++;
		}
		res.add(newInterval);
		// overlapping end
		while (i < n)
			res.add(intervals[i++]);
		return res.toArray(int[][]::new);
	}

}
