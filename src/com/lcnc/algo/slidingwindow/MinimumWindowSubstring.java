package com.lcnc.algo.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum
 * window substring of s such that every character in t (including duplicates)
 * is included in the window. If there is no such substring, return the empty
 * string "".
 * 
 * The testcases will be generated such that the answer is unique.
 * 
 * Example 1:
 * 
 * Input: s = "ADOBECODEBANC", t = "ABC" Output: "BANC" Explanation: The minimum
 * window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * 
 * Example 2:
 * 
 * Input: s = "a", t = "a" Output: "a" Explanation: The entire string s is the
 * minimum window.
 * 
 * Example 3:
 * 
 * Input: s = "a", t = "aa" Output: "" Explanation: Both 'a's from t must be
 * included in the window. Since the largest window of s only has one 'a',
 * return empty string.
 */
public class MinimumWindowSubstring {

	public static void main(String[] args) {
		System.out.println(minWindow("a", "aa"));
		System.out.println(minWindow("a", "b"));
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
		System.out.println(minWindow("a", "a"));

		System.out.println("---");

		System.out.println(minWindowPractice("a", "aa"));
		System.out.println(minWindowPractice("a", "b"));
		System.out.println(minWindowPractice("ADOBECODEBANC", "ABC"));
		System.out.println(minWindowPractice("a", "a"));

	}

	private static String minWindowPractice(String s, String t) {
		return null;
	}

	private static String minWindow(String s, String t) {
		String minLengthSubstring = "";
		if (t.length() > s.length())
			return minLengthSubstring;
		Map<Character, Integer> requiredFreq = new HashMap<>();
		Map<Character, Integer> windowFreq = new HashMap<>();
		for (Character ch : t.toCharArray()) {
			requiredFreq.merge(ch, 1, Integer::sum);
			windowFreq.put(ch, 0);
		}
		int current = 0;
		int left = 0;
		int right = 0;
		while (right < s.length()) {
			Character rightMostChar = s.charAt(right);
			if (windowFreq.containsKey(rightMostChar)) {
				windowFreq.put(rightMostChar, windowFreq.get(rightMostChar) + 1);
				if (windowFreq.get(rightMostChar) <= requiredFreq.get(rightMostChar))
					current++;
			}
			while (current == t.length()) {
				if ((right + 1 - left) < minLengthSubstring.length() || minLengthSubstring.isBlank()) {
					minLengthSubstring = s.substring(left, right + 1);
				}
				Character leftMostChar = s.charAt(left++);
				if (windowFreq.containsKey(leftMostChar)) {
					windowFreq.put(leftMostChar, windowFreq.get(leftMostChar) - 1);
					if (windowFreq.get(leftMostChar) < requiredFreq.get(leftMostChar))
						current--;
				}
			}
			right++;
		}
		return minLengthSubstring;
	}

}
