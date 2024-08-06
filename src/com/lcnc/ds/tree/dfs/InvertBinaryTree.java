package com.lcnc.ds.tree.dfs;

/**
 * Given the root of a binary tree, invert the tree, and return its root.
 * 
 * Example 1:
 * 
 * Input: root = [4,2,7,1,3,6,9] Output: [4,7,2,9,6,3,1]
 * 
 * Example 2:
 * 
 * Input: root = [2,1,3] Output: [2,3,1]
 * 
 * Example 3:
 * 
 * Input: root = [] Output: []
 */
public class InvertBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.add(9, 20).right.add(15, 7);
		root.print();
		invertTree(root).print();

		root = new TreeNode(1);
		root.addRight(2);
		root.print();
		invertTree(root).print();

		System.out.println("---");

		root = new TreeNode(3);
		root.add(9, 20).right.add(15, 7);
		root.print();
		invertTreePractice(root).print();

		root = new TreeNode(1);
		root.addRight(2);
		root.print();
		invertTreePractice(root).print();
	}

	private static TreeNode invertTreePractice(TreeNode root) {
		return new TreeNode();
	}

	private static TreeNode invertTree(TreeNode root) {
		if (root == null)
			return new TreeNode();

		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;

		invertTree(root.left);
		invertTree(root.right);
		return root;
	}

}
