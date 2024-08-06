package com.lcnc.algo.intervals;

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
 */
public class MeetingRoom4 {

	public static void main(String[] args) {
		int[] people = { 12, 6, 4 };
		int[] start = { 0, 5, 15 };
		int[] end = { 30, 10, 20 };

		int peopleMissed = minPeopleMissedMeetings(people, start, end);
		System.out.println(peopleMissed);
	}

	static class Meeting {
		int start;
		int end;
		int people;

		Meeting(int start, int end, int people) {
			this.start = start;
			this.end = end;
			this.people = people;
		}
	}

	public static int minPeopleMissedMeetings(int[] people, int[] start, int[] end) {
		int n = people.length;
		Meeting[] meetings = new Meeting[n];

		for (int i = 0; i < n; i++)
			meetings[i] = new Meeting(start[i], end[i], people[i]);

		int totalPeople = 0;
		for (int num : people) {
			totalPeople += num;
		}

		int peopleInMeetings = maxPeopleInMeetings(meetings, 0, -1, 0);
		return totalPeople - peopleInMeetings;
	}

	public static int maxPeopleInMeetings(Meeting[] meetings, int i, int lastEndTime, int currentPeople) {
		if (i == meetings.length) {
			return currentPeople;
		}
		// Exclude the current meeting
		int exclude = maxPeopleInMeetings(meetings, i + 1, lastEndTime, currentPeople);
		// Include the current meeting if it doesn't overlap with the last included
		// meeting
		int include = currentPeople;
		if (meetings[i].start >= lastEndTime) {
			include = maxPeopleInMeetings(meetings, i + 1, meetings[i].end, currentPeople + meetings[i].people);
		}
		return Math.max(include, exclude);
	}

}
