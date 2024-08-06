package com.lcnc.algo.divideandconq;

import com.lcnc.ds.tree.dfs.TreeNode;

/**
 * Given an integer array nums where the elements are sorted in ascending order,
 * convert it to a height-balanced binary search tree.
 * 
 * Example 1:
 * 
 * Input: nums = [-10,-3,0,5,9] Output: [0,-3,9,-10,null,5] Explanation:
 * [0,-10,5,null,-3,null,9] is also accepted:
 * 
 * Example 2:
 * 
 * Input: nums = [1,3] Output: [3,1] Explanation: [1,null,3] and [3,1] are both
 * height-balanced BSTs.
 */
public class SortedArrayToBinarySearchTree {

	public static void main(String[] args) {
		sortedArrayToBST(new int[] { -10, -3, 0, 5, 9 }).print();
		sortedArrayToBST(new int[] { 1, 3 }).print();

		System.out.println("---");

		sortedArrayToBSTPractice(new int[] { -10, -3, 0, 5, 9 }).print();
		sortedArrayToBSTPractice(new int[] { 1, 3 }).print();
	}

	private static TreeNode sortedArrayToBSTPractice(int[] nums) {
		return new TreeNode();
	}

	private static TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 0)
			return new TreeNode();
		TreeNode head = recursiveBST(nums, 0, nums.length - 1);
		return head;
	}

	private static TreeNode recursiveBST(int[] nums, int left, int right) {
		if (left > right)
			return null;
		int mid = (left + right) / 2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = recursiveBST(nums, left, mid - 1);
		node.right = recursiveBST(nums, mid + 1, right);
		return node;
	}

}
