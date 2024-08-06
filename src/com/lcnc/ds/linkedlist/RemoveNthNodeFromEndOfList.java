package com.lcnc.ds.linkedlist;

/**
 * Given the head of a linked list, remove the nth node from the end of the list
 * and return its head.
 * 
 * Example 1:
 * 
 * Input: head = [1,2,3,4,5], n = 2 Output: [1,2,3,5]
 * 
 * Example 2:
 * 
 * Input: head = [1], n = 1 Output: []
 * 
 * Example 3:
 * 
 * Input: head = [1,2], n = 1 Output: [1]
 */
public class RemoveNthNodeFromEndOfList {

	public static void main(String[] args) {
		ListNode res = removeNthFromEnd(new ListNode(new int[] { 1, 2, 3, 4, 5 }), 2);
		res.print();
		res = removeNthFromEnd(new ListNode(new int[] { 1, 2, 3, 4, 5 }), 5);
		res.print();
		res = removeNthFromEnd(new ListNode(new int[] { 1, 2 }), 1);
		res.print();

		System.out.println("---");

		res = removeNthFromEndPractice(new ListNode(new int[] { 1, 2, 3, 4, 5 }), 2);
		res.print();
		res = removeNthFromEndPractice(new ListNode(new int[] { 1, 2, 3, 4, 5 }), 5);
		res.print();
		res = removeNthFromEndPractice(new ListNode(new int[] { 1, 2 }), 1);
		res.print();
	}

	private static ListNode removeNthFromEndPractice(ListNode head, int n) {
		return new ListNode();
	}

	private static ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null)
			return new ListNode();
		ListNode slow = head;
		ListNode fast = head;
		for (int i = 1; i <= n; i++)
			fast = fast.next;
		if (fast == null)
			return head.next;
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return head;
	}

}
