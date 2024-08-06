package com.lcnc.ds.tree.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.lcnc.ds.tree.dfs.TreeNode;

/**
 * Given the root of a binary tree, return the level order traversal of its
 * nodes' values. (i.e., from left to right, level by level).
 * 
 * Example 1:
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
public class ZigZagTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.add(9, 20).right.add(15, 7);
		root.print();
		System.out.println(zigzagLevelOrder(root));

		root = new TreeNode(1);
		root.add(2, 2).left.add(3, 3).left.add(4, 4);
		root.print();
		System.out.println(zigzagLevelOrder(root));

		System.out.println("---");

		root = new TreeNode(3);
		root.add(9, 20).right.add(15, 7);
		root.print();
		System.out.println(zigzagLevelOrderPractice(root));

		root = new TreeNode(1);
		root.add(2, 2).left.add(3, 3).left.add(4, 4);
		root.print();
		System.out.println(zigzagLevelOrderPractice(root));
	}

	private static List<List<Integer>> zigzagLevelOrderPractice(TreeNode root) {
		return null;
	}

	private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		boolean zig = true;
		while (!queue.isEmpty()) {
			LinkedList<Integer> level = new LinkedList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (zig)
					level.addLast(node.val);
				else
					level.addFirst(node.val);
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}

			res.add(level);
			zig = !zig;
		}
		return res;
	}

}
