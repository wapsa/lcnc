package com.lcnc.ds.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * Design a data structure that follows the constraints of a Least Recently Used
 * (LRU) cache.
 * 
 * Implement the LRUCache class:
 * 
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise
 * return -1. void put(int key, int value) Update the value of the key if the
 * key exists. Otherwise, add the key-value pair to the cache. If the number of
 * keys exceeds the capacity from this operation, evict the least recently used
 * key. The functions get and put must each run in O(1) average time complexity.
 * 
 * Example 1:
 * 
 * Input ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get",
 * "get"] [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]] Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * 
 * Explanation
 * 
 * LRUCache lRUCache = new LRUCache(2);
 * 
 * lRUCache.put(1, 1); // cache is {1=1}
 * 
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * 
 * lRUCache.get(1); // return 1
 * 
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * 
 * lRUCache.get(2); // returns -1 (not found)
 * 
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * 
 * lRUCache.get(1); // return -1 (not found)
 * 
 * lRUCache.get(3); // return 3
 * 
 * lRUCache.get(4); // return 4
 */
public class LRUCache {

	public static void main(String[] args) {
		LRUCache lRUCache = new LRUCache(2);
		lRUCache.put(1, 1); // cache is {1=1}
		System.out.println(lRUCache);
		lRUCache.put(2, 2); // cache is {1=1, 2=2}
		System.out.println(lRUCache);
		System.out.println(lRUCache.get(1)); // return 1
		lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
		System.out.println(lRUCache);
		System.out.println(lRUCache.get(2)); // returns -1 (not found)
		lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
		System.out.println(lRUCache);
		System.out.println(lRUCache.get(1)); // return -1 (not found)
		System.out.println(lRUCache.get(3)); // return 3
		System.out.println(lRUCache.get(4)); // return 4

		System.out.println("---");

		lRUCache = new LRUCache(1);
		lRUCache.put(2, 1);
		System.out.println(lRUCache);
		System.out.println(lRUCache.get(2));
	}

	private static class LRUNode {
		int key;
		int value;
		LRUNode prev;
		LRUNode next;

		public LRUNode(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	private Map<Integer, LRUNode> map;
	private int capacity;
	private int count;
	private LRUNode head;
	private LRUNode tail;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.map = new HashMap<>();
		this.head = new LRUNode(0, 0);
		this.tail = new LRUNode(0, 0);
		this.head.next = tail;
		this.tail.prev = head;
	}

	public void deleteNode(LRUNode node) {
		LRUNode prev = node.prev;
		LRUNode next = node.next;
		prev.next = next;
		next.prev = prev;
	}

	public void addFirst(LRUNode node) {
		LRUNode prev = head;
		LRUNode next = head.next;
		prev.next = node;
		node.prev = prev;
		node.next = next;
		next.prev = node;
	}

	public int get(int key) {
		LRUNode node = map.get(key);
		if (node == null)
			return -1;
		deleteNode(node);
		addFirst(node);
		return node.value;
	}

	public void put(int key, int value) {
		LRUNode node = map.get(key);
		if (node == null) {
			if (count == capacity)
				removeLRU();
			node = new LRUNode(key, value);
			map.put(key, node);
			addFirst(node);
			count++;
		} else {
			node.value = value;
			deleteNode(node);
			addFirst(node);
		}
	}

	private void removeLRU() {
		LRUNode lru = tail.prev;
		map.remove(lru.key);
		deleteNode(lru);
		count--;
	}

}