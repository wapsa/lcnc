package com.lcnc.algo.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without repeating
 * characters.
 * 
 * Example 1:
 * 
 * Input: s = "abcabcbb" Output: 3 Explanation: The answer is "abc", with the
 * length of 3.
 * 
 * Example 2:
 * 
 * Input: s = "bbbbb" Output: 1 Explanation: The answer is "b", with the length
 * of 1.
 * 
 * Example 3:
 * 
 * Input: s = "pwwkew" Output: 3 Explanation: The answer is "wke", with the
 * length of 3. Notice that the answer must be a substring, "pwke" is a
 * subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("bbbbb"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
		System.out.println(lengthOfLongestSubstring("aabcd"));

		System.out.println("---");

		System.out.println(lengthOfLongestSubstringPractice("abcabcbb"));
		System.out.println(lengthOfLongestSubstringPractice("bbbbb"));
		System.out.println(lengthOfLongestSubstringPractice("pwwkew"));
		System.out.println(lengthOfLongestSubstringPractice("aabcd"));
	}

	private static int lengthOfLongestSubstringPractice(String s) {
		return -1;
	}

	private static int lengthOfLongestSubstring(String s) {
		Set<Character> windowChars = new HashSet<>();
		int left = 0;
		int right = 0;
		int res = 0;
		while (right < s.length()) {
			Character currentCh = s.charAt(right);
			while (windowChars.contains(currentCh))
				windowChars.remove(s.charAt(left++));
			windowChars.add(currentCh);
			res = Math.max(res, windowChars.size());
			right++;
		}
		return res;
	}

}
