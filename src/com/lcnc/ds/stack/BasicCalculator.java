package com.lcnc.ds.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Map;

/**
 * Given a string s representing a valid expression, implement a basic
 * calculator to evaluate it, and return the result of the evaluation.
 * 
 * Note: You are not allowed to use any built-in function which evaluates
 * strings as mathematical expressions, such as eval().
 * 
 * Example 1:
 * 
 * Input: s = "1 + 1" Output: 2
 * 
 * Example 2:
 * 
 * Input: s = " 2-1 + 2 " Output: 3
 * 
 * Example 3:
 * 
 * Input: s = "(1+(4+5+2)-3)+(6+8)" Output: 23
 */
public class BasicCalculator {

	private static final Map<String, String> OPENING_PARENTHESIS_MAP = Map.ofEntries(Map.entry("(", ")"));
	private static final Map<String, String> CLOSING_PARENTHESIS_MAP = Map.ofEntries(Map.entry(")", "("));
	private static final Map<String, Integer> OPERATOR_MAP = Map.ofEntries(Map.entry("+", 1), Map.entry("-", 1),
			Map.entry("*", 2), Map.entry("/", 2));

	public static void main(String[] args) {
		System.out.println(calculate("1 + 1"));
		System.out.println(calculate(" 2 - 1 +    2 "));
		System.out.println(calculate("( 1 + ( 4 + 5 + 2 ) - 3 ) + ( 6 + 8 )"));
		System.out.println(calculate("( 1 + ( 4 * 7 / 2 - 1 + 5 + 2 ) - 3 ) + ( 6 + 8 )"));

		System.out.println("---");

		System.out.println(calculatePractice("1 + 1"));
		System.out.println(calculatePractice(" 2 - 1 +    2 "));
		System.out.println(calculatePractice("( 1 + ( 4 + 5 + 2 ) - 3 ) + ( 6 + 8 )"));
		System.out.println(calculatePractice("( 1 + ( 4 * 7 / 2 - 1 + 5 + 2 ) - 3 ) + ( 6 + 8 )"));
	}

	private static int calculatePractice(String expression) {
		String[] postfixNotation = convertInfixToPostfixPractice(expression);
		System.out.println("postfixNotation: " + Arrays.toString(postfixNotation));
		return EvaluateReversePolishNotationPostFix.evalRPN(postfixNotation);
	}

	private static String[] convertInfixToPostfixPractice(String infixExpression) {
		return new String[0];
	}

	private static int calculate(String expression) {
		String[] postfixNotation = convertInfixToPostfix(expression);
		System.out.println("postfixNotation: " + Arrays.toString(postfixNotation));
		return EvaluateReversePolishNotationPostFix.evalRPN(postfixNotation);
	}

	private static String[] convertInfixToPostfix(String infixExpression) {
		Deque<String> stack = new ArrayDeque<>();
		List<String> postfixExpression = new ArrayList<>();
		String[] tokens = infixExpression.strip().split("\\s+");
		for (int i = 0; i < tokens.length; i++) {
			String token = tokens[i];

			if (OPENING_PARENTHESIS_MAP.containsKey(token))
				// add to stack.
				stack.push(token);
			else if (CLOSING_PARENTHESIS_MAP.containsKey(token)) {
				// until opening parenthesis, pop and add to result.
				while (!stack.isEmpty()) {
					String poppedValue = stack.pop();
					if (OPENING_PARENTHESIS_MAP.containsKey(poppedValue))
						break;
					postfixExpression.add(poppedValue);
				}
			} else if (OPERATOR_MAP.containsKey(token)) {
				// while stack top contains an operator and stack operator is greater than equal
				// to current operator, pop & add to result.
				while (!stack.isEmpty() && OPERATOR_MAP.containsKey(stack.peek())
						&& OPERATOR_MAP.get(stack.peek()) >= OPERATOR_MAP.get(token))
					postfixExpression.add(stack.pop());
				stack.push(token);
			} else
				// add to result.
				postfixExpression.add(token);
		}
		while (!stack.isEmpty())
			postfixExpression.add(stack.pop());
		return postfixExpression.toArray(new String[0]);
	}

}
