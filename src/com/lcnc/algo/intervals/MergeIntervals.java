package com.lcnc.algo.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all
 * overlapping intervals, and return an array of the non-overlapping intervals
 * that cover all the intervals in the input.
 * 
 * Example 1:
 * 
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]] Output:
 * [[1,6],[8,10],[15,18]] Explanation: Since intervals [1,3] and [2,6] overlap,
 * merge them into [1,6].
 * 
 * Example 2:
 * 
 * Input: intervals = [[1,4],[4,5]] Output: [[1,5]] Explanation: Intervals [1,4]
 * and [4,5] are considered overlapping.
 */
public class MergeIntervals {

	public static void main(String[] args) {
		printMatrix(merge(new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } }));
		printMatrix(merge(new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 9, 18 } }));
		printMatrix(merge(new int[][] { { 1, 4 }, { 4, 5 } }));

		System.out.println("---");

		printMatrix(mergePractice(new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } }));
		printMatrix(mergePractice(new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 9, 18 } }));
		printMatrix(mergePractice(new int[][] { { 1, 4 }, { 4, 5 } }));
	}

	private static void printMatrix(int[][] matrix) {
		for (int r = 0; r < matrix.length; r++)
			System.out.print(Arrays.toString(matrix[r]));
		System.out.println();
	}

	private static int[][] mergePractice(int[][] intervals) {
		return new int[0][0];
	}

	private static int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		List<int[]> res = new ArrayList<>();
		int[] prev = intervals[0];
		for (int i = 1; i < intervals.length; i++) {
			int[] curr = intervals[i];
			if (prev[1] >= curr[0])
				prev[1] = Math.max(prev[1], curr[1]);
			else {
				res.add(prev);
				prev = curr;
			}
		}
		res.add(prev);
		return res.toArray(i -> new int[i][i]);
	}

}
