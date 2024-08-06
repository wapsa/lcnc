package com.lcnc.ds.graph;

import java.util.Arrays;

/**
 * Given an m x n matrix board containing 'X' and 'O', capture all regions that
 * are 4-directionally surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 * 
 * Example 1:
 * 
 * Input: board =
 * [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * Output:
 * [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * 
 * Explanation: Notice that an 'O' should not be flipped if: - It is on the
 * border, or - It is adjacent to an 'O' that should not be flipped. The bottom
 * 'O' is on the border, so it is not flipped. The other three 'O' form a
 * surrounded region, so they are flipped.
 * 
 * Example 2:
 * 
 * Input: board = [["X"]] Output: [["X"]]
 * 
 * First, check the four border of the matrix. If there is a element is 'O',
 * alter it and all its neighbor 'O' elements to '1'.
 * 
 * Then, alter all the 'O' to 'X'
 * 
 * At last, alter all the '1' to 'O'
 * 
 */
public class SurroundedRegions {

	public static void main(String[] args) {
		printMatrix(solve(new char[][] { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } }));
		printMatrix(solve(new char[][] { { 'X' } }));

		System.out.println("---");

		printMatrix(solvePractice(new char[][] { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } }));
		printMatrix(solvePractice(new char[][] { { 'X' } }));

	}

	private static void printMatrix(char[][] matrix) {
		for (int r = 0; r < matrix.length; r++)
			System.out.print(Arrays.toString(matrix[r]));
		System.out.println();
	}

	private static char[][] solvePractice(char[][] board) {
		return new char[0][0];
	}

	private static char[][] solve(char[][] board) {
		// iterate first and last column
		for (int r = 0; r < board.length; r++) {
			if (board[r][0] == 'O') {
				dfs(board, r, 0);
			}
			if (board[r][board[0].length - 1] == 'O') {
				dfs(board, r, board[0].length - 1);
			}
		}

		// iterate first and last row
		for (int c = 0; c < board[0].length; c++) {
			if (board[0][c] == 'O') {
				dfs(board, 0, c);
			}
			if (board[board.length - 1][c] == 'O') {
				dfs(board, board.length - 1, c);
			}
		}

		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				if (board[r][c] == 'O')
					board[r][c] = 'X';
				if (board[r][c] == '1')
					board[r][c] = 'O';
			}
		}
		return board;
	}

	private static void dfs(char[][] board, int r, int c) {
		if (r < 0 || r == board.length || c < 0 || c == board[0].length || board[r][c] != 'O')
			return;
		board[r][c] = '1';
		dfs(board, r, c + 1);
		dfs(board, r, c - 1);
		dfs(board, r + 1, c);
		dfs(board, r - 1, c);
	}

}
