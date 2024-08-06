package com.lcnc.algo.twopointer;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into
 * lowercase letters and removing all non-alphanumeric characters, it reads the
 * same forward and backward. Alphanumeric characters include letters and
 * numbers.
 * 
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * 
 * Example 1: Input: s = "A man, a plan, a canal: Panama" Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * 
 * Example 2: Input: s = "race a car" Output: false Explanation: "raceacar" is
 * not a palindrome.
 * 
 * Example 3: Input: s = " " Output: true Explanation: s is an empty string ""
 * after removing non-alphanumeric characters. Since an empty string reads the
 * same forward and backward, it is a palindrome.
 */
public class IsSubsequence {

	public static void main(String[] args) {
		System.out.println(isSubsequence("abc", "ahbgdc"));
		System.out.println(isSubsequence("axc", "ahbgdc"));
		System.out.println(isSubsequence("", "ahbgdc"));
		System.out.println(isSubsequence("", ""));

		System.out.println("---");

		System.out.println(isSubsequencePractice("abc", "ahbgdc"));
		System.out.println(isSubsequencePractice("axc", "ahbgdc"));
		System.out.println(isSubsequencePractice("", "ahbgdc"));
		System.out.println(isSubsequencePractice("", ""));
	}

	private static boolean isSubsequencePractice(String s, String t) {
		return false;
	}

	private static boolean isSubsequence(String s, String t) {
		int si = 0;
		int ti = 0;
		while (si < s.length() && ti < t.length()) {
			if (s.charAt(si) == t.charAt(ti))
				si++;
			ti++;
		}
		return si == s.length();
	}

}
