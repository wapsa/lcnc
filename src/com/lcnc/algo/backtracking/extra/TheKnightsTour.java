package com.lcnc.algo.backtracking.extra;

/**
 * Given two positive integers m and n which are the height and width of a
 * 0-indexed 2D-array board, a pair of positive integers (r, c) which is the
 * starting position of the knight on the board.
 * 
 * Your task is to find an order of movements for the knight, in a manner that
 * every cell of the board gets visited exactly once (the starting cell is
 * considered visited and you shouldn't visit it again).
 * 
 * Return the array board in which the cells' values show the order of visiting
 * the cell starting from 0 (the initial place of the knight).
 * 
 * Note that a knight can move from cell (r1, c1) to cell (r2, c2) if 0 <= r2 <=
 * m - 1 and 0 <= c2 <= n - 1 and min(abs(r1 - r2), abs(c1 - c2)) = 1 and
 * max(abs(r1 - r2), abs(c1 - c2)) = 2.
 * 
 * Example 1:
 * 
 * Input: m = 1, n = 1, r = 0, c = 0 Output: [[0]] Explanation: There is only 1
 * cell and the knight is initially on it so there is only a 0 inside the 1x1
 * grid.
 * 
 * Example 2:
 * 
 * Input: m = 3, n = 4, r = 0, c = 0 Output: [[0,3,6,9],[11,8,1,4],[2,5,10,7]]
 * Explanation: By the following order of movements we can visit the entire
 * board.
 * (0,0)->(1,2)->(2,0)->(0,1)->(1,3)->(2,1)->(0,2)->(2,3)->(1,1)->(0,3)->(2,2)->(1,0)
 * 
 */
public class TheKnightsTour {

	public static void main(String[] args) {
		printKnightsTour(1, 1, 0, 0);
		printKnightsTour(3, 4, 0, 0);

		System.out.println("---");

		printKnightsTourPractice(1, 1, 0, 0);
		printKnightsTourPractice(3, 4, 0, 0);
	}

	private static void printKnightsTourPractice(int m, int n, int r, int c) {

	}

	private static void printKnightsTour(int m, int n, int r, int c) {
		int[][] board = new int[m][n];
		boolean[][] visited = new boolean[m][n];
		printKnightsTour(board, visited, r, c, 1);
	}

	private static void printKnightsTour(int[][] board, boolean[][] visited, int r, int c, int moveNum) {
		if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || visited[r][c]) {
			return;
		}

		if (moveNum == board.length * board[0].length) {
			board[r][c] = moveNum;
			printBoard(board);
			board[r][c] = 0;
			return;
		}

		board[r][c] = moveNum;
		visited[r][c] = true;
		printKnightsTour(board, visited, r + 2, c + 1, moveNum + 1);
		printKnightsTour(board, visited, r + 1, c + 2, moveNum + 1);
		printKnightsTour(board, visited, r - 1, c + 2, moveNum + 1);
		printKnightsTour(board, visited, r - 2, c + 1, moveNum + 1);
		printKnightsTour(board, visited, r + 2, c - 1, moveNum + 1);
		printKnightsTour(board, visited, r + 1, c - 2, moveNum + 1);
		printKnightsTour(board, visited, r - 1, c - 2, moveNum + 1);
		printKnightsTour(board, visited, r - 2, c - 1, moveNum + 1);
		board[r][c] = 0;
		visited[r][c] = false;
	}

	private static void printBoard(int[][] board) {
		for (int[] row : board) {
			for (int cell : row)
				System.out.print(cell + " ");
			System.out.println();
		}
		System.out.println("-");
	}

}
