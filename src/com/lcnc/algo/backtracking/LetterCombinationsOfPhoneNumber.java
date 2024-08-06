package com.lcnc.algo.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent. Return the answer in any
 * order.
 * 
 * A mapping of digits to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * Example 1:
 * 
 * Input: digits = "23" Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 
 * Example 2:
 * 
 * Input: digits = "" Output: []
 * 
 * Example 3:
 * 
 * Input: digits = "2" Output: ["a","b","c"]
 */
public class LetterCombinationsOfPhoneNumber {

	private static final Map<Character, String> PHONE_NUMBER_DIGIT_MAP = Map.ofEntries(Map.entry('0', ""),
			Map.entry('1', ""), Map.entry('2', "abc"), Map.entry('3', "def"), Map.entry('4', "ghi"),
			Map.entry('5', "jkl"), Map.entry('6', "mno"), Map.entry('7', "pqrs"), Map.entry('8', "tuv"),
			Map.entry('9', "wxyz"));

	public static void main(String[] args) {
		System.out.println(letterCombinations("23"));
		System.out.println(letterCombinations(""));
		System.out.println(letterCombinations("2"));

		System.out.println("---");

		System.out.println(letterCombinationsPractice("23"));
		System.out.println(letterCombinationsPractice(""));
		System.out.println(letterCombinationsPractice("2"));

	}

	private static List<String> letterCombinationsPractice(String digits) {
		List<String> res = new ArrayList<>();
		return res;
	}

	private static List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		if (digits == null || digits.length() == 0)
			return res;
		backtrack(digits, 0, new StringBuilder(), res);
		return res;
	}

	private static void backtrack(String digits, int i, StringBuilder output, List<String> res) {
		if (i == digits.length()) {
			res.add(output.toString());
			return;
		}
		char digit = digits.charAt(i);
		String letters = PHONE_NUMBER_DIGIT_MAP.get(digit);
		for (char letter : letters.toCharArray()) {
			output.append(letter);
			backtrack(digits, i + 1, output, res);
			output.deleteCharAt(output.length() - 1);
		}
	}

}
