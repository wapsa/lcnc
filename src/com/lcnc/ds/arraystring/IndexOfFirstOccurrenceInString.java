package com.lcnc.ds.arraystring;

/**
 * Given two strings needle and haystack, return the index of the first
 * occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * 
 * Example 1:
 * 
 * Input: haystack = "sadbutsad", needle = "sad" Output: 0 Explanation: "sad"
 * occurs at index 0 and 6. The first occurrence is at index 0, so we return 0.
 * 
 * Example 2:
 * 
 * Input: haystack = "leetcode", needle = "leeto" Output: -1 Explanation:
 * "leeto" did not occur in "leetcode", so we return -1.
 */
public class IndexOfFirstOccurrenceInString {

	public static void main(String[] args) {
		System.out.println(strStr("sadbutsad", "sad"));
		System.out.println(strStr("leetcode", "leeto"));
		System.out.println(strStr("mississippi", "issip"));

		System.out.println("---");

		System.out.println(strStrPractice("sadbutsad", "sad"));
		System.out.println(strStrPractice("leetcode", "leeto"));
		System.out.println(strStrPractice("mississippi", "issip"));
	}

	public static int strStrPractice(String haystack, String needle) {
		return -1;
	}

	private static int strStr(String haystack, String needle) {
		int left = 0;
		int right = 0;
		int i = 0;
		while (right < haystack.length() && i < needle.length()) {
			if (haystack.charAt(right) == needle.charAt(i)) {
				i++;
				right++;
			} else {
				left++;
				right = left;
				i = 0;
			}
		}
		return i == needle.length() ? left : -1;
	}

}
