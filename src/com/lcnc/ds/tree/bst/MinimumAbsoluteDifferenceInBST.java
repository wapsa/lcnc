package com.lcnc.ds.tree.bst;

import java.util.ArrayDeque;
import java.util.Deque;

import com.lcnc.ds.tree.dfs.TreeNode;

/**
 * Given the root of a Binary Search Tree (BST), return the minimum absolute
 * difference between the values of any two different nodes in the tree.
 * 
 * Example 1:
 * 
 * Input: root = [4,2,6,1,3] Output: 1
 * 
 * Example 2:
 * 
 * Input: root = [1,0,48,null,null,12,49] Output: 1
 */
public class MinimumAbsoluteDifferenceInBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.add(2, 6).left.add(1, 3);
		root.print();
		System.out.println(getMinimumDifference(root));

		root = new TreeNode(1);
		root.add(0, 48).right.add(12, 49);
		root.print();
		System.out.println(getMinimumDifference(root));

		System.out.println("---");

		root = new TreeNode(4);
		root.add(2, 6).left.add(1, 3);
		root.print();
		System.out.println(getMinimumDifferencePractice(root));

		root = new TreeNode(1);
		root.add(0, 48).right.add(12, 49);
		root.print();
		System.out.println(getMinimumDifferencePractice(root));

	}

	private static int getMinimumDifferencePractice(TreeNode root) {
		return -1;
	}

	private static int getMinimumDifference(TreeNode root) {
		if (root == null)
			return 0;
		int min = Integer.MAX_VALUE;
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode prev = null;
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (prev != null)
				min = Math.min(min, Math.abs(prev.val - root.val));
			prev = root;
			root = root.right;
		}
		return min;
	}

}
