package com.lcnc.ds.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets. Open brackets must
 * be closed in the correct order. Every close bracket has a corresponding open
 * bracket of the same type.
 * 
 * Example 1:
 * 
 * Input: s = "()" Output: true
 * 
 * Example 2:
 * 
 * Input: s = "()[]{}" Output: true
 * 
 * Example 3:
 * 
 * Input: s = "(]" Output: false
 * 
 */
public class ValidParenthesis {

	private static final Map<Character, Character> PARENTHESIS = Map.ofEntries(Map.entry('{', '}'), Map.entry('(', ')'),
			Map.entry('[', ']'));

	public static void main(String[] args) {
		System.out.println(isValid("()"));
		System.out.println(isValid("()[]{}"));
		System.out.println(isValid("(]"));
		System.out.println(isValid("]"));

		System.out.println("---");

		System.out.println(isValidPractice("()"));
		System.out.println(isValidPractice("()[]{}"));
		System.out.println(isValidPractice("(]"));
		System.out.println(isValidPractice("]"));
	}

	private static boolean isValidPractice(String s) {
		return false;
	}

	private static boolean isValid(String s) {
		Deque<Character> stack = new ArrayDeque<>();
		for (Character token : s.toCharArray())
			if (PARENTHESIS.containsKey(token)) // opening parenthesis
				stack.push(token);
			else if (stack.isEmpty() || !token.equals(PARENTHESIS.get(stack.pop())))
				return false;
		return stack.isEmpty();
	}

}
