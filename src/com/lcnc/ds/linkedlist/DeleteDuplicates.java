package com.lcnc.ds.linkedlist;

/**
 * Given the head of a sorted linked list, delete all nodes that have duplicate
 * numbers, leaving only distinct numbers from the original list. Return the
 * linked list sorted as well.
 * 
 * Example 1:
 * 
 * Input: head = [1,2,3,3,4,4,5] Output: [1,2,5]
 * 
 * Example 2:
 * 
 * Input: head = [1,1,1,2,3] Output: [2,3]
 * 
 */
public class DeleteDuplicates {

	public static void main(String[] args) {
		ListNode res = deleteDuplicates(new ListNode(new int[] { 1, 2, 3, 3, 4, 4, 5 }));
		res.print();
		res = deleteDuplicates(new ListNode(new int[] { 1, 1, 1, 2, 3 }));
		res.print();
		res = deleteDuplicates(new ListNode(new int[] { 1, 2, 2 }));
		res.print();
		res = deleteDuplicates(new ListNode(new int[] { 1, 2, 3, 4, 5 }));
		res.print();

		System.out.println("---");

		res = deleteDuplicatesPractice(new ListNode(new int[] { 1, 2, 3, 3, 4, 4, 5 }));
		res.print();
		res = deleteDuplicatesPractice(new ListNode(new int[] { 1, 1, 1, 2, 3 }));
		res.print();
		res = deleteDuplicatesPractice(new ListNode(new int[] { 1, 2, 2 }));
		res.print();
		res = deleteDuplicatesPractice(new ListNode(new int[] { 1, 2, 3, 4, 5 }));
		res.print();
	}

	private static ListNode deleteDuplicatesPractice(ListNode head) {
		return new ListNode();
	}

	private static ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return new ListNode();
		if (head.next == null)
			return head;
		ListNode dummy = new ListNode();
		ListNode tail = dummy;
		while (head != null) {
			int count = 1;
			while (head.next != null && head.val == head.next.val) {
				count++;
				head = head.next;
			}
			ListNode next = head.next;
			if (count == 1) {
				head.next = null;
				tail.next = head;
				tail = tail.next;
			}
			head = next;
		}
		return dummy.next;
	}

}
