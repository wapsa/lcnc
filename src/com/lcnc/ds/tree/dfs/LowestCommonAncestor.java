package com.lcnc.ds.tree.dfs;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes
 * in the tree.
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes p and q as the lowest node in T that has both p
 * and q as descendants (where we allow a node to be a descendant of itself).”
 * 
 * Example 1:
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1 Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * 
 * Example 2:
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4 Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant
 * of itself according to the LCA definition.
 * 
 * Example 3:
 * 
 * Input: root = [1,2], p = 1, q = 2 Output: 1
 */
public class LowestCommonAncestor {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		root.add(2, 8);
		root.left.add(0, 4).right.add(3, 5);
		root.right.add(7, 9);
		root.print();
		System.out.println(lowestCommonAncestor(root, 2, 8));

		root = new TreeNode(6);
		root.add(2, 8);
		root.left.add(0, 4).right.add(3, 5);
		root.right.add(7, 9);
		root.print();
		System.out.println(lowestCommonAncestor(root, 2, 4));

		root = new TreeNode(3);
		root.add(5, 1);
		root.left.add(6, 2).right.add(7, 4);
		root.right.add(0, 8);
		root.print();
		System.out.println(lowestCommonAncestor(root, 5, 1));

		root = new TreeNode(3);
		root.add(5, 1);
		root.left.add(6, 2).right.add(7, 4);
		root.right.add(0, 8);
		root.print();
		System.out.println(lowestCommonAncestor(root, 5, 4));

		System.out.println("---");

		root = new TreeNode(6);
		root.add(2, 8);
		root.left.add(0, 4).right.add(3, 5);
		root.right.add(7, 9);
		root.print();
		System.out.println(lowestCommonAncestorPractice(root, 2, 8));

		root = new TreeNode(6);
		root.add(2, 8);
		root.left.add(0, 4).right.add(3, 5);
		root.right.add(7, 9);
		root.print();
		System.out.println(lowestCommonAncestorPractice(root, 2, 4));

		root = new TreeNode(3);
		root.add(5, 1);
		root.left.add(6, 2).right.add(7, 4);
		root.right.add(0, 8);
		root.print();
		System.out.println(lowestCommonAncestorPractice(root, 5, 1));

		root = new TreeNode(3);
		root.add(5, 1);
		root.left.add(6, 2).right.add(7, 4);
		root.right.add(0, 8);
		root.print();
		System.out.println(lowestCommonAncestorPractice(root, 5, 4));
	}

	private static Integer lowestCommonAncestorPractice(TreeNode root, int p, int q) {
		return -1;
	}

	private static Integer lowestCommonAncestor(TreeNode root, int p, int q) {
		if (root == null)
			return null;
		if (root.val == p || root.val == q)
			return root.val;

		Integer left = lowestCommonAncestor(root.left, p, q);
		Integer right = lowestCommonAncestor(root.right, p, q);
		if (left == null)
			return right;
		if (right == null)
			return left;
		return root.val;
	}

}
