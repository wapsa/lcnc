package com.lcnc.ds.matrix;

import java.util.Arrays;

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by
 * 90 degrees (clockwise).
 * 
 * You have to rotate the image in-place, which means you have to modify the
 * input 2D matrix directly. DO NOT allocate another 2D matrix and do the
 * rotation.
 * 
 * Example 1:
 * 
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]] Output: [[7,4,1],[8,5,2],[9,6,3]]
 * 
 * Example 2:
 * 
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]] Output:
 * [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * 
 * 
 * INPUT: [1,2,3] [4,5,6] [7,8,9]
 * 
 * TRANSPOSE: [1,4,7] [2,5,8] [3,6,9] (switch rows with columns)
 * 
 * 90: [7,4,1] [8,5,2] [9,6,3] (transpose + reverse rows)
 * 
 * 180: [9,8,7] [6,5,4] [3,2,1] (reverse rows + reverse cols)
 * 
 * 270: [3,6,9] [2,5,8] [1,4,7] (transpose + reverse cols)
 * 
 * 
 */
public class RotateImage90 {

	public static void main(String[] args) {
		printMatrix(rotate90(new int[][] { { 1 } }));
		printMatrix(rotate90(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
		printMatrix(rotate90(new int[][] { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } }));

		System.out.println("---");

		printMatrix(rotate90Practice(new int[][] { { 1 } }));
		printMatrix(rotate90Practice(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
		printMatrix(rotate90Practice(
				new int[][] { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } }));
	}

	private static int[][] rotate90Practice(int[][] matrix) {
		if (matrix.length != matrix[0].length)
			throw new UnsupportedOperationException("Only square matrix is supported.");
		transposePractice(matrix);
		reverseRowsPractice(matrix);
		return matrix;
	}

	private static void transposePractice(int[][] matrix) {

	}

	private static void reverseRowsPractice(int[][] matrix) {

	}

	private static void printMatrix(int[][] matrix) {
		for (int r = 0; r < matrix.length; r++)
			System.out.print(Arrays.toString(matrix[r]));
		System.out.println();
	}

	private static int[][] rotate90(int[][] matrix) {
		if (matrix.length != matrix[0].length)
			throw new UnsupportedOperationException("Only square matrix is supported.");
		transpose(matrix);
		reverseRows(matrix);
		return matrix;
	}

	private static void transpose(int[][] matrix) {
		for (int r = 0; r < matrix.length; r++)
			for (int c = r; c < matrix[0].length; c++) {
				int temp = matrix[r][c];
				matrix[r][c] = matrix[c][r];
				matrix[c][r] = temp;
			}
	}

	private static void reverseRows(int[][] matrix) {
		for (int r = 0; r < matrix.length; r++) {
			int left = 0;
			int right = matrix[0].length - 1;
			while (left < right) {
				int temp = matrix[r][left];
				matrix[r][left] = matrix[r][right];
				matrix[r][right] = temp;
				left++;
				right--;
			}
		}
	}

}
