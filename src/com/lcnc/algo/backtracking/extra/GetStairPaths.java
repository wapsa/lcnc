package com.lcnc.algo.backtracking.extra;

import java.util.ArrayList;
import java.util.List;

// jumps allowed: 1,2 || 1,2,3
public class GetStairPaths {

	public static void main(String[] args) {
		System.out.println(climbStairs(3));
		System.out.println(climbStairs(4));

		System.out.println("---");

		System.out.println(climbStairsPractice(3));
		System.out.println(climbStairsPractice(4));
	}

	private static List<String> climbStairsPractice(int n) {
		List<String> res = new ArrayList<>();
		return res;
	}

	private static List<String> climbStairs(int n) {
		List<String> res = new ArrayList<>();
		climbStairs(n, new StringBuilder(), res);
		return res;
	}

	private static void climbStairs(int n, StringBuilder output, List<String> res) {
		if (n < 0)
			return;
		if (n == 0) {
			res.add(output.toString());
			return;
		}

		output.append("1");
		climbStairs(n - 1, output, res);
		output.deleteCharAt(output.length() - 1);

		output.append("2");
		climbStairs(n - 2, output, res);
		output.deleteCharAt(output.length() - 1);

		output.append("3");
		climbStairs(n - 3, output, res);
		output.deleteCharAt(output.length() - 1);
	}

}
