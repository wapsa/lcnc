package com.lcnc.ds.tree.dfs;

public class FlattenBinaryTreeToLinkedList {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.add(2, 5).left.add(3, 4);
		root.print();
		flatten(root);
		root.print();

		System.out.println("---");

		root = new TreeNode(1);
		root.add(2, 5).left.add(3, 4);
		root.print();
		flattenPractice(root);
		root.print();
	}

	private static void flattenPractice(TreeNode root) {

	}

	private static void flatten(TreeNode root) {
		flatten(root, null);
	}

	private static TreeNode flatten(TreeNode root, TreeNode tail) {
		if (root == null)
			return tail;
		// Flatten the right subtree first, providing the current tail
		root.right = flatten(root.right, tail);
		// Flatten the left subtree, setting the tail to the previously flattened right
		// subtree
		root.right = flatten(root.left, root.right);
		// Ensure the left child is null
		root.left = null;
		// Return the current root as the new tail
		return root;
	}
}
