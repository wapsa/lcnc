package com.lcnc.ds.tree.dfs;

/**
 * Given the root of a binary tree, return its maximum depth.
 * 
 * A binary tree's maximum depth is the number of nodes along the longest path
 * from the root node down to the farthest leaf node.
 * 
 * Example 1:
 * 
 * Input: root = [3,9,20,null,null,15,7] Output: 3
 * 
 * Example 2:
 * 
 * Input: root = [1,null,2] Output: 2
 */
public class MaximumDepthOfBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.add(9, 20).right.add(15, 7);
		root.print();
		System.out.println(maxDepth(root));

		root = new TreeNode(1);
		root.addRight(2);
		root.print();
		System.out.println(maxDepth(root));

		System.out.println("---");

		root = new TreeNode(3);
		root.add(9, 20).right.add(15, 7);
		root.print();
		System.out.println(maxDepthPractice(root));

		root = new TreeNode(1);
		root.addRight(2);
		root.print();
		System.out.println(maxDepthPractice(root));
	}

	private static int maxDepthPractice(TreeNode node) {
		return 0;
	}

	public static int maxDepth(TreeNode node) {
		if (node == null)
			return 0;
		int left = maxDepth(node.left);
		int right = maxDepth(node.right);
		return 1 + Math.max(left, right);
	}

}
