package com.lcnc.ds.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings s and t are isomorphic if the characters in s can be replaced to
 * get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character, but a character may map to itself.
 * 
 * Example 1:
 * 
 * Input: s = "egg", t = "add" Output: true
 * 
 * Example 2:
 * 
 * Input: s = "foo", t = "bar" Output: false
 * 
 * Example 3:
 * 
 * Input: s = "paper", t = "title" Output: true
 */
public class IsomorphicStrings {

	public static void main(String[] args) {
		System.out.println(isIsomorphic("egg", "add"));
		System.out.println(isIsomorphic("foo", "bar"));
		System.out.println(isIsomorphic("paper", "title"));
		System.out.println(isIsomorphic("abbc", "xxyz"));

		System.out.println("---");

		System.out.println(isIsomorphicPractice("egg", "add"));
		System.out.println(isIsomorphicPractice("foo", "bar"));
		System.out.println(isIsomorphicPractice("paper", "title"));
		System.out.println(isIsomorphicPractice("abbc", "xxyz"));
	}

	private static boolean isIsomorphicPractice(String s, String t) {
		return false;
	}

	private static boolean isIsomorphic(String s, String t) {
		Map<Character, Character> smap = new HashMap<>();
		Map<Character, Character> tmap = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char sch = s.charAt(i);
			char tch = t.charAt(i);
			if ((smap.containsKey(sch) && smap.get(sch) != tch) || tmap.containsKey(tch) && tmap.get(tch) != sch)
				return false;
			smap.put(sch, tch);
			tmap.put(tch, sch);
		}
		return true;
	}

}
