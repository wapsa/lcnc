package com.lcnc.ds.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

/**
 * You are given an array of strings tokens that represents an arithmetic
 * expression in a Reverse Polish Notation.
 * 
 * Evaluate the expression. Return an integer that represents the value of the
 * expression.
 * 
 * Note that:
 * 
 * The valid operators are '+', '-', '*', and '/'. Each operand may be an
 * integer or another expression. The division between two integers always
 * truncates toward zero. There will not be any division by zero. The input
 * represents a valid arithmetic expression in a reverse polish notation. The
 * answer and all the intermediate calculations can be represented in a 32-bit
 * integer.
 * 
 * Example 1:
 * 
 * Input: tokens = ["2","1","+","3","*"] Output: 9 Explanation: ((2 + 1) * 3) =
 * 9
 * 
 * Example 2:
 * 
 * Input: tokens = ["4","13","5","/","+"] Output: 6 Explanation: (4 + (13 / 5))
 * = 6
 * 
 * Example 3:
 * 
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * Output: 22
 * 
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * 
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * 
 * = ((10 * (6 / -132)) + 17) + 5
 * 
 * = ((10 * 0) + 17) + 5
 * 
 * = (0 + 17) + 5
 * 
 * = 17 + 5
 * 
 * = 22
 * 
 */
public class EvaluateReversePolishNotationPostFix {

	private static final Set<String> OPERATORS = Set.of("+", "-", "*", "/");

	public static void main(String[] args) {
		System.out.println(evalRPN(new String[] { "2", "1", "+", "3", "*" }));

		System.out.println(evalRPN(new String[] { "4", "13", "5", "/", "+" }));
		System.out
				.println(evalRPN(new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" }));

		System.out.println("---");

		System.out.println(evalRPNPractice(new String[] { "2", "1", "+", "3", "*" }));

		System.out.println(evalRPNPractice(new String[] { "4", "13", "5", "/", "+" }));
		System.out.println(
				evalRPNPractice(new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" }));
	}

	public static int evalRPNPractice(String[] tokens) {
		return -1;
	}

	public static int evalRPN(String[] tokens) {
		if (tokens.length == 0)
			return 0;
		Deque<Integer> stack = new ArrayDeque<>();
		for (int i = 0, n = tokens.length; i < n; i++) {
			String token = tokens[i];
			if (OPERATORS.contains(token))
				stack.push(evalForPostfix(stack, token));
			else
				stack.push(Integer.valueOf(token));
		}
		return stack.pop();
	}

	private static int evalForPostfix(Deque<Integer> operandStack, String operator) {
		int b = operandStack.pop();
		int a = operandStack.pop();
		return switch (operator) {
		case "+" -> a + b;
		case "-" -> a - b;
		case "*" -> a * b;
		case "/" -> a / b;
		default -> throw new IllegalArgumentException();
		};
	}

}
