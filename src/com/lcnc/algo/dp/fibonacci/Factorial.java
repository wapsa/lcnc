package com.lcnc.algo.dp.fibonacci;

import java.util.HashMap;
import java.util.Map;

/**
 * What is the factorial of a number? Factorial of a non-negative integer is the
 * multiplication of all positive integers smaller than or equal to n. For
 * example factorial of 6 is 6*5*4*3*2*1 which is 720.
 */
public class Factorial {

	private static final Map<Integer, Integer> MEMO = new HashMap<>();

	public static void main(String[] args) {
		System.out.println(factorial(5));
		System.out.println(factorial(4));
		System.out.println(factorial(3));
		System.out.println(factorial(2));
		System.out.println(factorial(1));
		System.out.println(factorial(0));

		System.out.println("---");

		System.out.println(factorialMemoization(5));
		System.out.println(factorialMemoization(4));
		System.out.println(factorialMemoization(3));
		System.out.println(factorialMemoization(2));
		System.out.println(factorialMemoization(1));
		System.out.println(factorialMemoization(0));

		System.out.println("---");

		System.out.println(factorialPractice(5));
		System.out.println(factorialPractice(4));
		System.out.println(factorialPractice(3));
		System.out.println(factorialPractice(2));
		System.out.println(factorialPractice(1));
		System.out.println(factorialPractice(0));
	}

	private static int factorialPractice(int n) {
		return -1;
	}

	private static int factorial(int n) {
		if (n == 0 || n == 1)
			return 1;
		return n * factorial(n - 1);
	}

	private static int factorialMemoization(int n) {
		if (n == 0 || n == 1)
			return 1;
		if (MEMO.containsKey(n))
			return MEMO.get(n);
		int result = n * factorial(n - 1);
		MEMO.put(n, result);
		return result;
	}

}
