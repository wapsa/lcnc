package com.lcnc.algo.twopointer;

/**
 * You are given an integer array height of length n. There are n vertical lines
 * drawn such that the two endpoints of the ith line are (i, 0) and (i,
 * height[i]).
 * 
 * Find two lines that together with the x-axis form a container, such that the
 * container contains the most water.
 * 
 * Return the maximum amount of water a container can store.
 * 
 * Notice that you may not slant the container.
 * 
 * Example 1: Input: height = [1,8,6,2,5,4,8,3,7] Output: 49 Explanation: The
 * above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this
 * case, the max area of water (blue section) the container can contain is 49.
 * 
 * Example 2: Input: height = [1,1] Output: 1
 */
public class ContainerWithMostWater {

	public static void main(String[] args) {
		System.out.println(maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
		System.out.println(maxArea(new int[] { 1, 1 }));

		System.out.println("---");

		System.out.println(maxAreaPractice(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
		System.out.println(maxAreaPractice(new int[] { 1, 1 }));
	}

	private static int maxAreaPractice(int[] heights) {
		return -1;
	}

	private static int maxArea(int[] heights) {
		int left = 0;
		int right = heights.length - 1;
		int maxWater = 0;
		int maxHeight = 0;
		while (left < right) {
			// 1. water can only be stored till the lowest height tower.
			int currMinHeight = Math.min(heights[left], heights[right]);

			// 2. as we start with largest width and keep contracting, the area of rectangle
			// can only increase if height is greater than what we have observed till now.
			if (currMinHeight > maxHeight) {
				int width = right - left;
				maxWater = Math.max(maxWater, (currMinHeight * width));
				maxHeight = currMinHeight;
			}
			// 3. if heights are equal, we skip both due to its relation with point 1 & 2
			// if we consider either of them then currMinHeight will be the same, and as
			// width is reducing we will not get a greater area.
			if (heights[left] == heights[right]) {
				left++;
				right--;
			} else if (heights[left] < heights[right]) {
				left++;
			} else {
				right--;
			}
		}
		return maxWater;
	}

}
