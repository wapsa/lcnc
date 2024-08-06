package com.lcnc.algo.dp.string;

/**
 * Given a string s, return the longest palindromic
 * 
 * substring in s.
 * 
 * Example 1:
 * 
 * Input: s = "babad" Output: "bab" Explanation: "aba" is also a valid answer.
 * 
 * Example 2:
 * 
 * Input: s = "cbbd" Output: "bb"
 */
public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		System.out.println(longestPalindromicSubstring("babad"));
		System.out.println(longestPalindromicSubstring("cbbd"));
		System.out.println(longestPalindromicSubstring("abc"));

		System.out.println("---");

		System.out.println(longestPalindromeSubstringPractice("babad"));
		System.out.println(longestPalindromeSubstringPractice("cbbd"));
		System.out.println(longestPalindromeSubstringPractice("abc"));
	}

	private static String longestPalindromeSubstringPractice(String s) {
		return null;
	}

	/**
	 * The obvious brute force solution is to pick all possible starting and ending
	 * positions for a substring, and verify if it is a palindrome. There are a
	 * total of n^2 such substrings (excluding the trivial solution where a
	 * character itself is a palindrome). Since verifying each substring takes O(n)
	 * time, the run time complexity is O(n^3).
	 * 
	 * With below approach it is: O(n^2) as expanding a palindrome around its center
	 * could take O(n) time and we are doing this for every character(n times).
	 * 
	 * res = s.substring(left, right + 1); ( this step can also potentially run n
	 * times, so its n^3. better to store indices and do substring only at the end.
	 */
	private static String longestPalindromicSubstring(String s) {
		int lr = 0;
		int rr = 0;
		int len = 0;
		for (int i = 0; i < s.length(); i++) {
			int left = i;
			int right = i;
			while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
				int currLen = right + 1 - left;
				if (currLen > len) {
					lr = left;
					rr = right;
					len = currLen;
				}
				left--;
				right++;
			}
			left = i;
			right = i + 1;
			while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
				int currLen = right + 1 - left;
				if (currLen > len) {
					lr = left;
					rr = right;
					len = currLen;
				}
				left--;
				right++;
			}
		}
		return s.substring(lr, rr + 1);
	}

}
