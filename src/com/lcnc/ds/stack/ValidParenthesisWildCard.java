package com.lcnc.ds.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

/**
 * Given a string s containing only three types of characters: '(', ')' and '*',
 * return true if s is valid.
 * 
 * The following rules define a valid string:
 * 
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'. Any
 * right parenthesis ')' must have a corresponding left parenthesis '('. Left
 * parenthesis '(' must go before the corresponding right parenthesis ')'. '*'
 * could be treated as a single right parenthesis ')' or a single left
 * parenthesis '(' or an empty string "".
 * 
 * Example 1:
 * 
 * Input: s = "()" Output: true
 * 
 * Example 2:
 * 
 * Input: s = "(*)" Output: true
 * 
 * Example 3:
 * 
 * Input: s = "(*))" Output: true
 * 
 */
public class ValidParenthesisWildCard {

	private static final Set<Character> OPENING_PARENTHESIS = Set.of('(', '{', '[');
	private static final Character WILDCARD = '*';

	public static void main(String[] args) {
		System.out.println(checkValidString("()"));
		System.out.println(checkValidString("(*)"));
		System.out.println(checkValidString("(*))"));
		System.out.println(checkValidString("**(*"));

		System.out.println("---");

		System.out.println(checkValidStringPractice("()"));
		System.out.println(checkValidStringPractice("(*)"));
		System.out.println(checkValidStringPractice("(*))"));
		System.out.println(checkValidStringPractice("**(*"));
	}

	private static boolean checkValidStringPractice(String s) {
		Deque<Integer> openingStack = new ArrayDeque<>();
		Deque<Integer> wildcardStack = new ArrayDeque<>();
		for (int i = 0; i < s.length(); i++) {
			Character token = s.charAt(i);
			if (token.equals(WILDCARD))
				wildcardStack.push(i);
			else if (OPENING_PARENTHESIS.contains(token))
				openingStack.push(i);
			else {
				if (!openingStack.isEmpty())
					openingStack.pop();
				else if (!wildcardStack.isEmpty())
					wildcardStack.pop();
				else
					return false;
			}
		}
		while (!openingStack.isEmpty() && !wildcardStack.isEmpty() && wildcardStack.peek() > openingStack.peek()) {
			openingStack.pop();
			wildcardStack.pop();
		}
		return openingStack.isEmpty();
	}

	private static boolean checkValidString(String s) {
		Deque<Integer> openingBracketStack = new ArrayDeque<>();
		Deque<Integer> wildCardStack = new ArrayDeque<>();
		for (int i = 0; i < s.length(); i++) {
			Character token = s.charAt(i);
			if (OPENING_PARENTHESIS.contains(token)) {
				openingBracketStack.push(i);
			} else if (token.equals(WILDCARD)) {
				wildCardStack.push(i);
			} else {
				if (openingBracketStack.isEmpty() && wildCardStack.isEmpty())
					return false;
				if (!openingBracketStack.isEmpty())
					openingBracketStack.pop();
				else
					wildCardStack.pop();
			}
		}
		// opening bracket CANNOT appear after the wildcard as there is NO way to
		// balance the bracket. Once all the opening brackets have been satisfied with
		// wildcards to the right. we can just assume that any remaining wildcards can
		// be considered empty("") making the string balanced.
		while (!openingBracketStack.isEmpty() && !wildCardStack.isEmpty()) {
			if (openingBracketStack.pop() > wildCardStack.pop())
				return false;
		}
		return openingBracketStack.isEmpty();
	}

}
