package com.lcnc.ds.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class ListNode {

	public int val = -1111111;
	public ListNode next;

	public ListNode() {
	}

	public ListNode(int val) {
		this.val = val;
	}

	public ListNode(int[] xs) {
		this(xs, -1);
	}

	ListNode(int[] xs, int circleAt) {
		if (xs.length == 0)
			return;
		val = xs[0];
		ListNode circleNode = null;
		ListNode node = new ListNode();
		next = node;
		for (int i = 1; i < xs.length; i++) {
			if (circleAt >= 0) {
				if (circleAt == 0) {
					circleNode = this;
				} else if (i == circleAt)
					circleNode = node;
			}
			node.val = xs[i];
			if (i != xs.length - 1) {
				ListNode newNode = new ListNode();
				node.next = newNode;
				node = newNode;
			}
		}
		node.next = circleNode;
	}

	public void print() {
		StringBuilder builder = new StringBuilder();
		Set<ListNode> dups = new HashSet<>();
		ListNode node = this;
		while (node.next != null) {
			if (dups.contains(node) || node.val < -1111110)
				break;
			builder.append(node.val + ", ");
			dups.add(node);
			node = node.next;
		}
		if (node.val >= 0)
			builder.append(node.val);
		System.out.println("list: " + builder.toString());
	}

	@Override
	public String toString() {
		return String.valueOf(val);
	}

}
