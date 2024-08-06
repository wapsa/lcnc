package com.lcnc.algo.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given a string s and an integer k. You can choose any character of
 * the string and change it to any other uppercase English character. You can
 * perform this operation at most k times.
 * 
 * Return the length of the longest substring containing the same letter you can
 * get after performing the above operations.
 * 
 * Example 1:
 * 
 * Input: s = "ABAB", k = 2 Output: 4 Explanation: Replace the two 'A's with two
 * 'B's or vice versa.
 * 
 * Example 2:
 * 
 * Input: s = "AABABBA", k = 1 Output: 4 Explanation: Replace the one 'A' in the
 * middle with 'B' and form "AABBBBA". The substring "BBBB" has the longest
 * repeating letters, which is 4. There may exists other ways to achieve this
 * answer too.
 */
public class LongestRepeatingCharacterReplacement {

	public static void main(String[] args) {
		System.out.println(characterReplacement("ABAB", 2));
		System.out.println(characterReplacement("AABABBA", 1));

		System.out.println("---");

		System.out.println(characterReplacementPractice("ABAB", 2));
		System.out.println(characterReplacementPractice("AABABBA", 1));
	}

	private static int characterReplacementPractice(String s, int k) {
		return -1;
	}

	/**
	 * For a substring to be valid, we need window_length - maxf <= k. Here, maxf is
	 * the frequency of the most common character in the current window. The
	 * difference window_length - maxf tells us how many characters we'd need to
	 * change to make the whole window the same character.
	 * 
	 * The biggest valid substring we can get is of size maxf + k. So, the larger
	 * maxf is, the better. If maxf doesn't change or goes down, our potential best
	 * answer doesn't change. We don't need to update maxf in this case.
	 * 
	 * On the other hand, if maxf goes up, it means we've found a character in the
	 * current window that appears more often than in previous windows. This means
	 * we might be able to get a longer valid substring, so we update maxf.
	 */
	private static int characterReplacement(String s, int k) {
		Map<Character, Integer> windowFreq = new HashMap<>();
		int maxFreq = 0;
		int longestRepeatingSubstring = 0;
		int left = 0;
		int right = 0;
		while (right < s.length()) {
			Character rightMostChar = s.charAt(right);
			windowFreq.merge(rightMostChar, 1, Integer::sum);
			maxFreq = Math.max(maxFreq, windowFreq.get(rightMostChar));
			while ((right - left + 1) - maxFreq > k) {
				Character leftMostChar = s.charAt(left);
				left++;
				windowFreq.merge(leftMostChar, 1, (a, b) -> a - b);
			}
			longestRepeatingSubstring = Math.max(longestRepeatingSubstring, right - left + 1);
			right++;
		}
		return longestRepeatingSubstring;
	}

}
