package com.lcnc.ds.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings ransomNote and magazine, return true if ransomNote can be
 * constructed by using the letters from magazine and false otherwise.
 * 
 * Each letter in magazine can only be used once in ransomNote.
 * 
 * Example 1:
 * 
 * Input: ransomNote = "a", magazine = "b" Output: false
 * 
 * Example 2:
 * 
 * Input: ransomNote = "aa", magazine = "ab" Output: false
 * 
 * Example 3:
 * 
 * Input: ransomNote = "aa", magazine = "aab" Output: true
 */
public class RansomNote {

	public static void main(String[] args) {
		System.out.println(canConstruct("a", "b"));
		System.out.println(canConstruct("aa", "ab"));
		System.out.println(canConstruct("aa", "aab"));

		System.out.println("---");

		System.out.println(canConstructPractice("a", "b"));
		System.out.println(canConstructPractice("aa", "ab"));
		System.out.println(canConstructPractice("aa", "aab"));
	}

	private static boolean canConstructPractice(String ransomNote, String magazine) {
		return false;
	}

	private static boolean canConstruct(String ransomNote, String magazine) {
		Map<Character, Integer> magFreq = new HashMap<>();
		for (Character ch : magazine.toCharArray())
			magFreq.merge(ch, 1, Integer::sum);
		for (Character ch : ransomNote.toCharArray()) {
			if (!magFreq.containsKey(ch) || magFreq.get(ch) == 0)
				return false;
			magFreq.merge(ch, 1, (a, b) -> a - b);
		}
		return true;
	}

}
