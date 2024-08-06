package com.lcnc.ds.hashmap;

import java.util.Arrays;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false
 * otherwise.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 * 
 * Example 1:
 * 
 * Input: s = "anagram", t = "nagaram" Output: true
 * 
 * Example 2:
 * 
 * Input: s = "rat", t = "car" Output: false
 */
public class ValidAnagram {

	public static void main(String[] args) {
		System.out.println(isAnagram("anagram", "nagaram"));
		System.out.println(isAnagram("rat", "car"));

		System.out.println("---");

		System.out.println(isAnagramPractice("anagram", "nagaram"));
		System.out.println(isAnagramPractice("rat", "car"));
	}

	private static boolean isAnagramPractice(String s, String t) {
		return false;
	}

	private static boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		int[] sfreq = new int[26];
		int[] tfreq = new int[26];
		for (int i = 0; i < s.length(); i++) {
			sfreq[s.charAt(i) - 'a']++;
			tfreq[t.charAt(i) - 'a']++;
		}
		return Arrays.equals(sfreq, tfreq);
	}

}
