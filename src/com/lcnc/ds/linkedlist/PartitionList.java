package com.lcnc.ds.linkedlist;

/**
 * Given the head of a linked list and a value x, partition it such that all
 * nodes less than x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * Example 1:
 * 
 * Input: head = [1,4,3,2,5,2], x = 3 Output: [1,2,2,4,3,5]
 * 
 * Example 2:
 * 
 * Input: head = [2,1], x = 2 Output: [1,2]
 */
public class PartitionList {

	public static void main(String[] args) {
		ListNode res = partition(new ListNode(new int[] { 1, 4, 3, 2, 5, 2 }), 3);
		res.print();
		res = partition(new ListNode(new int[] { 2, 1 }), 2);
		res.print();

		System.out.println("---");

		res = partitionPractice(new ListNode(new int[] { 1, 4, 3, 2, 5, 2 }), 3);
		res.print();
		res = partitionPractice(new ListNode(new int[] { 2, 1 }), 2);
		res.print();
	}

	private static ListNode partitionPractice(ListNode head, int x) {
		return new ListNode();
	}

	private static ListNode partition(ListNode head, int x) {
		if (head == null)
			return new ListNode();
		if (head.next == null)
			return head;

		ListNode left = new ListNode();
		ListNode leftTail = left;
		ListNode right = new ListNode();
		ListNode rightTail = right;
		ListNode curr = head;
		while (curr != null) {
			ListNode next = curr.next;
			curr.next = null;
			if (curr.val < x) {
				leftTail.next = curr;
				leftTail = curr;
			} else {
				rightTail.next = curr;
				rightTail = curr;
			}
			curr = next;
		}
		leftTail.next = right.next;
		return left.next;
	}

}
