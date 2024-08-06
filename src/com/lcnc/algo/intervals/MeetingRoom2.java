package com.lcnc.algo.intervals;

import java.util.Arrays;

/**
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms
 * required.
 * 
 * Example1
 * 
 * Input: intervals = [(0,30),(5,10),(15,20)] Output: 2 Explanation: We need two
 * meeting rooms room1: (0,30) room2: (5,10),(15,20)
 * 
 * Example2
 * 
 * Input: intervals = [(2,7)] Output: 1 Explanation: Only need one meeting room
 */
public class MeetingRoom2 {

	public static void main(String[] args) {
		System.out.println(minMeetingRooms(new int[][] { { 0, 30 }, { 5, 10 }, { 15, 20 } }));
		System.out.println(minMeetingRooms(new int[][] { { 5, 8 } }));

		System.out.println("---");

		System.out.println(minMeetingRoomsPractice(new int[][] { { 0, 30 }, { 5, 10 }, { 15, 20 } }));
		System.out.println(minMeetingRoomsPractice(new int[][] { { 5, 8 } }));
	}

	private static int minMeetingRoomsPractice(int[][] intervals) {
		return -1;
	}

	private static int minMeetingRooms(int[][] intervals) {
		int[] starts = new int[intervals.length];
		int[] ends = new int[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			starts[i] = intervals[i][0];
			ends[i] = intervals[i][1];
		}
		Arrays.sort(starts);
		Arrays.sort(ends);
		int maxCount = 0;
		int currentCount = 0;
		int si = 0;
		int ei = 0;
		while (si < starts.length) {
			if (ends[ei] <= starts[si]) {
				currentCount--;
				ei++;
			} else {
				currentCount++;
				si++;
			}
			maxCount = Math.max(maxCount, currentCount);
		}
		return maxCount;
	}

}
