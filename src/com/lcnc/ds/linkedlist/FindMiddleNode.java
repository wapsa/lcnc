package com.lcnc.ds.linkedlist;

/**
 * Given the head of a singly linked list, return the middle node of the linked
 * list.
 * 
 * If there are two middle nodes, return the second middle node.
 * 
 * Example 1:
 * 
 * Input: head = [1,2,3,4,5] Output: [3,4,5] Explanation: The middle node of the
 * list is node 3.
 * 
 * Example 2:
 * 
 * Input: head = [1,2,3,4,5,6] Output: [4,5,6] Explanation: Since the list has
 * two middle nodes with values 3 and 4, we return the second one, which is 4.
 * 
 */
public class FindMiddleNode {

	public static void main(String[] args) {
		ListNode res = findFirstMiddleNode(new ListNode(new int[] { 1, 2, 3, 4 }));
		res.print();
		res = findFirstMiddleNode(new ListNode(new int[] { 1, 2, 3, 4, 5 }));
		res.print();
		res = findFirstMiddleNode(new ListNode(1));
		res.print();
		res = findFirstMiddleNode(new ListNode(new int[] { 1, 2 }));
		res.print();

		System.out.println("---");

		res = findSecondMiddleNode(new ListNode(new int[] { 1, 2, 3, 4 }));
		res.print();
		res = findSecondMiddleNode(new ListNode(new int[] { 1, 2, 3, 4, 5 }));
		res.print();
		res = findSecondMiddleNode(new ListNode(1));
		res.print();
		res = findSecondMiddleNode(new ListNode(new int[] { 1, 2 }));
		res.print();

		System.out.println("---");

		res = findMiddleNodePractice(new ListNode(new int[] { 1, 2, 3, 4 }));
		res.print();
		res = findMiddleNodePractice(new ListNode(new int[] { 1, 2, 3, 4, 5 }));
		res.print();
		res = findMiddleNodePractice(new ListNode(1));
		res.print();
		res = findMiddleNodePractice(new ListNode(new int[] { 1, 2 }));
		res.print();
	}

	private static ListNode findMiddleNodePractice(ListNode head) {
		return new ListNode();
	}

	public static ListNode findFirstMiddleNode(ListNode head) {
		if (head == null)
			return new ListNode();
		if (head.next == null)
			return head;

		ListNode slow = head;
		ListNode fast = slow.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public static ListNode findSecondMiddleNode(ListNode head) {
		if (head == null)
			return new ListNode();
		if (head.next == null)
			return head;

		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

}
