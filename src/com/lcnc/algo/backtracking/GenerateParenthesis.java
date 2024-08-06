package com.lcnc.algo.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * Example 1:
 * 
 * Input: n = 3 Output: ["((()))","(()())","(())()","()(())","()()()"]
 * 
 * Example 2:
 * 
 * Input: n = 1 Output: ["()"]
 */
public class GenerateParenthesis {

	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
		System.out.println(generateParenthesis(1));

		System.out.println("---");

		System.out.println(generateParenthesisPractice(3));
		System.out.println(generateParenthesisPractice(1));

	}

	private static List<String> generateParenthesisPractice(int n) {
		List<String> res = new ArrayList<>();
		return res;
	}

	private static List<String> generateParenthesis(int n) {
		if (n < 1)
			return List.of();
		List<String> res = new ArrayList<>();
		generateParenthesis(n, 0, 0, new StringBuilder(), res);
		return res;
	}

	private static void generateParenthesis(int n, int openingCount, int closingCount, StringBuilder output,
			List<String> res) {
		if (output.length() == n << 1) {
			res.add(output.toString());
			return;
		}
		if (openingCount < n) {
			output.append("(");
			generateParenthesis(n, openingCount + 1, closingCount, output, res);
			output.deleteCharAt(output.length() - 1);
		}
		if (closingCount < openingCount) {
			output.append(")");
			generateParenthesis(n, openingCount, closingCount + 1, output, res);
			output.deleteCharAt(output.length() - 1);
		}
	}

}
