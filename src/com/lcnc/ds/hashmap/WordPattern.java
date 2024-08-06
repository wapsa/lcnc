package com.lcnc.ds.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string s, find if s follows the same pattern.
 * 
 * Here follow means a full match, such that there is a bijection between a
 * letter in pattern and a non-empty word in s.
 * 
 * Example 1: Input: pattern = "abba", s = "dog cat cat dog" Output: true
 * 
 * Example 2: Input: pattern = "abba", s = "dog cat cat fish" Output: false
 * 
 * Example 3: Input: pattern = "aaaa", s = "dog cat cat dog" Output: false
 */
public class WordPattern {

	public static void main(String[] args) {
		System.out.println(wordPattern("abba", "dog cat cat dog"));
		System.out.println(wordPattern("abba", "dog cat cat fish"));
		System.out.println(wordPattern("aaaa", "dog cat cat dog"));

		System.out.println("---");

		System.out.println(wordPatternPractice("abba", "dog cat cat dog"));
		System.out.println(wordPatternPractice("abba", "dog cat cat fish"));
		System.out.println(wordPatternPractice("aaaa", "dog cat cat dog"));
	}

	private static boolean wordPatternPractice(String pattern, String s) {
		return false;
	}

	private static boolean wordPattern(String pattern, String s) {
		String[] words = s.split(" ");
		if (pattern.length() != words.length)
			return false;
		Map<Character, String> d1 = new HashMap<>();
		Map<String, Character> d2 = new HashMap<>();
		for (int i = 0; i < pattern.length(); i++) {
			char patternChar = pattern.charAt(i);
			String word = words[i];
			if ((d1.containsKey(patternChar) && !d1.get(patternChar).equals(word))
					|| d2.containsKey(word) && !d2.get(word).equals(patternChar))
				return false;
			d1.put(patternChar, word);
			d2.put(word, patternChar);
		}
		return true;
	}

}
