package com.lcnc.algo.slidingwindow;

import java.util.Arrays;

/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1,
 * or false otherwise.
 * 
 * In other words, return true if one of s1's permutations is the substring of
 * s2.
 * 
 * Example 1:
 * 
 * Input: s1 = "ab", s2 = "eidbaooo" Output: true Explanation: s2 contains one
 * permutation of s1 ("ba").
 * 
 * Example 2:
 * 
 * Input: s1 = "ab", s2 = "eidboaoo" Output: false
 */
public class PermutationInString {

	public static void main(String[] args) {
		System.out.println(checkInclusion("hello", "ooolleoooleh"));
		System.out.println(checkInclusion("adc", "dcda"));
		System.out.println(checkInclusion("ab", "eidbaooo"));
		System.out.println(checkInclusion("ab", "eidboaoo"));

		System.out.println("---");

		System.out.println(checkInclusionPractice("hello", "ooolleoooleh"));
		System.out.println(checkInclusionPractice("adc", "dcda"));
		System.out.println(checkInclusionPractice("ab", "eidbaooo"));
		System.out.println(checkInclusionPractice("ab", "eidboaoo"));

	}

	private static boolean checkInclusionPractice(String t, String s) {
		return false;
	}

	private static boolean checkInclusion(String t, String s) {
		if (t.length() > s.length())
			return false;
		int[] tFreq = new int[26];
		int[] sFreq = new int[26];
		for (int i = 0; i < t.length(); i++) {
			tFreq[t.charAt(i) - 'a']++;
			sFreq[s.charAt(i) - 'a']++;
		}
		if (Arrays.equals(tFreq, sFreq))
			return true;
		int left = 0;
		int right = t.length();
		while (right < s.length()) {
			char rightMostChar = s.charAt(right++);
			char leftMostChar = s.charAt(left++);
			sFreq[rightMostChar - 'a']++;
			sFreq[leftMostChar - 'a']--;
			if (Arrays.equals(tFreq, sFreq))
				return true;
		}
		return false;
	}

}
