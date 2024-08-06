package com.lcnc.ds.linkedlist;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * 
 * Merge the two lists into one sorted list. The list should be made by splicing
 * together the nodes of the first two lists.
 * 
 * Return the head of the merged linked list.
 * 
 * Example 1:
 * 
 * Input: list1 = [1,2,4], list2 = [1,3,4] Output: [1,1,2,3,4,4]
 * 
 * Example 2:
 * 
 * Input: list1 = [], list2 = [] Output: []
 * 
 * Example 3:
 * 
 * Input: list1 = [], list2 = [0] Output: [0]
 */
public class MergeTwoSortedLists {

	public static void main(String[] args) {
		ListNode res = mergeTwoLists(new ListNode(new int[] { 1, 2, 4 }), new ListNode(new int[] { 1, 3, 4 }));
		res.print();
		res = mergeTwoLists(new ListNode(new int[] { 1, 2, 4, 5, 6, 7 }), new ListNode(new int[] { 1, 3, 4 }));
		res.print();
		res = mergeTwoLists(null, new ListNode(0));
		res.print();
		res = mergeTwoLists(new ListNode(), new ListNode(0));
		res.print();

		System.out.println("---");

		res = mergeTwoListsPractice(new ListNode(new int[] { 1, 2, 4 }), new ListNode(new int[] { 1, 3, 4 }));
		res.print();
		res = mergeTwoListsPractice(new ListNode(new int[] { 1, 2, 4, 5, 6, 7 }), new ListNode(new int[] { 1, 3, 4 }));
		res.print();
		res = mergeTwoListsPractice(null, new ListNode(0));
		res.print();
		res = mergeTwoListsPractice(new ListNode(), new ListNode(0));
		res.print();
	}

	private static ListNode mergeTwoListsPractice(ListNode l1, ListNode l2) {
		return new ListNode();
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null)
			return new ListNode();
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode dummyFirst = new ListNode();
		ListNode runningTail = dummyFirst;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				runningTail.next = l1;
				l1 = l1.next;
			} else {
				runningTail.next = l2;
				l2 = l2.next;
			}
			runningTail = runningTail.next;
		}
		if (l1 != null)
			runningTail.next = l1;
		if (l2 != null)
			runningTail.next = l2;
		return dummyFirst.next;
	}

}
