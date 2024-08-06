package com.lcnc.ds.arraystring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Implement the RandomizedSet class:
 * 
 * RandomizedSet() Initializes the RandomizedSet object. bool insert(int val)
 * Inserts an item val into the set if not present. Returns true if the item was
 * not present, false otherwise. bool remove(int val) Removes an item val from
 * the set if present. Returns true if the item was present, false otherwise.
 * int getRandom() Returns a random element from the current set of elements
 * (it's guaranteed that at least one element exists when this method is
 * called). Each element must have the same probability of being returned. You
 * must implement the functions of the class such that each function works in
 * average O(1) time complexity.
 * 
 * Example 1:
 * 
 * Input ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove",
 * "insert", "getRandom"] [[], [1], [2], [2], [], [1], [2], []] Output [null,
 * true, false, true, 2, true, false, 2]
 * 
 */
public class InsertDeleteGetRandom {

	public static void main(String[] args) {

		RandomizedSet randomizedSet = new RandomizedSet();
		System.out.println(randomizedSet.insert(1));
		System.out.println(randomizedSet.remove(2));
		System.out.println(randomizedSet.insert(2));
		System.out.println(randomizedSet.getRandom());
		System.out.println(randomizedSet.remove(1));
		System.out.println(randomizedSet.insert(2));
		System.out.println(randomizedSet.getRandom());

		System.out.println("---");

		RandomizedSetPractice randomizedSetPractice = new RandomizedSetPractice();
		System.out.println(randomizedSetPractice.insert(1));
		System.out.println(randomizedSetPractice.remove(2));
		System.out.println(randomizedSetPractice.insert(2));
		System.out.println(randomizedSetPractice.getRandom());
		System.out.println(randomizedSetPractice.remove(1));
		System.out.println(randomizedSetPractice.insert(2));
		System.out.println(randomizedSetPractice.getRandom());
	}

	private static class RandomizedSet {

		private final Random random;
		private final List<Integer> elements;
		private final Map<Integer, Integer> elementIdxMap;
		private final ReadWriteLock lock;

		public RandomizedSet() {
			this.random = new Random();
			this.elements = new ArrayList<>();
			this.elementIdxMap = new HashMap<>();
			this.lock = new ReentrantReadWriteLock();
		}

		public boolean insert(int val) {
			lock.writeLock().lock();
			try {
				if (elementIdxMap.containsKey(val)) {
					return false;
				}
				elementIdxMap.put(val, elements.size());
				elements.add(val);
				return true;
			} finally {
				lock.writeLock().unlock();
			}
		}

		public boolean remove(int val) {
			lock.writeLock().lock();
			try {
				if (!elementIdxMap.containsKey(val)) {
					return false;
				}
				if (elements.size() == 1) {
					elements.remove(elements.size() - 1);
					elementIdxMap.remove(val);
				} else {
					int elementIdx = elementIdxMap.get(val);
					Integer lastElement = elements.get(elements.size() - 1);
					elements.set(elementIdx, lastElement);
					elementIdxMap.put(lastElement, elementIdx);
					elements.remove(elements.size() - 1);
					elementIdxMap.remove(val);
				}
				return true;
			} finally {
				lock.writeLock().unlock();
			}
		}

		public int getRandom() {
			lock.readLock().lock();
			try {
				if (!elements.isEmpty()) {
					int idx = random.nextInt(elements.size());
					return elements.get(idx);
				}
				return -1;
			} finally {
				lock.readLock().unlock();
			}
		}

	}

	private static class RandomizedSetPractice {

		public RandomizedSetPractice() {
		}

		public boolean insert(int val) {
			return false;
		}

		public boolean remove(int val) {
			return false;
		}

		public int getRandom() {
			return -1;
		}

	}

}
