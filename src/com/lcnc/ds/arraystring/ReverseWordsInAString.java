package com.lcnc.ds.arraystring;

/**
 * Given an input string s, reverse the order of the words.
 * 
 * A word is defined as a sequence of non-space characters. The words in s will
 * be separated by at least one space.
 * 
 * Return a string of the words in reverse order concatenated by a single space.
 * 
 * Note that s may contain leading or trailing spaces or multiple spaces between
 * two words. The returned string should only have a single space separating the
 * words. Do not include any extra spaces.
 * 
 * Example 1:
 * 
 * Input: s = "the sky is blue" Output: "blue is sky the"
 * 
 * Example 2:
 * 
 * Input: s = " hello world " Output: "world hello" Explanation: Your reversed
 * string should not contain leading or trailing spaces.
 * 
 * Example 3:
 * 
 * Input: s = "a good example" Output: "example good a" Explanation: You need to
 * reduce multiple spaces between two words to a single space in the reversed
 * string.
 */
public class ReverseWordsInAString {

	public static void main(String[] args) {
		System.out.println(reverseWords("the sky is blue"));
		System.out.println(reverseWords("  hello world  "));
		System.out.println(reverseWords("a good   example"));

		System.out.println("---");

		System.out.println(reverseWordsPractice("the sky is blue"));
		System.out.println(reverseWordsPractice("  hello world  "));
		System.out.println(reverseWordsPractice("a good   example"));
	}

	private static String reverseWordsPractice(String s) {
		return null;
	}

	private static String reverseWords(String s) {
		String[] words = s.strip().split("\\s+");
		StringBuilder res = new StringBuilder();
		for (int i = words.length - 1; i >= 1; i--) {
			res.append(words[i] + " ");
		}
		return res.append(words[0]).toString();
	}

}
