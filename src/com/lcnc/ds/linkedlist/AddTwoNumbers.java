package com.lcnc.ds.linkedlist;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order, and each of their nodes
 * contains a single digit. Add the two numbers and return the sum as a linked
 * list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example 1:
 * 
 * Input: l1 = [2,4,3], l2 = [5,6,4] Output: [7,0,8] Explanation: 342 + 465 =
 * 807.
 * 
 * Example 2:
 * 
 * Input: l1 = [0], l2 = [0] Output: [0]
 * 
 * Example 3:
 * 
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9] Output: [8,9,9,9,0,0,0,1
 * 
 */
public class AddTwoNumbers {

	public static void main(String[] args) {
		ListNode res = addTwoNumbers(new ListNode(new int[] { 2, 4, 3 }), new ListNode(new int[] { 5, 6, 4 }));
		res.print();
		res = addTwoNumbers(new ListNode(new int[] { 0 }), new ListNode(new int[] { 0 }));
		res.print();
		res = addTwoNumbers(new ListNode(new int[] { 9, 9, 9, 9, 9, 9, 9 }), new ListNode(new int[] { 9, 9, 9, 9 }));
		res.print();

		System.out.println("---");

		res = addTwoNumbersPractice(new ListNode(new int[] { 2, 4, 3 }), new ListNode(new int[] { 5, 6, 4 }));
		res.print();
		res = addTwoNumbersPractice(new ListNode(new int[] { 0 }), new ListNode(new int[] { 0 }));
		res.print();
		res = addTwoNumbersPractice(new ListNode(new int[] { 9, 9, 9, 9, 9, 9, 9 }),
				new ListNode(new int[] { 9, 9, 9, 9 }));
		res.print();
	}

	private static ListNode addTwoNumbersPractice(ListNode l1, ListNode l2) {
		return new ListNode();
	}

	private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null)
			return new ListNode();
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode dummyFirst = new ListNode();
		ListNode last = dummyFirst;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int sum = 0;
			if (l1 == null) {
				sum = carry + l2.val;
				l2 = l2.next;
			} else if (l2 == null) {
				sum = carry + l1.val;
				l1 = l1.next;
			} else {
				sum = carry + l1.val + l2.val;
				l1 = l1.next;
				l2 = l2.next;
			}
			carry = sum / 10;
			last.next = new ListNode(sum % 10);
			last = last.next;
		}
		if (carry == 1)
			last.next = new ListNode(carry);
		return dummyFirst.next;
	}

}
