package com.lcnc.ds.linkedlist;

/**
 * Given the head of a singly linked list and two integers left and right where
 * left <= right, reverse the nodes of the list from position left to position
 * right, and return the reversed list.
 * 
 * Example 1:
 * 
 * Input: head = [1,2,3,4,5], left = 2, right = 4 Output: [1,4,3,2,5]
 * 
 * Example 2:
 * 
 * Input: head = [5], left = 1, right = 1 Output: [5]
 * 
 * Constraints:
 * 
 * The number of nodes in the list is n.
 * 
 * 1 <= n <= 500 -500 <= Node.val <= 500
 * 
 * 1 <= left <= right <= n
 * 
 */
public class ReverseLinkedList2 {

	public static void main(String[] args) {
		ListNode res = reverseBetween(new ListNode(new int[] { 1, 2, 3, 4, 5 }), 2, 4);
		res.print();
		res = reverseBetween(new ListNode(new int[] { 3, 5 }), 1, 2);
		res.print();
		res = reverseBetween(new ListNode(new int[] { 5 }), 1, 1);
		res.print();

		System.out.println("---");

		res = reverseBetweenPractice(new ListNode(new int[] { 1, 2, 3, 4, 5 }), 2, 4);
		res.print();
		res = reverseBetweenPractice(new ListNode(new int[] { 3, 5 }), 1, 2);
		res.print();
		res = reverseBetweenPractice(new ListNode(new int[] { 5 }), 1, 1);
		res.print();
	}

	private static ListNode reverseBetweenPractice(ListNode head, int left, int right) {
		return new ListNode();
	}

	public static ListNode reverseBetween(ListNode head, int left, int right) {
		if (head == null)
			return new ListNode();
		if (head.next == null)
			return head;
		ListNode dummy = new ListNode();
		dummy.next = head;
		ListNode leftPrev = dummy;
		for (int i = 1; i < left; i++) {
			leftPrev = leftPrev.next;
		}
		ListNode revStart = leftPrev.next;
		leftPrev.next = null;

		ListNode curr = revStart;
		ListNode revHead = null;
		while (left <= right) {
			ListNode next = curr.next;
			curr.next = revHead;
			revHead = curr;
			curr = next;
			left++;
		}
		leftPrev.next = revHead;
		revStart.next = curr;
		return dummy.next;
	}

}
