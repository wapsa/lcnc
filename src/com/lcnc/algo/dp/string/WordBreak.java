package com.lcnc.algo.dp.string;

import java.util.Arrays;
import java.util.List;

/**
 * Given a string s and a dictionary of strings wordDict, return true if s can
 * be segmented into a space-separated sequence of one or more dictionary words.
 * 
 * Note that the same word in the dictionary may be reused multiple times in the
 * segmentation.
 * 
 * Example 1:
 * 
 * Input: s = "leetcode", wordDict = ["leet","code"] Output: true Explanation:
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 * Example 2:
 * 
 * Input: s = "applepenapple", wordDict = ["apple","pen"] Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple
 * pen apple". Note that you are allowed to reuse a dictionary word.
 * 
 * Example 3:
 * 
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"] Output:
 * false
 */
public class WordBreak {

	public static void main(String[] args) {
		System.out.println(wordBreak("leetcode", List.of("leet", "code")));
		System.out.println(wordBreak("applepenapple", List.of("apple", "pen")));
		System.out.println(wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));

		System.out.println("---");

		System.out.println(wordBreakPractice("leetcode", List.of("leet", "code")));
		System.out.println(wordBreakPractice("applepenapple", List.of("apple", "pen")));
		System.out.println(wordBreakPractice("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
	}

	private static boolean wordBreakPractice(String s, List<String> wordDict) {
		return false;
	}

	private static boolean wordBreak(String s, List<String> wordDict) {
		boolean[] dp = new boolean[s.length() + 1];
		dp[s.length()] = true;
		for (int i = s.length() - 1; i >= 0; i--) {
			for (String word : wordDict) {
				if (i + word.length() <= s.length() && s.substring(i, i + word.length()).equals(word)) {
					dp[i] = dp[i + word.length()];
					if (dp[i])
						break;
				}
			}
		}
		System.out.println(Arrays.toString(dp));
		return dp[0];
	}

}
