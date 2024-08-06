package com.lcnc.ds.linkedlist;

/**
 * Given the head of a linked list, reverse the nodes of the list k at a time,
 * and return the modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the linked
 * list. If the number of nodes is not a multiple of k then left-out nodes, in
 * the end, should remain as it is.
 * 
 * You may not alter the values in the list's nodes, only nodes themselves may
 * be changed.
 * 
 * Example 1:
 * 
 * Input: head = [1,2,3,4,5], k = 2 Output: [2,1,4,3,5]
 * 
 * Example 2:
 * 
 * Input: head = [1,2,3,4,5], k = 3 Output: [3,2,1,4,5]
 */
public class ReverseLinkedListInKGroups {

	public static void main(String[] args) {
		ListNode res = reverseKGroup(new ListNode(new int[] { 1, 2, 3, 4, 5 }), 2);
		res.print();
		res = reverseKGroup(new ListNode(new int[] { 1, 2, 3, 4, 5 }), 3);
		res.print();
		res = reverseKGroup(new ListNode(new int[] { 1, 2 }), 1);
		res.print();
		res = reverseKGroup(null, 1);
		res.print();

		System.out.println("---");

		res = reverseKGroupPractice(new ListNode(new int[] { 1, 2, 3, 4, 5 }), 2);
		res.print();
		res = reverseKGroupPractice(new ListNode(new int[] { 1, 2, 3, 4, 5 }), 3);
		res.print();
		res = reverseKGroupPractice(new ListNode(new int[] { 1, 2 }), 1);
		res.print();
		res = reverseKGroupPractice(null, 1);
		res.print();
	}

	private static ListNode reverseKGroupPractice(ListNode head, int k) {
		return new ListNode();
	}

	private static ListNode reverseKGroup(ListNode head, int k) {
		if (head == null)
			return new ListNode();
		if (head.next == null || k < 2)
			return head;
		ListNode dummy = new ListNode();
		ListNode tail = dummy;
		while (head != null) {
			ListNode start = head;
			ListNode end = head;
			int count = 1;
			while (count < k && end.next != null) {
				end = end.next;
				count++;
			}
			head = end.next;
			if (count == k) {
				end.next = null;
				ListNode reversedList = ReverseLinkedList1.reverseListUsingLoop(start);
				tail.next = reversedList;
				tail = start;
			} else {
				tail.next = start;
			}
		}
		return dummy.next;
	}

}
