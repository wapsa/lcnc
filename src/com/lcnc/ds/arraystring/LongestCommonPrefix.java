package com.lcnc.ds.arraystring;

import java.util.Arrays;

/**
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1: Input: strs = ["flower","flow","flight"] Output: "fl"
 * 
 * Example 2: Input: strs = ["dog","racecar","car"] Output: "" Explanation:
 * There is no common prefix among the input strings.
 */
public class LongestCommonPrefix {

	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[] { "flower", "flow", "flight" }));
		System.out.println(longestCommonPrefix(new String[] { "dog", "racecar", "car" }));
		System.out.println(longestCommonPrefix(new String[] { "a" }));

		System.out.println("---");

		System.out.println(longestCommonPrefix1(new String[] { "flower", "flow", "flight" }));
		System.out.println(longestCommonPrefix1(new String[] { "dog", "racecar", "car" }));
		System.out.println(longestCommonPrefix1(new String[] { "a" }));

		System.out.println("---");

		System.out.println(longestCommonPrefixPractice(new String[] { "flower", "flow", "flight" }));
		System.out.println(longestCommonPrefixPractice(new String[] { "dog", "racecar", "car" }));
		System.out.println(longestCommonPrefixPractice(new String[] { "a" }));
	}

	private static String longestCommonPrefixPractice(String[] strs) {
		return null;
	}

	private static String longestCommonPrefix(String[] strs) {
		Arrays.sort(strs);
		String s1 = strs[0];
		String s2 = strs[strs.length - 1];
		StringBuilder prefix = new StringBuilder();
		for (int i = 0; i < s1.length() && i < s2.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i))
				break;
			prefix.append(s1.charAt(i));
		}
		return prefix.toString();
	}

	private static String longestCommonPrefix1(String[] strs) {
		String base = strs[0];
		int i = 0;
		outer: for (; i < base.length(); i++) {
			char baseCh = base.charAt(i);
			for (int j = 1; j < strs.length; j++) {
				String currentStr = strs[j];
				if (i == currentStr.length() || baseCh != currentStr.charAt(i))
					break outer;
			}

		}
		return base.substring(0, i);
	}

}
