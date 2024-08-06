package com.lcnc.ds.tree.dfs;

/**
 * Given the roots of two binary trees p and q, write a function to check if
 * they are the same or not.
 * 
 * Two binary trees are considered the same if they are structurally identical,
 * and the nodes have the same value.
 * 
 * Example 1:
 * 
 * Input: p = [1,2,3], q = [1,2,3] Output: true
 * 
 * Example 2:
 * 
 * Input: p = [1,2], q = [1,null,2] Output: false
 * 
 * Example 3:
 * 
 * Input: p = [1,2,1], q = [1,1,2] Output: false
 */
public class SameTree {

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		root1.add(2, 3);
		root1.print();
		TreeNode root2 = new TreeNode(1);
		root2.add(2, 3);
		root2.print();
		System.out.println(isSameTree(root1, root2));

		root1 = new TreeNode(1);
		root1.addLeft(2);
		root1.print();
		root2 = new TreeNode(1);
		root2.addRight(2);
		root2.print();
		System.out.println(isSameTree(root1, root2));

		root1 = new TreeNode(1);
		root1.add(2, 1);
		root1.print();
		root2 = new TreeNode(1);
		root2.add(1, 2);
		root2.print();
		System.out.println(isSameTree(root1, root2));

		System.out.println("---");

		root1 = new TreeNode(1);
		root1.add(2, 3);
		root1.print();
		root2 = new TreeNode(1);
		root2.add(2, 3);
		root2.print();
		System.out.println(isSameTreePractice(root1, root2));

		root1 = new TreeNode(1);
		root1.addLeft(2);
		root1.print();
		root2 = new TreeNode(1);
		root2.addRight(2);
		root2.print();
		System.out.println(isSameTreePractice(root1, root2));

		root1 = new TreeNode(1);
		root1.add(2, 1);
		root1.print();
		root2 = new TreeNode(1);
		root2.add(1, 2);
		root2.print();
		System.out.println(isSameTreePractice(root1, root2));
	}

	private static boolean isSameTreePractice(TreeNode p, TreeNode q) {
		return false;
	}

	private static boolean isSameTree(TreeNode p, TreeNode q) {
		// Base case: if both trees are null, they are identical
		if (p == null && q == null)
			return true;
		// If only one tree is null or the values are different, they are not identical
		if (p == null || q == null || p.val != q.val)
			return false;
		// Recursively check if the left and right subtrees are identical
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

}
