package com.lcnc.ds.tree.bst;

import java.util.ArrayDeque;
import java.util.Deque;

import com.lcnc.ds.tree.dfs.TreeNode;

/**
 * Given the root of a binary tree, determine if it is a valid binary search
 * tree (BST).
 * 
 * A valid BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's
 * key. The right subtree of a node contains only nodes with keys greater than
 * the node's key. Both the left and right subtrees must also be binary search
 * trees.
 * 
 * Example 1:
 * 
 * Input: root = [2,1,3] Output: true
 * 
 * Example 2:
 * 
 * Input: root = [5,1,4,null,null,3,6] Output: false Explanation: The root
 * node's value is 5 but its right child's value is 4.
 */
public class ValidateBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		root.add(2, 8);
		root.left.add(0, 4).right.add(3, 5);
		root.right.add(7, 9);
		root.print();
		System.out.println(isValidBST(root));

		root = new TreeNode(6);
		root.add(2, 8);
		root.left.add(0, 4).right.add(3, 5);
		root.right.add(7, 9);
		root.print();
		System.out.println(isValidBST(root));

		System.out.println("---");

		root = new TreeNode(6);
		root.add(2, 8);
		root.left.add(0, 4).right.add(3, 5);
		root.right.add(7, 9);
		root.print();
		System.out.println(isValidBSTPractice(root));

		root = new TreeNode(6);
		root.add(2, 8);
		root.left.add(0, 4).right.add(3, 5);
		root.right.add(7, 9);
		root.print();
		System.out.println(isValidBSTPractice(root));

	}

	private static boolean isValidBSTPractice(TreeNode root) {
		return false;
	}

	private static boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode prev = null;
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (prev != null && root.val <= prev.val)
				return false;
			prev = root;
			root = root.right;
		}
		return true;
	}

}
