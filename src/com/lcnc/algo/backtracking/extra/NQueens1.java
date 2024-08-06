package com.lcnc.algo.backtracking.extra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard
 * such that no two queens attack each other.
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle. You
 * may return the answer in any order.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space,
 * respectively.
 * 
 * Example 1:
 * 
 * Input: n = 4 Output:
 * [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]] Explanation:
 * There exist two distinct solutions to the 4-queens puzzle as shown above
 * 
 * Example 2:
 * 
 * Input: n = 1 Output: [["Q"]]
 */
public class NQueens1 {

	public static void main(String[] args) {
		System.out.println(nqueens(4));
		System.out.println(nqueens(3));
		System.out.println(nqueens(2));
		System.out.println(nqueens(1));

		System.out.println("---");

		System.out.println(nqueensPractice(4));
		System.out.println(nqueensPractice(3));
		System.out.println(nqueensPractice(2));
		System.out.println(nqueensPractice(1));
	}

	private static List<List<String>> nqueensPractice(int n) {
		List<List<String>> res = new ArrayList<>();
		return res;
	}

	private static List<List<String>> nqueens(int n) {
		char[][] board = new char[n][n];
		for (char[] br : board)
			Arrays.fill(br, '.');
		List<List<String>> res = new ArrayList<>();
		nqueens(board, 0, res);
		return res;
	}

	private static void nqueens(char[][] board, int row, List<List<String>> res) {
		if (row == board.length) {
			List<String> output = new ArrayList<>();
			for (char[] br : board)
				output.add(String.valueOf(br));
			res.add(output);
			return;
		}
		for (int col = 0; col < board[0].length; col++) {
			if (isSafeToPlaceQueen(board, row, col)) {
				board[row][col] = 'Q';
				nqueens(board, row + 1, res);
				board[row][col] = '.';
			}
		}
	}

	private static boolean isSafeToPlaceQueen(char[][] board, int row, int col) {
		// check entire upper col
		for (int i = row - 1; i >= 0; i--) {
			if (board[i][col] == 'Q')
				return false;
		}
		// check left diag
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 'Q')
				return false;
		}
		// check right diag
		for (int i = row - 1, j = col + 1; i >= 0 && j < board[0].length; i--, j++) {
			if (board[i][j] == 'Q')
				return false;
		}
		return true;
	}

}
