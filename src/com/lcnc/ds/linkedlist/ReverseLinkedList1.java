package com.lcnc.ds.linkedlist;

/**
 * Given the head of a singly linked list, reverse the list, and return the
 * reversed list.
 * 
 * Example 1:
 * 
 * Input: head = [1,2,3,4,5] Output: [5,4,3,2,1]
 * 
 * Example 2:
 * 
 * Input: head = [1,2] Output: [2,1]
 * 
 * Example 3:
 * 
 * Input: head = [] Output: []
 */
public class ReverseLinkedList1 {

	public static void main(String[] args) {
		ListNode res = reverseListUsingLoop(new ListNode(new int[] { 1, 2, 3, 4, 5 }));
		res.print();
		res = reverseListUsingLoop(new ListNode(new int[] { 1, 2 }));
		res.print();
		res = reverseListUsingLoop(null);
		res.print();

		System.out.println("---");

		res = reverseListUsingLoopPractice(new ListNode(new int[] { 1, 2, 3, 4, 5 }));
		res.print();
		res = reverseListUsingLoopPractice(new ListNode(new int[] { 1, 2 }));
		res.print();
		res = reverseListUsingLoopPractice(null);
		res.print();
	}

	private static ListNode reverseListUsingLoopPractice(ListNode head) {
		return new ListNode();
	}

	public static ListNode reverseListUsingLoop(ListNode head) {
		if (head == null)
			return new ListNode();
		if (head.next == null)
			return head;
		ListNode revHead = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = revHead;
			revHead = head;
			head = next;
		}
		return revHead;
	}

}
