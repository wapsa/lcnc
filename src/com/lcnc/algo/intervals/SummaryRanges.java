package com.lcnc.algo.intervals;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given a sorted unique integer array nums.
 * 
 * A range [a,b] is the set of all integers from a to b (inclusive).
 * 
 * Return the smallest sorted list of ranges that cover all the numbers in the
 * array exactly. That is, each element of nums is covered by exactly one of the
 * ranges, and there is no integer x such that x is in one of the ranges but not
 * in nums.
 * 
 * Each range [a,b] in the list should be output as:
 * 
 * "a->b" if a != b "a" if a == b
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [0,1,2,4,5,7] Output: ["0->2","4->5","7"] Explanation: The
 * ranges are: [0,2] --> "0->2" [4,5] --> "4->5" [7,7] --> "7"
 * 
 * Example 2:
 * 
 * Input: nums = [0,2,3,4,6,8,9] Output: ["0","2->4","6","8->9"] Explanation:
 * The ranges are: [0,0] --> "0" [2,4] --> "2->4" [6,6] --> "6" [8,9] --> "8->9"
 */
public class SummaryRanges {

	public static void main(String[] args) {
		System.out.println(summaryRanges(new int[] { 1 }));
		System.out.println(summaryRanges(new int[] { 0, 1, 2, 4, 5, 7 }));
		System.out.println(summaryRanges(new int[] { 0, 2, 3, 4, 6, 8, 9 }));

		System.out.println("---");

		System.out.println(summaryRanges(new int[] { 1 }));
		System.out.println(summaryRangesPractice(new int[] { 0, 1, 2, 4, 5, 7 }));
		System.out.println(summaryRangesPractice(new int[] { 0, 2, 3, 4, 6, 8, 9 }));
	}

	private static List<String> summaryRangesPractice(int[] nums) {
		return null;
	}

	private static List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<>();
		int left = 0;
		int right = 0;
		while (right < nums.length) {
			if (right + 1 < nums.length && nums[right + 1] - nums[right] == 1) {
				right++;
				continue;
			}
			if (left == right)
				res.add(String.valueOf(nums[left]));
			else
				res.add(nums[left] + "->" + nums[right]);
			right++;
			left = right;
		}
		return res;
	}

}
