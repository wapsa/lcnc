package com.lcnc.ds.matrix;

import java.util.Arrays;

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by
 * 270 degrees (clockwise).
 * 
 * You have to rotate the image in-place, which means you have to modify the
 * input 2D matrix directly. DO NOT allocate another 2D matrix and do the
 * rotation.
 * 
 * Example 1:
 * 
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]] Output: [[3,6,9][2,5,8][1,4,7]]
 * 
 * Example 2:
 * 
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]] Output:
 * [[11,10,7,16][9,8,6,12][1,4,3,14][5,2,13,15]]
 * 
 */
public class RotateImage270 {

	public static void main(String[] args) {
		printMatrix(rotate270(new int[][] { { 1 } }));
		printMatrix(rotate270(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
		printMatrix(rotate270(new int[][] { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } }));

		System.out.println("---");

		printMatrix(rotate270Practice(new int[][] { { 1 } }));
		printMatrix(rotate270Practice(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
		printMatrix(rotate270Practice(
				new int[][] { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } }));
	}

	private static int[][] rotate270Practice(int[][] matrix) {
		if (matrix.length != matrix[0].length)
			throw new UnsupportedOperationException("Only square matrix is supported.");
		transposePractice(matrix);
		reverseColsPractice(matrix);
		return matrix;
	}

	private static void transposePractice(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix[0].length; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}

	private static void reverseColsPractice(int[][] matrix) {
		for (int c = 0; c < matrix[0].length; c++) {
			int up = 0;
			int down = matrix[0].length - 1;
			while (up < down) {
				int temp = matrix[up][c];
				matrix[up][c] = matrix[down][c];
				matrix[down][c] = temp;
				up++;
				down--;
			}
		}
	}

	private static void printMatrix(int[][] matrix) {
		for (int r = 0; r < matrix.length; r++)
			System.out.print(Arrays.toString(matrix[r]));
		System.out.println();
	}

	private static int[][] rotate270(int[][] matrix) {
		if (matrix.length != matrix[0].length)
			throw new UnsupportedOperationException("Only square matrix is supported.");
		transpose(matrix);
		reverseCols(matrix);
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
