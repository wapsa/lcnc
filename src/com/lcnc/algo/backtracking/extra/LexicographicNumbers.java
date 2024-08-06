package com.lcnc.algo.backtracking.extra;

public class LexicographicNumbers {

	public static void main(String[] args) {
		lexicographicNumbers(23);

		System.out.println("---");

		lexicographicNumbersPractice(23);
	}

	private static void lexicographicNumbersPractice(int n) {
	}

	private static void lexicographicNumbers(int n) {
		for (int i = 1; i <= 9; i++)
			lexicographicNumbers(i, n);
	}

	private static void lexicographicNumbers(int num, int max) {
		if (num > max)
			return;
		System.out.println(num);
		for (int i = 0; i < 10; i++)
			lexicographicNumbers(10 * num + i, max);
	}

}
