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
public class ValidPalindrome {

	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("  "));
		System.out.println(isPalindrome("race a car"));

		System.out.println("---");

		System.out.println(isPalindromePractice("A man, a plan, a canal: Panama"));
		System.out.println(isPalindromePractice("  "));
		System.out.println(isPalindromePractice("race a car"));

		System.out.println("---");

		int smallA = 'a';
		int capitalA = 'A';
		System.out.println("a: " + smallA);
		System.out.println("A: " + capitalA);
		System.out.println("a - A = " + (smallA - capitalA));
	}

	private static boolean isPalindromePractice(String s) {
		if (s.isBlank())
			return true;
		int left = 0;
		int right = s.length() - 1;
		while (left < right) {
			char lch = toLower(s.charAt(left));
			char rch = toLower(s.charAt(right));
			if (!isAlphabetOrDigit(lch)) {
				left++;
			} else if (!isAlphabetOrDigit(rch)) {
				right--;
			} else if (lch == rch) {
				left++;
				right--;
			} else {
				return false;
			}
		}
		return true;
	}

	private static boolean isPalindrome(String s) {
		if (s.isBlank())
			return true;
		int left = 0;
		int right = s.length() - 1;
		while (left < right) {
			char lch = toLower(s.charAt(left));
			char rch = toLower(s.charAt(right));
			if (!isAlphabetOrDigit(lch))
				left++;
			else if (!isAlphabetOrDigit(rch))
				right--;
			else if (lch == rch) {
				left++;
				right--;
			} else {
				return false;
			}
		}
		return true;
	}

	private static boolean isAlphabetOrDigit(char ch) {
		return (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9');
	}

	private static char toLower(char ch) {
		if (ch >= 'A' && ch <= 'Z')
			return (char) (ch + ('a' - 'A'));
		return ch;
	}

}
