package com.lcnc.ds.linkedlist;

/**
 * Given the head of a linked list, rotate the list to the right by k places.
 * 
 * Example 1:
 * 
 * Input: head = [1,2,3,4,5], k = 2 Output: [4,5,1,2,3]
 * 
 * Example 2:
 * 
 * Input: head = [0,1,2], k = 4 Output: [2,0,1]
 */
public class RotateListRight {

	public static void main(String[] args) {
		ListNode res = rotateRight(new ListNode(new int[] { 1, 2, 3, 4, 5 }), 2);
		res.print();
		res = rotateRight(new ListNode(new int[] { 0, 1, 2 }), 4);
		res.print();

		System.out.println("---");

		res = rotateRightPractice(new ListNode(new int[] { 1, 2, 3, 4, 5 }), 2);
		res.print();
		res = rotateRightPractice(new ListNode(new int[] { 0, 1, 2 }), 4);
		res.print();
	}

	private static ListNode rotateRightPractice(ListNode head, int k) {
		return new ListNode();
	}

	private static ListNode rotateRight(ListNode head, int k) {
		int size = size(head);
		if (size == 0)
			return new ListNode();
		k = k % size;
		if (k == 0)
			return head;
		ListNode slow = head;
		ListNode fast = head;
		for (int i = 0; i < k; i++)
			fast = fast.next;
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		ListNode res = slow.next;
		slow.next = null;
		fast.next = head;
		return res;
	}

	private static int size(ListNode head) {
		int size = 0;
		while (head != null) {
			size++;
			head = head.next;
		}
		return size;
	}

}
