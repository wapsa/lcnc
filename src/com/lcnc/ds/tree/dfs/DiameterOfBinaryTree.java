package com.lcnc.ds.tree.dfs;

/**
 * Given the root of a binary tree, return the length of the diameter of the
 * tree.
 * 
 * The diameter of a binary tree is the length of the longest path between any
 * two nodes in a tree. This path may or may not pass through the root.
 * 
 * The length of a path between two nodes is represented by the number of edges
 * between them.
 * 
 * Example 1:
 * 
 * Input: root = [1,2,3,4,5] Output: 3 Explanation: 3 is the length of the path
 * [4,2,1,3] or [5,2,1,3].
 * 
 * Example 2:
 * 
 * Input: root = [1,2] Output: 1
 * 
 * 
 * Diameter = MAX(Diameter, leftDepth + rightDepth)
 */
public class DiameterOfBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.add(2, 3).left.add(4, 5);
		root.print();
		System.out.println(diameterOfBinaryTree(root));

		root = new TreeNode(1);
		root.addLeft(2);
		root.print();
		System.out.println(diameterOfBinaryTree(root));

		System.out.println("---");

		root = new TreeNode(1);
		root.add(2, 3).left.add(4, 5);
		root.print();
		System.out.println(diameterOfBinaryTreePractice(root));

		root = new TreeNode(1);
		root.addLeft(2);
		root.print();
		System.out.println(diameterOfBinaryTreePractice(root));
	}

	private static int diameterOfBinaryTreePractice(TreeNode root) {
		return 0;
	}

	private static int diameterOfBinaryTree(TreeNode root) {
		return maxDepth(root).diameter;
	}

	private static Dto maxDepth(TreeNode root) {
		if (root == null)
			return new Dto(0, 0);
		Dto left = maxDepth(root.left);
		Dto right = maxDepth(root.right);
		int diameter = Math.max(left.diameter, right.diameter);
		diameter = Math.max(diameter, left.depth + right.depth);
		return new Dto(1 + Math.max(left.depth, right.depth), diameter);
	}

	private static record Dto(int depth, int diameter) {
	}

}
