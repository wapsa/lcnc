package com.lcnc.algo.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers
 * chosen from the range [1, n].
 * 
 * You may return the answer in any order.
 * 
 * Example 1:
 * 
 * Input: n = 4, k = 2 Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 * Explanation: There are 4 choose 2 = 6 total combinations. Note that
 * combinations are unordered, i.e., [1,2] and [2,1] are considered to be the
 * same combination.
 * 
 * Example 2:
 * 
 * Input: n = 1, k = 1 Output: [[1]] Explanation: There is 1 choose 1 = 1 total
 * combination.
 * 
 * 
 * nCr = n!/r!(n-r)!
 * 
 * nCr = nPr / r!
 * 
 */
public class Combinations {

	public static void main(String[] args) {
		System.out.println(combine(4, 2));
		System.out.println(combine(4, 3));
		System.out.println(combine(1, 1));

		System.out.println("---");

		System.out.println(combinePractice(4, 2));
		System.out.println(combinePractice(4, 3));
		System.out.println(combinePractice(1, 1));
	}

	private static List<List<Integer>> combinePractice(int n, int r) {
		List<List<Integer>> res = new ArrayList<>();
		return res;
	}

	private static List<List<Integer>> combine(int n, int r) {
		List<List<Integer>> res = new ArrayList<>();
		backtrackFixingPosition(n, 1, new ArrayList<>(), r, res);
		return res;
	}

	private static void backtrackFixingPosition(int n, int offset, List<Integer> output, int r,
			List<List<Integer>> res) {
		if (output.size() == r) {
			res.add(new ArrayList<>(output));
			return;
		}
		for (int i = offset; i <= n; i++) {
			output.add(i);
			backtrackFixingPosition(n, i + 1, output, r, res);
			output.remove(output.size() - 1);
		}
	}

}
