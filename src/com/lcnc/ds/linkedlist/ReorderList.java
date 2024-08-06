package com.lcnc.ds.linkedlist;

/**
 * You are given the head of a singly linked-list. The list can be represented
 * as:
 * 
 * L0 → L1 → … → Ln - 1 → Ln Reorder the list to be on the following form:
 * 
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → … You may not modify the values in the
 * list's nodes. Only nodes themselves may be changed.
 * 
 * Example 1:
 * 
 * Input: head = [1,2,3,4] Output: [1,4,2,3]
 * 
 * Example 2:
 * 
 * Input: head = [1,2,3,4,5] Output: [1,5,2,4,3]
 * 
 * 
 */
public class ReorderList {

	public static void main(String[] args) {
		ListNode res = reorderList(new ListNode(new int[] { 1, 2, 3, 4 }));
		res.print();
		res = reorderList(new ListNode(new int[] { 1, 2, 3, 4, 5 }));
		res.print();
		res = reorderList(new ListNode(1));
		res.print();
		res = reorderList(new ListNode(new int[] { 1, 2 }));
		res.print();

		System.out.println("---");

		res = reorderListPractice(new ListNode(new int[] { 1, 2, 3, 4 }));
		res.print();
		res = reorderListPractice(new ListNode(new int[] { 1, 2, 3, 4, 5 }));
		res.print();
		res = reorderListPractice(new ListNode(1));
		res.print();
		res = reorderListPractice(new ListNode(new int[] { 1, 2 }));
		res.print();
	}

	private static ListNode reorderListPractice(ListNode head) {
		return new ListNode();
	}

	private static ListNode reorderList(ListNode head) {
		if (head == null)
			return new ListNode();
		if (head.next == null)
			return head;

		ListNode midNode = FindMiddleNode.findFirstMiddleNode(head);
		ListNode first = head;
		ListNode second = midNode.next;
		midNode.next = null;

		second = ReverseLinkedList1.reverseListUsingLoop(second);

		ListNode dummyFirst = new ListNode();
		ListNode curr = dummyFirst;

		while (first != null && second != null) {
			ListNode nextFirst = first.next;
			first.next = null;
			curr.next = first;
			curr = first;
			first = nextFirst;

			ListNode nextSecond = second.next;
			second.next = null;
			curr.next = second;
			curr = second;
			second = nextSecond;
		}
		if (first != null)
			curr.next = first;
		if (second != null)
			curr.next = second;
		return dummyFirst.next;
	}

}
