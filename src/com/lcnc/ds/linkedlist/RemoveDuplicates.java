package com.lcnc.ds.linkedlist;

/**
 * Given the head of a sorted linked list, delete duplicate nodes. Return the
 * linked list sorted as well.
 * 
 * Example 1:
 * 
 * Input: head = [1,2,3,3,4,4,5] Output: [1,2,3,4,5]
 * 
 * Example 2:
 * 
 * Input: head = [1,1,1,2,3] Output: [1,2,3]
 * 
 */
public class RemoveDuplicates {

	public static void main(String[] args) {
		ListNode res = removeDuplicates(new ListNode(new int[] { 1, 2, 3, 3, 4, 4, 5 }));
		res.print();
		res = removeDuplicates(new ListNode(new int[] { 1, 1, 1, 2, 3 }));
		res.print();
		res = removeDuplicates(new ListNode(new int[] { 1, 2, 3, 4, 5 }));
		res.print();

		System.out.println("---");

		res = removeDuplicatesPractice(new ListNode(new int[] { 1, 2, 3, 3, 4, 4, 5 }));
		res.print();
		res = removeDuplicatesPractice(new ListNode(new int[] { 1, 1, 1, 2, 3 }));
		res.print();
		res = removeDuplicatesPractice(new ListNode(new int[] { 1, 2, 3, 4, 5 }));
		res.print();
	}

	private static ListNode removeDuplicatesPractice(ListNode head) {
		return new ListNode();
	}

	private static ListNode removeDuplicates(ListNode head) {
		if (head == null)
			return new ListNode();
		if (head.next == null)
			return head;
		ListNode dummy = new ListNode();
		ListNode tail = dummy;
		while (head != null) {
			if (head.val != tail.val) {
				tail.next = head;
				tail = tail.next;
			}
			head = head.next;
		}
		return dummy.next;
	}

}
