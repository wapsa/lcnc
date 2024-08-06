package com.lcnc.ds.tree.dfs;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself
 * (i.e., symmetric around its center).
 * 
 * Example 1:
 * 
 * Input: root = [1,2,2,3,4,4,3] Output: true
 * 
 * Example 2:
 * 
 * Input: root = [1,2,2,null,3,null,3] Output: false
 */
public class SymmetricTree {

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		root1.add(2, 3);
		root1.print();
		System.out.println(isSymmetric(root1));

		root1 = new TreeNode(1);
		root1.addLeft(2);
		root1.print();
		System.out.println(isSymmetric(root1));

		root1 = new TreeNode(1);
		root1.add(2, 1);
		root1.print();
		System.out.println(isSymmetric(root1));

		System.out.println("---");

		root1 = new TreeNode(1);
		root1.add(2, 3);
		root1.print();
		System.out.println(isSymmetricPractice(root1));

		root1 = new TreeNode(1);
		root1.addLeft(2);
		root1.print();
		System.out.println(isSymmetricPractice(root1));

		root1 = new TreeNode(1);
		root1.add(2, 1);
		root1.print();
		System.out.println(isSymmetricPractice(root1));
	}

	private static boolean isSymmetricPractice(TreeNode root) {
		return false;
	}

	private static boolean isSymmetric(TreeNode root) {
		return dfs(root.left, root.right);
	}

	private static boolean dfs(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		if (left == null || right == null)
			return false;
		if (left.val != right.val)
			return false;
		return dfs(left.left, right.right) && dfs(left.right, right.left);
	}

}
