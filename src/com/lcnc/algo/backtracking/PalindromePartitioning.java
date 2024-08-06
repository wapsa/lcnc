package com.lcnc.algo.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome . Return all possible palindrome partitioning of s.
 * 
 * Example 1:
 * 
 * Input: s = "aab" Output: [["a","a","b"],["aa","b"]]
 * 
 * Example 2:
 * 
 * Input: s = "a" Output: [["a"]]
 * 
 */
public class PalindromePartitioning {

	public static void main(String[] args) {
		System.out.println(partition("aab"));
		System.out.println(partition("a"));

		System.out.println("---");

		System.out.println(partitionPractice("aab"));
		System.out.println(partitionPractice("a"));
	}

	private static List<List<String>> partitionPractice(String s) {
		List<List<String>> res = new ArrayList<>();
		return res;
	}

	private static List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<>();
		partition(s, 0, new ArrayList<>(), res);
		return res;
	}

	private static void partition(String s, int left, List<String> output, List<List<String>> res) {
		if (left == s.length()) {
			res.add(new ArrayList<>(output));
			return;
		}
		for (int right = left; right < s.length(); right++) {
			if (isPalindrome(s, left, right)) {
				output.add(s.substring(left, right + 1));
				partition(s, right + 1, output, res);
				output.remove(output.size() - 1);
			}
		}
	}

	private static boolean isPalindrome(String s, int left, int right) {
		while (left < right) {
			if (s.charAt(left) != s.charAt(right))
				return false;
			left++;
			right--;
		}
		return true;
	}

}
