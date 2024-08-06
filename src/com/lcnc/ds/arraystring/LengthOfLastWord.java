package com.lcnc.ds.arraystring;

/**
 * Given a string s consisting of words and spaces, return the length of the
 * last word in the string.
 * 
 * A word is a maximal substring consisting of non-space characters only.
 * 
 * Example 1:
 * 
 * Input: s = "Hello World" Output: 5 Explanation: The last word is "World" with
 * length 5.
 * 
 * Example 2:
 * 
 * Input: s = " fly me to the moon " Output: 4 Explanation: The last word is
 * "moon" with length 4.
 * 
 * Example 3:
 * 
 * Input: s = "luffy is still joyboy" Output: 6 Explanation: The last word is
 * "joyboy" with length 6.
 */
public class LengthOfLastWord {

	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("Hello World"));
		System.out.println(lengthOfLastWord(" fly me to the moon "));
		System.out.println(lengthOfLastWord("luffy is still joyboy"));

		System.out.println("---");

		System.out.println(lengthOfLastWord1("Hello World"));
		System.out.println(lengthOfLastWord1(" fly me to the moon "));
		System.out.println(lengthOfLastWord1("luffy is still joyboy"));

		System.out.println("---");

		System.out.println(lengthOfLastWordPractice("Hello World"));
		System.out.println(lengthOfLastWordPractice(" fly me to the moon "));
		System.out.println(lengthOfLastWordPractice("luffy is still joyboy"));
	}

	private static int lengthOfLastWordPractice(String s) {
		return -1;
	}

	private static int lengthOfLastWord(String s) {
		s = s.strip();
		int length = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (Character.isWhitespace(s.charAt(i)))
				break;
			length++;
		}
		return length;
	}

	private static int lengthOfLastWord1(String s) {
		String[] strs = s.trim().split("\\s+");
		return strs[strs.length - 1].length();
	}

}
