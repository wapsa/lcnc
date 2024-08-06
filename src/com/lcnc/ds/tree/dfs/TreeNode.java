package com.lcnc.ds.tree.dfs;

public class TreeNode {

	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode() {
	}

	public TreeNode(int val) {
		this.val = val;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public TreeNode addLeft(int val) {
		TreeNode node = new TreeNode(val);
		this.left = node;
		return node;
	}

	public TreeNode addRight(int val) {
		TreeNode node = new TreeNode(val);
		this.right = node;
		return node;
	}

	public TreeNode add(int leftVal, int rightVal) {
		addLeft(leftVal);
		addRight(rightVal);
		return this;
	}

	@Override
	public String toString() {
		return String.valueOf(val);
	}

	public void print() {
		System.out.print("inorder-> ");
		traverseInOrder(this);
		System.out.println();
		System.out.print("preorder-> ");
		traversePreOrder(this);
		System.out.println();
	}

	private void traverseInOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		traverseInOrder(node.left);
		System.out.print(":" + node.val);
		traverseInOrder(node.right);
	}

	private void traversePreOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		System.out.print(":" + node.val);
		traverseInOrder(node.left);
		traverseInOrder(node.right);
	}

}
