package com.lcnc.algo.backtracking.extra;

import java.util.ArrayList;
import java.util.List;

// only right and down
public class GetMazePaths1 {

	public static void main(String[] args) {
		System.out.println(printMazePaths(0, 0, 2, 2));
		System.out.println(printMazePaths(0, 0, 3, 3));

		System.out.println("---");

		System.out.println(printMazePathsPractice(0, 0, 2, 2));
		System.out.println(printMazePathsPractice(0, 0, 3, 3));
	}

	private static List<String> printMazePathsPractice(int curR, int curC, int destR, int destC) {
		List<String> res = new ArrayList<>();
		return res;
	}

	private static List<String> printMazePaths(int curR, int curC, int destR, int destC) {
		List<String> res = new ArrayList<>();
		printMazePaths(curR, curC, destR, destC, new StringBuilder(), res);
		return res;
	}

	private static void printMazePaths(int curR, int curC, int destR, int destC, StringBuilder output,
			List<String> res) {
		if (curR == destR && curC == destC) {
			res.add(output.toString());
			return;
		}
		if (curR < 0 || curR > destR || curC < 0 || curC > destC)
			return;

		output.append("r");
		printMazePaths(curR, curC + 1, destR, destC, output, res);
		output.deleteCharAt(output.length() - 1);

		output.append("d");
		printMazePaths(curR + 1, curC, destR, destC, output, res);
		output.deleteCharAt(output.length() - 1);
	}

}
