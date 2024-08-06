package com.lcnc.ds.tree.dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class InOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.add(2, 3).left.add(4, 5);
		root.print();
		System.out.println(traverseInOrderIterative(root));

		root = new TreeNode(1);
		root.addLeft(2);
		root.print();
		System.out.println(traverseInOrderIterative(root));

		System.out.println("---");

		root = new TreeNode(1);
		root.add(2, 3).left.add(4, 5);
		root.print();
		System.out.println(traverseInOrderIterativePractice(root));

		root = new TreeNode(1);
		root.addLeft(2);
		root.print();
		System.out.println(traverseInOrderIterativePractice(root));
	}

	private static List<Integer> traverseInOrderIterativePractice(TreeNode root) {
		return null;
	}

	private static List<Integer> traverseInOrderIterative(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		Deque<TreeNode> stack = new ArrayDeque<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			res.add(root.val);
			root = root.right;
		}
		return res;
	}

}
