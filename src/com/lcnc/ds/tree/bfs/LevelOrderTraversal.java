package com.lcnc.ds.tree.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import com.lcnc.ds.tree.dfs.TreeNode;

/**
 * Given the root of a binary tree, return the level order traversal of its
 * nodes' values. (i.e., from left to right, level by level).
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,9,20,null,null,15,7] Output: [[3],[9,20],[15,7]]
 * 
 * Example 2:
 * 
 * Input: root = [1] Output: [[1]]
 * 
 * Example 3:
 * 
 * Input: root = [] Output: []
 */
public class LevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.add(9, 20).right.add(15, 7);
		root.print();
		System.out.println(levelOrderIterative(root));

		root = new TreeNode(1);
		root.add(2, 2).left.add(3, 3).left.add(4, 4);
		root.print();
		System.out.println(levelOrderIterative(root));

		System.out.println("---");

		root = new TreeNode(3);
		root.add(9, 20).right.add(15, 7);
		root.print();
		System.out.println(levelOrderRecursive(root));

		root = new TreeNode(1);
		root.add(2, 2).left.add(3, 3).left.add(4, 4);
		root.print();
		System.out.println(levelOrderRecursive(root));

		System.out.println("---");

		root = new TreeNode(3);
		root.add(9, 20).right.add(15, 7);
		root.print();
		System.out.println(levelOrderPractice(root));

		root = new TreeNode(1);
		root.add(2, 2).left.add(3, 3).left.add(4, 4);
		root.print();
		System.out.println(levelOrderPractice(root));
	}

	private static List<List<Integer>> levelOrderPractice(TreeNode root) {
		return null;
	}

	private static List<List<Integer>> levelOrderIterative(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			List<Integer> level = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				level.add(node.val);
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
			res.add(level);
		}
		return res;
	}

	private static List<List<Integer>> levelOrderRecursive(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		levelOrderRecursive(root, 0, res);
		return res;
	}

	private static void levelOrderRecursive(TreeNode root, int level, List<List<Integer>> res) {
		if (root == null)
			return;
		if (res.size() == level)
			res.add(new ArrayList<>());
		res.get(level).add(root.val);
		levelOrderRecursive(root.left, level + 1, res);
		levelOrderRecursive(root.right, level + 1, res);
	}

}
