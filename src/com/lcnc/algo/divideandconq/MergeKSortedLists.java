package com.lcnc.algo.divideandconq;

import java.util.ArrayDeque;
import java.util.Deque;

import com.lcnc.ds.linkedlist.ListNode;
import com.lcnc.ds.linkedlist.MergeTwoSortedLists;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in
 * ascending order.
 * 
 * Merge all the linked-lists into one sorted linked-list and return it.
 * 
 * Example 1:
 * 
 * Input: lists = [[1,4,5],[1,3,4],[2,6]] Output: [1,1,2,3,4,4,5,6] Explanation:
 * The linked-lists are: [ 1->4->5, 1->3->4, 2->6 ] merging them into one sorted
 * list: 1->1->2->3->4->4->5->6
 * 
 * Example 2:
 * 
 * Input: lists = [] Output: []
 * 
 * Example 3:
 * 
 * Input: lists = [[]] Output: []
 */
public class MergeKSortedLists {

	public static void main(String[] args) {
		ListNode res = mergeKLists(new ListNode(new int[] { 1, 4, 5 }), new ListNode(new int[] { 1, 3, 4 }),
				new ListNode(new int[] { 2, 6 }));
		res.print();
		res = mergeKLists(null, new ListNode(new int[] { -1, 5, 11 }), null, new ListNode(new int[] { 6, 10 }));
		res.print();
		res = mergeKLists(new ListNode(new int[] {}));
		res.print();
		res = mergeKLists();
		res.print();

		System.out.println("---");

		res = mergeKListsDivideAndConquer(new ListNode(new int[] { 1, 4, 5 }), new ListNode(new int[] { 1, 3, 4 }),
				new ListNode(new int[] { 2, 6 }));
		res.print();
		res = mergeKListsDivideAndConquer(null, new ListNode(new int[] { -1, 5, 11 }), null,
				new ListNode(new int[] { 6, 10 }));
		res.print();
		res = mergeKListsDivideAndConquer(new ListNode(new int[] {}));
		res.print();
		res = mergeKListsDivideAndConquer();
		res.print();

		System.out.println("---");

		res = mergeKListsPractice(new ListNode(new int[] { 1, 4, 5 }), new ListNode(new int[] { 1, 3, 4 }),
				new ListNode(new int[] { 2, 6 }));
		res.print();
		res = mergeKListsPractice(null, new ListNode(new int[] { -1, 5, 11 }), null, new ListNode(new int[] { 6, 10 }));
		res.print();
		res = mergeKListsPractice(new ListNode(new int[] {}));
		res.print();
		res = mergeKListsPractice();
		res.print();
	}

	private static ListNode mergeKListsPractice(ListNode... lists) {
		return new ListNode();
	}

	private static ListNode mergeKLists(ListNode... lists) {
		if (lists == null || lists.length == 0)
			return new ListNode();
		Deque<ListNode> queue = new ArrayDeque<>();
		for (ListNode list : lists) {
			if (list != null)
				queue.offer(list);
		}
		while (queue.size() > 1)
			queue.offer(MergeTwoSortedLists.mergeTwoLists(queue.poll(), queue.poll()));
		return queue.poll();
	}

	public static ListNode mergeKListsDivideAndConquer(ListNode... lists) {
		if (lists == null || lists.length == 0)
			return new ListNode();
		int start = 0;
		int end = lists.length - 1;
		while (end > 0) {
			ListNode merged = MergeTwoSortedLists.mergeTwoLists(lists[start], lists[end]);
			lists[start] = merged;
			start++;
			end--;
			if (start >= end)
				start = 0;
		}
		return lists[0];
	}

}
