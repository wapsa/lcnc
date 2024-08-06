package com.lcnc.algo.backtracking;

/**
 * Given an m x n grid of characters board and a string word, return true if
 * word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * Example 1:
 * 
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word
 * = "ABCCED" Output: true
 * 
 * Example 2:
 * 
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word
 * = "SEE" Output: true
 * 
 * Example 3:
 * 
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word
 * = "ABCB" Output: false
 * 
 */
public class WordSearch {

	public static void main(String[] args) {
		System.out.println(exist(
				new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } }, "ABCCED"));
		System.out.println(
				exist(new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } }, "SEE"));
		System.out.println(
				exist(new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } }, "ABCB"));

		System.out.println("---");

		System.out.println(existPractice(
				new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } }, "ABCCED"));
		System.out.println(existPractice(
				new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } }, "SEE"));
		System.out.println(existPractice(
				new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } }, "ABCB"));

	}

	private static boolean existPractice(char[][] board, String word) {
		return false;
	}

	private static boolean exist(char[][] board, String word) {
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[0].length; y++) {
				if (exist(board, x, y, word.toCharArray(), 0))
					return true;
			}
		}
		return false;
	}

	private static boolean exist(char[][] board, int x, int y, char[] word, int pos) {
		if (pos == word.length) {
			return true;
		}
		if (x < 0 || x == board.length || y < 0 || y == board[0].length) {
			return false;
		}
		if (board[x][y] != word[pos]) {
			return false;
		}
		// can be done with visited array instead of dummy replacement.
		// board[x][y] != word[pos] will fail for dummy char.
		char saved = board[x][y];
		board[x][y] = '-';
		// move right
		boolean rightExist = exist(board, x + 1, y, word, pos + 1);
		// move left
		boolean leftExist = exist(board, x - 1, y, word, pos + 1);
		// move down
		boolean downExist = exist(board, x, y - 1, word, pos + 1);
		// move up
		boolean upExist = exist(board, x, y + 1, word, pos + 1);
		board[x][y] = saved;
		return (rightExist || leftExist || downExist || upExist);
	}

}
