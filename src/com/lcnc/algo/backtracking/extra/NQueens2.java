package com.lcnc.algo.backtracking.extra;

import java.util.Arrays;

/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard
 * such that no two queens attack each other.
 * 
 * Given an integer n, return the number of distinct solutions to the n-queens
 * puzzle.
 * 
 * Example 1:
 * 
 * Input: n = 4 Output: 2 Explanation: There are two distinct solutions to the
 * 4-queens puzzle as shown.
 * 
 * Example 2:
 * 
 * Input: n = 1 Output: 1
 */
public class NQueens2 {

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

	private static int nqueensPractice(int n) {
		return -1;
	}

	private static int nqueens(int n) {
		char[][] board = new char[n][n];
		for (char[] br : board)
			Arrays.fill(br, '.');
		return nqueens(board, 0);
	}

	private static int nqueens(char[][] board, int row) {
		if (row == board.length) {
			return 1;
		}
		int count = 0;
		for (int col = 0; col < board[0].length; col++) {
			if (isSafeToPlaceQueen(board, row, col)) {
				board[row][col] = 'Q';
				count += nqueens(board, row + 1);
				board[row][col] = '.';
			}
		}
		return count;
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
