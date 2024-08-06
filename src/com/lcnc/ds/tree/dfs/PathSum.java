package com.lcnc.ds.tree.dfs;

/**
 * Given the root of a binary tree and an integer targetSum, return true if the
 * tree has a root-to-leaf path such that adding up all the values along the
 * path equals targetSum.
 * 
 * A leaf is a node with no children.
 * 
 * Example 1:
 * 
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * Output: true Explanation: The root-to-leaf path with the target sum is shown.
 * 
 * Example 2:
 * 
 * Input: root = [1,2,3], targetSum = 5 Output: false Explanation: There two
 * root-to-leaf paths in the tree: (1 --> 2): The sum is 3. (1 --> 3): The sum
 * is 4. There is no root-to-leaf path with sum = 5.
 * 
 * Example 3:
 * 
 * Input: root = [], targetSum = 0 Output: false Explanation: Since the tree is
 * empty, there are no root-to-leaf paths.
 */
public class PathSum {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.add(4, 8).left.addLeft(11).add(7, 2);
		root.print();
		System.out.println(hasPathSum(root, 22));

		root = new TreeNode(1);
		root.add(2, 3);
		root.print();
		System.out.println(hasPathSum(root, 5));

		System.out.println("---");

		root = new TreeNode(5);
		root.add(4, 8).left.addLeft(11).add(7, 2);
		root.print();
		System.out.println(hasPathSumPractice(root, 22));

		root = new TreeNode(1);
		root.add(2, 3);
		root.print();
		System.out.println(hasPathSumPractice(root, 5));
	}

	private static boolean hasPathSumPractice(TreeNode root, int targetSum) {
		return false;
	}

	private static boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null && targetSum - root.val == 0)
			return true;
		return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
	}

}
