package com.lcnc.ds.tree.bst;

import com.lcnc.ds.tree.dfs.TreeNode;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node
 * of two given nodes in the BST.
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes p and q as the lowest node in T that has both p
 * and q as descendants (where we allow a node to be a descendant of itself).”
 * 
 * Example 1:
 * 
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8 Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * 
 * Example 2:
 * 
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4 Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant
 * of itself according to the LCA definition.
 * 
 * Example 3:
 * 
 * Input: root = [2,1], p = 2, q = 1 Output: 2
 */
public class LowestCommonAncestorBST {

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
	}

	private static int lowestCommonAncestorPractice(TreeNode root, int p, int q) {
		return -1;
	}

	private static int lowestCommonAncestor(TreeNode root, int p, int q) {
		TreeNode curr = root;
		while (curr != null) {
			if (p < curr.val && q < curr.val)
				curr = curr.left;
			else if (p > curr.val && q > curr.val)
				curr = curr.right;
			// else case>
			// 1. we have found either of p or q, so LCA will be curr.
			// 2. p & q are not in the same side of curr, 1 of them is at left path and the
			// other at right path, so LCA will be curr.
			else
				break;
		}
		return curr.val;
	}

}
