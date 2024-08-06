package com.lcnc.ds.tree.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.lcnc.ds.tree.dfs.TreeNode;

/**
 * Given the root of a binary tree, return the average value of the nodes on
 * each level in the form of an array. Answers within 10-5 of the actual answer
 * will be accepted.
 * 
 * Example 1:
 * 
 * Input: root = [3,9,20,null,null,15,7] Output: [3.00000,14.50000,11.00000]
 * Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5,
 * and on level 2 is 11. Hence return [3, 14.5, 11].
 * 
 * Example 2:
 * 
 * Input: root = [3,9,20,15,7] Output: [3.00000,14.50000,11.00000]
 */
public class AverageOfLevels {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.add(9, 20).right.add(15, 7);
		root.print();
		System.out.println(averageOfLevels(root));

		root = new TreeNode(1);
		root.add(2, 2).left.add(3, 3).left.add(4, 4);
		root.print();
		System.out.println(averageOfLevels(root));

		System.out.println("---");

		root = new TreeNode(3);
		root.add(9, 20).right.add(15, 7);
		root.print();
		System.out.println(averageOfLevelsPractice(root));

		root = new TreeNode(1);
		root.add(2, 2).left.add(3, 3).left.add(4, 4);
		root.print();
		System.out.println(averageOfLevelsPractice(root));
	}

	private static List<Double> averageOfLevelsPractice(TreeNode root) {
		return null;
	}

	private static List<Double> averageOfLevels(TreeNode root) {
		List<Double> res = new ArrayList<>();
		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			double sum = 0;
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				sum += node.val;
				if (node.left != null)
					queue.offer(node.left);
				if (node.right != null)
					queue.offer(node.right);
			}
			res.add(Double.valueOf(sum / size));
		}
		return res;
	}

}
