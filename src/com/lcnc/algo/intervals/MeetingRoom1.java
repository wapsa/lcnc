package com.lcnc.algo.intervals;

import java.util.Arrays;

/**
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all
 * meetings.
 * 
 * Example1
 * 
 * Input: intervals = [(0,30),(5,10),(15,20)] Output: false Explanation: (0,30),
 * (5,10) and (0,30),(15,20) will conflict
 * 
 * Example2
 * 
 * Input: intervals = [(5,8),(9,15)] Output: true Explanation: Two times will
 * not conflict
 */
public class MeetingRoom1 {

	public static void main(String[] args) {
		System.out.println(canAttendMeetings(new int[][] { { 0, 30 }, { 5, 10 }, { 15, 20 } }));
		System.out.println(canAttendMeetings(new int[][] { { 5, 8 }, { 9, 15 } }));

		System.out.println("---");

		System.out.println(canAttendMeetingsPractice(new int[][] { { 0, 30 }, { 5, 10 }, { 15, 20 } }));
		System.out.println(canAttendMeetingsPractice(new int[][] { { 5, 8 }, { 9, 15 } }));
	}

	private static boolean canAttendMeetingsPractice(int[][] intervals) {
		return false;
	}

	private static boolean canAttendMeetings(int[][] intervals) {
		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
		int prevEnd = intervals[0][1];
		for (int i = 1; i < intervals.length; i++) {
			int[] curr = intervals[i];
			if (curr[0] < prevEnd)
				return false;
			prevEnd = Math.max(curr[1], prevEnd);
		}
		return true;
	}

}
