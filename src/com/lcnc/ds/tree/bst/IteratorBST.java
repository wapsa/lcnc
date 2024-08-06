package com.lcnc.ds.tree.bst;

import java.util.ArrayDeque;
import java.util.Deque;

import com.lcnc.ds.tree.dfs.TreeNode;

public class IteratorBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(7);
		root.add(3, 15).right.add(9, 20);
		root.print();

		IteratorBST bstIterator = new IteratorBST(root);
		System.out.println(bstIterator.next()); // return 3
		System.out.println(bstIterator.next()); // return 7
		System.out.println(bstIterator.hasNext()); // return True
		System.out.println(bstIterator.next()); // return 9
		System.out.println(bstIterator.hasNext()); // return True
		System.out.println(bstIterator.next()); // return 15
		System.out.println(bstIterator.hasNext()); // return True
		System.out.println(bstIterator.hasNext()); // return False
	}

	private Deque<TreeNode> stack = new ArrayDeque<>();

	public IteratorBST(TreeNode root) {
		pushAll(root);
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode tmpNode = stack.pop();
		pushAll(tmpNode.right);
		return tmpNode.val;
	}

	private void pushAll(TreeNode node) {
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}
}
