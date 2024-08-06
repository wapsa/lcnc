package com.lcnc.algo.twopointer;

import java.util.Arrays;

/**
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it can trap after raining.
 * 
 * Example 1: Input: height = [0,1,0,2,1,0,1,3,2,1,2,1] Output: 6 Explanation:
 * The above elevation map (black section) is represented by array
 * [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section)
 * are being trapped.
 * 
 * Example 2: Input: height = [4,2,0,3,2,5] Output: 9
 */
public class TrappingRainWaterHistogram {

	public static void main(String[] args) {
		System.out.println(trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
		System.out.println(trap(new int[] { 4, 2, 0, 3, 2, 5 }));

		System.out.println("---");

		System.out.println(trap1(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
		System.out.println(trap1(new int[] { 4, 2, 0, 3, 2, 5 }));

		System.out.println("---");

		System.out.println(trapPractice(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
		System.out.println(trapPractice(new int[] { 4, 2, 0, 3, 2, 5 }));
	}

	private static int trapPractice(int[] heights) {
		return -1;
	}

	private static int trap(int[] heights) {
		int[] left = new int[heights.length];
		left[0] = heights[0];
		for (int i = 1; i < heights.length; i++)
			left[i] = Math.max(left[i - 1], heights[i]);
		System.out.println("left: " + Arrays.toString(left));
		int[] right = new int[heights.length];
		right[heights.length - 1] = heights[heights.length - 1];
		for (int i = heights.length - 2; i >= 0; i--)
			right[i] = Math.max(right[i + 1], heights[i]);
		System.out.println("right: " + Arrays.toString(right));
		int water = 0;
		for (int i = 0; i < heights.length; i++)
			water += Math.min(left[i], right[i]) - heights[i];
		return water;
	}

	private static int trap1(int[] heights) {
		int left = 0;
		int right = heights.length - 1;
		int leftMax = heights[left];
		int rightMax = heights[right];
		int water = 0;
		while (left < right) {
			if (leftMax < rightMax) {
				left++;
				leftMax = Math.max(leftMax, heights[left]);
				water += leftMax - heights[left];
			} else {
				right--;
				rightMax = Math.max(rightMax, heights[right]);
				water += rightMax - heights[right];
			}
		}
		return water;
	}

}
