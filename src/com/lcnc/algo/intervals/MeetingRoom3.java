package com.lcnc.algo.intervals;

import java.util.Arrays;

/**
 * An organization contain many groups of people. The number of members in each
 * group is given in people array:
 * 
 * people = [5,6,4]
 * 
 * There is only one conference room. Each group wants to have a meeting. The
 * start and end time of each meeting is given in two arrays:
 * 
 * start = [0,5,15]
 * 
 * end = [30,10,20]
 * 
 * Schedule meetings such that minimum number of people wont get chance to have
 * a meeting. Return how many people dont get chance to have a meeting.
 * 
 * Meeting having more number of people should get priority.
 */
public class MeetingRoom3 {

	public static void main(String[] args) {
		int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
		int[] people = { 5, 6, 4 };

		int result = minPeopleWithoutMeeting(intervals, people);
		System.out.println(result); // Output should be the number of people who won't get a chance to have a
									// meeting
	}

	private static class Meeting {
		int start;
		int end;
		int people;

		Meeting(int start, int end, int people) {
			this.start = start;
			this.end = end;
			this.people = people;
		}
	}

	public static int minPeopleWithoutMeeting(int[][] intervals, int[] people) {
		Meeting[] meetings = new Meeting[intervals.length];
		for (int i = 0; i < intervals.length; i++)
			meetings[i] = new Meeting(intervals[i][0], intervals[i][1], people[i]);

		// Sort meetings by the number of people in descending order, then by end time
		Arrays.sort(meetings, (m1, m2) -> {
			if (m1.people != m2.people)
				return Integer.compare(m2.people, m1.people);
			else
				return Integer.compare(m1.end, m2.end);
		});

		int totalPeople = 0;
		int totalPeopleWithMeeting = 0;

		int lastEndTime = -1;
		for (Meeting meeting : meetings) {
			totalPeople += meeting.people;
			if (meeting.start >= lastEndTime) {
				lastEndTime = meeting.end;
				totalPeopleWithMeeting += meeting.people;
			}
		}
		return totalPeople - totalPeopleWithMeeting;
	}

}
