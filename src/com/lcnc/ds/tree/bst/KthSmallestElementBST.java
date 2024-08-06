package com.lcnc.ds.tree.bst;

import java.util.ArrayDeque;
import java.util.Deque;

import com.lcnc.ds.tree.dfs.TreeNode;

/**
 * Given the root of a binary search tree, and an integer k, return the kth
 * smallest value (1-indexed) of all the values of the nodes in the tree.
 * 
 * Example 1:
 * 
 * Input: root = [3,1,4,null,2], k = 1 Output: 1
 * 
 * Example 2:
 * 
 * Input: root = [5,3,6,2,4,null,null,1], k = 3 Output: 3
 */
public class KthSmallestElementBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		root.add(2, 8);
		root.left.add(0, 4).right.add(3, 5);
		root.right.add(7, 9);
		root.print();
		System.out.println(kthSmallest(root, 2));

		root = new TreeNode(6);
		root.add(2, 8);
		root.left.add(0, 4).right.add(3, 5);
		root.right.add(7, 9);
		root.print();
		System.out.println(kthSmallest(root, 3));

		System.out.println("---");

		root = new TreeNode(6);
		root.add(2, 8);
		root.left.add(0, 4).right.add(3, 5);
		root.right.add(7, 9);
		root.print();
		System.out.println(kthSmallestPractice(root, 2));

		root = new TreeNode(6);
		root.add(2, 8);
		root.left.add(0, 4).right.add(3, 5);
		root.right.add(7, 9);
		root.print();
		System.out.println(kthSmallestPractice(root, 3));
	}

	private static int kthSmallestPractice(TreeNode root, int k) {
		return -1;
	}

	private static int kthSmallest(TreeNode root, int k) {
		Deque<TreeNode> stack = new ArrayDeque<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (--k == 0)
				break;
			root = root.right;
		}
		return root.val;
	}

}
