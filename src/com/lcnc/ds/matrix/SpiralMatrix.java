package com.lcnc.ds.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * 
 * Example 1: Input: matrix = [[1,2,3],[4,5,6],[7,8,9]] Output:
 * [1,2,3,6,9,8,7,4,5]
 * 
 * Example 2: Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]] Output:
 * [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 */
public class SpiralMatrix {

	public static void main(String[] args) {
		System.out.println(spiralOrder(new int[][] { {} }));
		System.out.println(spiralOrder(new int[][] { { 1 } }));
		System.out.println(spiralOrder(new int[][] { { 1 }, { 2 }, { 3 } }));
		System.out.println(spiralOrder(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
		System.out.println(spiralOrder(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } }));

		System.out.println("---");

		System.out.println(spiralOrderPractice(new int[][] { {} }));
		System.out.println(spiralOrderPractice(new int[][] { { 1 } }));
		System.out.println(spiralOrderPractice(new int[][] { { 1 }, { 2 }, { 3 } }));
		System.out.println(spiralOrderPractice(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
		System.out.println(spiralOrderPractice(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } }));
	}

	private static List<Integer> spiralOrderPractice(int[][] matrix) {
		return null;
	}

	private static List<Integer> spiralOrder(int[][] matrix) {
		int matrixSize = matrix.length * matrix[0].length;
		List<Integer> res = new ArrayList<>(matrixSize);
		int margin = 0;
		int r = 0;
		int c = 0;
		while (res.size() != matrixSize) {
			// move right
			while (c < matrix[0].length - margin)
				res.add(matrix[r][c++]);
			c--;
			r++;
			// move down
			while (r < matrix.length - margin && res.size() != matrixSize)
				res.add(matrix[r++][c]);
			r--;
			c--;
			// move left
			while (c >= 0 + margin && res.size() != matrixSize)
				res.add(matrix[r][c--]);
			c++;
			r--;
			margin++;
			// move up
			while (r >= 0 + margin && res.size() != matrixSize)
				res.add(matrix[r--][c]);
			r++;
			c++;
		}
		return res;
	}

}
