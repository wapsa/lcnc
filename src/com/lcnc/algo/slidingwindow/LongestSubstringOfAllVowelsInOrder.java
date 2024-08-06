package com.lcnc.algo.slidingwindow;

import java.util.Set;

/**
 * A string is considered beautiful if it satisfies the following conditions:
 * 
 * Each of the 5 English vowels ('a', 'e', 'i', 'o', 'u') must appear at least
 * once in it. The letters must be sorted in alphabetical order (i.e. all 'a's
 * before 'e's, all 'e's before 'i's, etc.). For example, strings "aeiou" and
 * "aaaaaaeiiiioou" are considered beautiful, but "uaeio", "aeoiu", and
 * "aaaeeeooo" are not beautiful.
 * 
 * Given a string word consisting of English vowels, return the length of the
 * longest beautiful substring of word. If no such substring exists, return 0.
 * 
 * A substring is a contiguous sequence of characters in a string.
 * 
 * Example 1:
 * 
 * Input: word = "aeiaaioaaaaeiiiiouuuooaauuaeiu" Output: 13 Explanation: The
 * longest beautiful substring in word is "aaaaeiiiiouuu" of length 13.
 * 
 * Example 2:
 * 
 * Input: word = "aeeeiiiioooauuuaeiou" Output: 5 Explanation: The longest
 * beautiful substring in word is "aeiou" of length 5.
 * 
 * Example 3:
 * 
 * Input: word = "a" Output: 0 Explanation: There is no beautiful substring, so
 * return 0.
 */
public class LongestSubstringOfAllVowelsInOrder {

	public static void main(String[] args) {
		System.out.println(longestBeautifulSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu"));
		System.out.println(longestBeautifulSubstring("aeeeiiiioooauuuaeiou"));
		System.out.println(longestBeautifulSubstring("a"));
		System.out.println(longestBeautifulSubstring("aeiou"));

		System.out.println("---");

		System.out.println(longestBeautifulSubstringPractice("aeiaaioaaaaeiiiiouuuooaauuaeiu"));
		System.out.println(longestBeautifulSubstringPractice("aeeeiiiioooauuuaeiou"));
		System.out.println(longestBeautifulSubstringPractice("a"));
		System.out.println(longestBeautifulSubstringPractice("aeiou"));
	}

	private static String longestBeautifulSubstringPractice(String word) {
		return null;
	}

	private static String longestBeautifulSubstring(String word) {
		Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
		String longestSubstring = "";
		int count = 0;
		int left = 0;
		int right = 0;
		while (right < word.length()) {
			char rightMostChar = word.charAt(right);

			// Ensure the current character is a vowel otherwise reset.
			if (!vowels.contains(rightMostChar)) {
				count = 0;
				right++;
				left = right;
				continue;
			}

			// if vowel not in order, start new sequence from right.
			if (right > 0 && rightMostChar < word.charAt(right - 1)) {
				count = 1;
				left = right;
			}

			// if we get next vowel increase count.
			if (right == 0 || rightMostChar > word.charAt(right - 1)) {
				count++;
			}

			if (count == 5) {
				int currentLength = right - left + 1;
				if (currentLength > longestSubstring.length())
					longestSubstring = word.substring(left, right + 1);
			}
			right++;
		}
		return longestSubstring;
	}

}
