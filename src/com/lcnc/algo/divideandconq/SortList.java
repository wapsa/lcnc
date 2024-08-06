package com.lcnc.algo.divideandconq;

import java.util.ArrayList;
import java.util.List;

import com.lcnc.ds.linkedlist.ListNode;

/**
 * Given the head of a linked list, return the list after sorting it in
 * ascending order.
 * 
 * Example 1:
 * 
 * Input: head = [4,2,1,3] Output: [1,2,3,4]
 * 
 * Example 2:
 * 
 * Input: head = [-1,5,3,4,0] Output: [-1,0,3,4,5]
 * 
 * Example 3:
 * 
 * Input: head = [] Output: []
 */
public class SortList {

	public static void main(String[] args) {
		ListNode res = sortList(new ListNode(new int[] { 4, 2, 1, 3 }));
		res.print();
		res = sortList(new ListNode(new int[] { -1, 5, 3, 4, 0 }));
		res.print();
		res = sortList(null);
		res.print();

		System.out.println("---");

		res = sortListPractice(new ListNode(new int[] { 4, 2, 1, 3 }));
		res.print();
		res = sortListPractice(new ListNode(new int[] { -1, 5, 3, 4, 0 }));
		res.print();
		res = sortListPractice(null);
		res.print();
	}

	private static ListNode sortListPractice(ListNode head) {
		return new ListNode();
	}

	private static ListNode sortList(ListNode head) {
		if (head == null)
			return new ListNode();
		if (head.next == null)
			return head;
		List<ListNode> lists = new ArrayList<>();
		while (head != null) {
			ListNode next = head.next;
			head.next = null;
			lists.add(head);
			head = next;
		}
		ListNode sortedList = MergeKSortedLists.mergeKListsDivideAndConquer(lists.toArray(ListNode[]::new));
		return sortedList;
	}

}
