package com.lcnc.ds.matrix;

import java.util.Arrays;

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by
 * 180 degrees (clockwise).
 * 
 * You have to rotate the image in-place, which means you have to modify the
 * input 2D matrix directly. DO NOT allocate another 2D matrix and do the
 * rotation.
 * 
 * Example 1:
 * 
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]] Output: [[9,8,7][6,5,4][3,2,1]]
 * 
 * Example 2:
 * 
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]] Output:
 * [[16,12,14,15][7,6,3,13][10,8,4,2][11,9,1,5]]
 * 
 */
public class RotateImage180 {

	public static void main(String[] args) {
		printMatrix(rotate180(new int[][] { { 1 } }));
		printMatrix(rotate180(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
		printMatrix(rotate180(new int[][] { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } }));

		System.out.println("---");

		printMatrix(rotate180Practice(new int[][] { { 1 } }));
		printMatrix(rotate180Practice(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
		printMatrix(rotate180Practice(
				new int[][] { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } }));
	}

	private static int[][] rotate180Practice(int[][] matrix) {
		if (matrix.length != matrix[0].length)
			throw new UnsupportedOperationException("Only square matrix is supported.");
		reverseRowsPractice(matrix);
		reverseColsPractice(matrix);
		return matrix;
	}

	private static void reverseColsPractice(int[][] matrix) {

	}

	private static void reverseRowsPractice(int[][] matrix) {

	}

	private static void printMatrix(int[][] matrix) {
		for (int r = 0; r < matrix.length; r++)
			System.out.print(Arrays.toString(matrix[r]));
		System.out.println();
	}

	private static int[][] rotate180(int[][] matrix) {
		if (matrix.length != matrix[0].length)
			throw new UnsupportedOperationException("Only square matrix is supported.");
		reverseRows(matrix);
		reverseCols(matrix);
		return matrix;
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

	private static void reverseCols(int[][] matrix) {
		for (int c = 0; c < matrix[0].length; c++) {
			int top = 0;
			int bottom = matrix.length - 1;
			while (top < bottom) {
				int temp = matrix[top][c];
				matrix[top][c] = matrix[bottom][c];
				matrix[bottom][c] = temp;
				top++;
				bottom--;
			}
		}
	}

}
