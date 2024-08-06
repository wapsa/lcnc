package com.lcnc.ds.matrix;

import java.util.Arrays;

/**
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row
 * and column to 0's.
 * 
 * You must do it in place.
 * 
 * Example 1:
 * 
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]] Output: [[1,0,1],[0,0,0],[1,0,1]]
 * 
 * Example 2:
 * 
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]] Output:
 * [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * 
 */
public class SetMatrixZeroes {

	public static void main(String[] args) {
		printMatrix(setZeroesExtraSpace(new int[][] { { 1 } }));
		printMatrix(setZeroesExtraSpace(new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } }));
		printMatrix(setZeroesExtraSpace(new int[][] { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } }));

		System.out.println("---");

		printMatrix(setZeroesInplace(new int[][] { { 1 } }));
		printMatrix(setZeroesInplace(new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } }));
		printMatrix(setZeroesInplace(new int[][] { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } }));

		System.out.println("---");

		printMatrix(setZeroesInplacePractice(new int[][] { { 1 } }));
		printMatrix(setZeroesInplacePractice(new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } }));
		printMatrix(setZeroesInplacePractice(new int[][] { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } }));
	}

	private static int[][] setZeroesInplacePractice(int[][] matrix) {
		return new int[0][0];
	}

	private static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++)
			System.out.print(Arrays.toString(matrix[i]));
		System.out.println();
	}

	private static int[][] setZeroesInplace(int[][] matrix) {
		boolean zeroRowFlag = false;
		for (int r = 0; r < matrix.length; r++)
			for (int c = 0; c < matrix[0].length; c++)
				if (matrix[r][c] == 0) {
					matrix[0][c] = 0;
					if (r == 0)
						zeroRowFlag = true;
					else
						matrix[r][0] = 0;
				}
		for (int r = 1; r < matrix.length; r++)
			for (int c = 1; c < matrix[0].length; c++)
				if (matrix[0][c] == 0 || matrix[r][0] == 0)
					matrix[r][c] = 0;
		if (matrix[0][0] == 0)
			for (int r = 0; r < matrix.length; r++)
				matrix[r][0] = 0;
		if (zeroRowFlag)
			for (int c = 0; c < matrix[0].length; c++)
				matrix[0][c] = 0;
		return matrix;
	}

	private static int[][] setZeroesExtraSpace(int[][] matrix) {
		int[][] res = clone(matrix);
		for (int r = 0; r < matrix.length; r++)
			for (int c = 0; c < matrix[0].length; c++)
				if (matrix[r][c] == 0) {
					// set full row zeroes
					for (int i = 0; i < matrix.length; i++)
						res[i][c] = 0;
					// set full col zeroes
					for (int i = 0; i < matrix[0].length; i++)
						res[r][i] = 0;
				}
		return res;
	}

	private static int[][] clone(int[][] matrix) {
		int[][] res = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++)
			res[i] = Arrays.copyOf(matrix[i], matrix[i].length);
		return res;
	}

}
