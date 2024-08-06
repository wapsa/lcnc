package com.lcnc.ds.linkedlist;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class SinglyLinkedList implements List {

	public static void main(String[] args) {
		List ll = new SinglyLinkedList();
		ll.addFirst(1);
		ll.addFirst(2);
		ll.addLast(3);
		System.out.println(ll);
		ll.removeLast();
		System.out.println(ll);
		ll.addLast(3);
		System.out.println(ll);
		ll.removeFirst();
		System.out.println(ll);
		ll.addFirst(2);
		System.out.println(ll);
		System.out.println(ll.get(1));
	}

	private SLLNode first;

	private SLLNode last;

	private int size;

	public static class SLLNode {
		public SLLNode next;
		public Integer data;

		public SLLNode(Integer data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return String.valueOf(data);
		}

	}

	@Override
	public void addFirst(Integer data) {
		SLLNode newNode = new SLLNode(data);
		if (isEmpty()) {
			first = newNode;
			last = newNode;
		} else {
			newNode.next = first;
			first = newNode;
		}
		size++;
	}

	@Override
	public void addLast(Integer data) {
		SLLNode newNode = new SLLNode(data);
		if (isEmpty()) {
			first = newNode;
			last = newNode;
		} else {
			last.next = newNode;
			last = newNode;
		}
		size++;
	}

	@Override
	public void removeFirst() {
		if (isEmpty())
			throw new NoSuchElementException();
		if (size() == 1) {
			first = null;
			last = null;
		} else {
			first = first.next;
		}
		size--;
	}

	@Override
	public void removeLast() {
		if (isEmpty())
			throw new NoSuchElementException();
		if (size() == 1) {
			first = null;
			last = null;
		} else {
			SLLNode sLLNode = first;
			while (sLLNode.next.next != null)
				sLLNode = sLLNode.next;
			sLLNode.next = null;
			last = sLLNode;
		}
		size--;
	}

	@Override
	public void remove(Integer data) {
		if (isEmpty())
			throw new NoSuchElementException();
		if (first.data.equals(data))
			removeFirst();
		SLLNode prev = getPrevNode(data);
		SLLNode removalNode = prev.next;
		SLLNode next = removalNode.next;
		prev.next = next;
		if (next == null)
			last = prev;
		size--;
	}

	private SLLNode getPrevNode(int data) {
		SLLNode sLLNode = first;
		while (sLLNode.next != null) {
			if (sLLNode.next.data.equals(data))
				return sLLNode;
			sLLNode = sLLNode.next;
		}
		throw new NoSuchElementException();
	}

	@Override
	public Integer getFirst() {
		if (isEmpty())
			throw new NoSuchElementException();
		return first.data;
	}

	@Override
	public Integer getLast() {
		if (isEmpty())
			throw new NoSuchElementException();
		return last.data;
	}

	@Override
	public Integer get(int index) {
		if (isEmpty() || index < 0 || index >= size)
			throw new NoSuchElementException();
		SLLNode sLLNode = first;
		for (int i = 0; i < index; i++)
			sLLNode = sLLNode.next;
		return sLLNode.data;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public String toString() {
		if (isEmpty())
			return Arrays.toString(new int[0]);
		int[] elements = new int[size];
		SLLNode curr = first;
		int i = 0;
		while (curr != null) {
			elements[i++] = curr.data;
			curr = curr.next;
		}
		return Arrays.toString(elements);
	}

}
