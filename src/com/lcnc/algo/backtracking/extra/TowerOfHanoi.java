package com.lcnc.algo.backtracking.extra;

import java.util.ArrayList;
import java.util.List;

public class TowerOfHanoi {

	public static void main(String[] args) {
		System.out.println(toh(1, "A", "B", "C"));
		System.out.println(toh(2, "A", "B", "C"));
		System.out.println(toh(3, "A", "B", "C"));
		System.out.println(toh(4, "A", "B", "C"));

		System.out.println("---");

		System.out.println(tohPractice(1, "A", "B", "C"));
		System.out.println(tohPractice(2, "A", "B", "C"));
		System.out.println(tohPractice(3, "A", "B", "C"));
		System.out.println(tohPractice(4, "A", "B", "C"));
	}

	private static List<String> tohPractice(int noOfDisks, String origin, String destination, String buffer) {
		List<String> res = new ArrayList<>();
		return res;
	}

	private static List<String> toh(int noOfDisks, String origin, String destination, String buffer) {
		List<String> moves = new ArrayList<>();
		toh(noOfDisks, origin, destination, buffer, moves);
		return moves;
	}

	private static void toh(int n, String origin, String destination, String buffer, List<String> moves) {
		if (n == 0)
			return;
		toh(n - 1, origin, buffer, destination, moves);
		moves.add(n + ":[" + origin + " -> " + destination + "]");
		toh(n - 1, buffer, destination, origin, moves);
	}

}
