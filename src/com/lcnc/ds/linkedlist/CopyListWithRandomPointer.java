package com.lcnc.ds.linkedlist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A linked list of length n is given such that each node contains an additional
 * random pointer, which could point to any node in the list, or null.
 * 
 * Construct a deep copy of the list. The deep copy should consist of exactly n
 * brand new nodes, where each new node has its value set to the value of its
 * corresponding original node. Both the next and random pointer of the new
 * nodes should point to new nodes in the copied list such that the pointers in
 * the original list and copied list represent the same list state. None of the
 * pointers in the new list should point to nodes in the original list.
 * 
 * For example, if there are two nodes X and Y in the original list, where
 * X.random --> Y, then for the corresponding two nodes x and y in the copied
 * list, x.random --> y.
 * 
 * Return the head of the copied linked list.
 * 
 * The linked list is represented in the input/output as a list of n nodes. Each
 * node is represented as a pair of [val, random_index] where:
 * 
 * val: an integer representing Node.val random_index: the index of the node
 * (range from 0 to n-1) that the random pointer points to, or null if it does
 * not point to any node. Your code will only be given the head of the original
 * linked list.
 * 
 * Example 1:
 * 
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]] Output:
 * [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 
 * Example 2:
 * 
 * Input: head = [[1,1],[2,1]] Output: [[1,1],[2,1]]
 * 
 * Example 3:
 * 
 * Input: head = [[3,null],[3,0],[3,null]] Output: [[3,null],[3,0],[3,null]]
 */
public class CopyListWithRandomPointer {

	public static void main(String[] args) {
		NodeWithRandom i1 = new NodeWithRandom(7, null);
		NodeWithRandom i2 = new NodeWithRandom(13, i1);
		NodeWithRandom i4 = new NodeWithRandom(10, i2);
		NodeWithRandom i3 = new NodeWithRandom(11, i4);
		NodeWithRandom i5 = new NodeWithRandom(1, i1);
		i1.next = i2;
		i2.next = i3;
		i3.next = i4;
		i4.next = i5;
		System.out.println("Input: " + i1);
		System.out.println("Cloned: " + copyRandomList(i1));

		NodeWithRandom i7 = new NodeWithRandom(2, null);
		NodeWithRandom i6 = new NodeWithRandom(1, i7);
		i7.random = i7;
		i6.next = i7;
		System.out.println("Input: " + i6);
		System.out.println("Cloned: " + copyRandomList(i6));

		System.out.println("Cloned: " + copyRandomList(null));

		System.out.println("---");

		i1 = new NodeWithRandom(7, null);
		i2 = new NodeWithRandom(13, i1);
		i4 = new NodeWithRandom(10, i2);
		i3 = new NodeWithRandom(11, i4);
		i5 = new NodeWithRandom(1, i1);
		i1.next = i2;
		i2.next = i3;
		i3.next = i4;
		i4.next = i5;
		System.out.println("Input: " + i1);
		System.out.println("Cloned: " + copyRandomListPractice(i1));

		i7 = new NodeWithRandom(2, null);
		i6 = new NodeWithRandom(1, i7);
		i7.random = i7;
		i6.next = i7;
		System.out.println("Input: " + i6);
		System.out.println("Cloned: " + copyRandomListPractice(i6));

		System.out.println("Cloned: " + copyRandomListPractice(null));

	}

	private static NodeWithRandom copyRandomListPractice(NodeWithRandom head) {
		return new NodeWithRandom();
	}

	/**
	 * this can be done in single scan also, if random node is previously created
	 * set it then itself, if not then create new and store it for future use.
	 * 
	 * <pre>
	 * NodeWithRandom cloned = store.get(curr);
	 * if (cloned == null) {
	 * 	cloned = new NodeWithRandom(curr.val);
	 * 	store.put(curr, cloned);
	 * }
	 * if (curr.random != null) {
	 * 	NodeWithRandom random = store.get(curr.random);
	 * 	if (random == null) {
	 * 		random = new NodeWithRandom(curr.random.val);
	 * 		store.put(curr.random, random);
	 * 	}
	 * 	cloned.random = random;
	 * }
	 * </pre>
	 */
	private static NodeWithRandom copyRandomList(NodeWithRandom head) {
		if (head == null)
			return new NodeWithRandom();
		Map<NodeWithRandom, NodeWithRandom> mapping = new HashMap<>();
		NodeWithRandom dummyFirst = new NodeWithRandom();
		NodeWithRandom runningTail = dummyFirst;

		NodeWithRandom curr = head;
		while (curr != null) {
			NodeWithRandom currClone = new NodeWithRandom(curr.val);
			mapping.put(curr, currClone);
			runningTail.next = currClone;
			runningTail = runningTail.next;
			curr = curr.next;
		}
		mapping.forEach((old, cloned) -> {
			cloned.random = mapping.get(old.random);
		});
		return dummyFirst.next;
	}

	private static class NodeWithRandom {
		int val;
		NodeWithRandom next;
		NodeWithRandom random;

		public NodeWithRandom() {
			val = -1;
		}

		public NodeWithRandom(int val) {
			this.val = val;
		}

		public NodeWithRandom(int val, NodeWithRandom random) {
			this.val = val;
			this.random = random;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			Set<NodeWithRandom> dups = new HashSet<>();
			NodeWithRandom node = this;
			while (node.next != null) {
				if (dups.contains(node) || node.val < 0)
					break;
				builder.append(node.val + ":" + (node.random != null ? node.random.val : null) + ", ");
				dups.add(node);
				node = node.next;
			}
			if (node.val >= 0)
				builder.append(node.val + ":" + (node.random != null ? node.random.val : null));
			return builder.toString();
		}

	}

}
