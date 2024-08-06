package com.lcnc.ds.tree.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import com.lcnc.ds.tree.dfs.TreeNode;

/**
 * Given the root of a binary tree, imagine yourself standing on the right side
 * of it, return the values of the nodes you can see ordered from top to bottom.
 * 
 * Example 1:
 * 
 * Input: root = [1,2,3,null,5,null,4] Output: [1,3,4]
 * 
 * Example 2:
 * 
 * Input: root = [1,null,3] Output: [1,3]
 * 
 * Example 3:
 * 
 * Input: root = [] Output: []
 */
public class RightSideView {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.add(9, 20).right.add(15, 7);
		root.print();
		System.out.println(rightSideView(root));

		root = new TreeNode(1);
		root.add(2, 2).left.add(3, 3).left.add(4, 4);
		root.print();
		System.out.println(rightSideView(root));

		System.out.println("---");

		root = new TreeNode(3);
		root.add(9, 20).right.add(15, 7);
		root.print();
		System.out.println(rightSideViewPractice(root));

		root = new TreeNode(1);
		root.add(2, 2).left.add(3, 3).left.add(4, 4);
		root.print();
		System.out.println(rightSideViewPractice(root));
	}

	private static List<Integer> rightSideViewPractice(TreeNode root) {
		return null;
	}

	private static List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			TreeNode last = null;
			for (int i = 0; i < size; i++) {
				last = queue.poll();
				if (last.left != null)
					queue.add(last.left);
				if (last.right != null)
					queue.add(last.right);
			}
			res.add(last.val);
		}
		return res;
	}

}
