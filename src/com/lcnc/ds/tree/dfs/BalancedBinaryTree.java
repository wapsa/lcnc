package com.lcnc.ds.tree.dfs;

/**
 * Given a binary tree, determine if it is height-balanced. A height-balanced
 * binary tree is a binary tree in which the depth of the two subtrees of every
 * node never differs by more than one.
 * 
 * Example 1:
 * 
 * Input: root = [3,9,20,null,null,15,7] Output: true
 * 
 * Example 2:
 * 
 * Input: root = [1,2,2,3,3,null,null,4,4] Output: false
 * 
 * Example 3:
 * 
 * Input: root = [] Output: true
 */
public class BalancedBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.add(9, 20).right.add(15, 7);
		root.print();
		System.out.println(isBalanced(root));

		root = new TreeNode(1);
		root.add(2, 2).left.add(3, 3).left.add(4, 4);
		root.print();
		System.out.println(isBalanced(root));

		System.out.println("---");

		root = new TreeNode(3);
		root.add(9, 20).right.add(15, 7);
		root.print();
		System.out.println(isBalancedPractice(root));

		root = new TreeNode(1);
		root.add(2, 2).left.add(3, 3).left.add(4, 4);
		root.print();
		System.out.println(isBalancedPractice(root));
	}

	private static boolean isBalancedPractice(TreeNode root) {
		return false;
	}

	private static boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		int left = MaximumDepthOfBinaryTree.maxDepth(root.left);
		int right = MaximumDepthOfBinaryTree.maxDepth(root.right);
		return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
	}

}
