package com.lcnc.ds.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings strs, group the anagrams together. You can return
 * the answer in any order.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 * 
 * Example 1: Input: strs = ["eat","tea","tan","ate","nat","bat"] Output:
 * [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 
 * Example 2: Input: strs = [""] Output: [[""]]
 * 
 * Example 3: Input: strs = ["a"] Output: [["a"]]
 */
public class GroupAnagrams {

	public static void main(String[] args) {
		System.out.println(groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
		System.out.println(groupAnagrams(new String[] { "" }));
		System.out.println(groupAnagrams(new String[] { "a" }));

		System.out.println("---");

		System.out.println(groupAnagramsSort(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
		System.out.println(groupAnagramsSort(new String[] { "" }));
		System.out.println(groupAnagramsSort(new String[] { "a" }));

		System.out.println("---");

		System.out.println(groupAnagramsPractice(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
		System.out.println(groupAnagramsPractice(new String[] { "" }));
		System.out.println(groupAnagramsPractice(new String[] { "a" }));
	}

	private static List<List<String>> groupAnagramsPractice(String[] strs) {
		Map<String, List<String>> store = new HashMap<>();
		for (String str : strs) {
			char[] freq = new char[26];
			for (char ch : str.toCharArray())
				freq[ch - 'a']++;
			String key = String.valueOf(freq);
			List<String> group = store.get(key);
			if (group == null)
				group = new ArrayList<>();
			group.add(str);
			store.put(key, group);
		}
		return new ArrayList<>(store.values());
	}

	private static List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0)
			return Collections.emptyList();
		Map<String, List<String>> res = new HashMap<>();
		for (String str : strs) {
			char[] freq = new char[26];
			for (char ch : str.toCharArray())
				freq[ch - 'a']++;
			String key = String.valueOf(freq);
			List<String> group = res.get(key);
			if (group == null)
				group = new ArrayList<>();
			group.add(str);
			res.put(key, group);
		}
		return new ArrayList<>(res.values());
	}

	private static List<List<String>> groupAnagramsSort(String[] strs) {
		Map<String, List<String>> data = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			String currentStr = strs[i];
			char[] currentStrCh = currentStr.toCharArray();
			Arrays.sort(currentStrCh);
			String key = String.valueOf(currentStrCh);
			if (data.containsKey(key)) {
				data.get(key).add(currentStr);
			} else {
				List<String> holder = new ArrayList<>();
				holder.add(currentStr);
				data.put(key, holder);
			}
		}
		return new ArrayList<>(data.values());
	}

}
