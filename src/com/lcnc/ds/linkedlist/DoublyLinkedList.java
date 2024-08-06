package com.lcnc.ds.linkedlist;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class DoublyLinkedList implements List {

	public static void main(String[] args) {
		List ll = new DoublyLinkedList();
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

	private DLLNode first;

	private DLLNode last;

	private int size;

	public static class DLLNode {
		public DLLNode next;
		public DLLNode prev;
		public Integer data;

		public DLLNode(Integer data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return String.valueOf(data);
		}

	}

	@Override
	public void addFirst(Integer data) {
		DLLNode node = new DLLNode(data);
		if (isEmpty()) {
			first = node;
			last = node;
		} else {
			node.next = first;
			first.prev = node;
			first = node;
		}
		size++;
	}

	@Override
	public void addLast(Integer data) {
		DLLNode node = new DLLNode(data);
		if (isEmpty()) {
			first = node;
			last = node;
		} else {
			node.prev = last;
			last.next = node;
			last = node;
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
			first.prev = null;
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
			last = last.prev;
			last.next = null;
		}
		size--;
	}

	@Override
	public void remove(Integer data) {
		DLLNode removalNode = getNode(data);
		DLLNode prev = removalNode.prev;
		DLLNode next = removalNode.next;
		if (prev == null)
			removeFirst();
		else if (next == null)
			removeLast();
		else {
			prev.next = next;
			next.prev = prev;
			size--;
		}
	}

	private DLLNode getNode(int data) {
		if (isEmpty())
			throw new NoSuchElementException();
		DLLNode node = first;
		while (node != null) {
			if (node.data.equals(data))
				return node;
			node = node.next;
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
			throw new IndexOutOfBoundsException();
		if (index < size >> 1) {
			DLLNode node = first;
			for (int i = 0; i < index; i++)
				node = node.next;
			return node.data;
		} else {
			DLLNode node = last;
			for (int i = size - 1; i > index; i--)
				node = node.prev;
			return node.data;
		}
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
		DLLNode curr = first;
		int i = 0;
		while (curr != null) {
			elements[i++] = curr.data;
			curr = curr.next;
		}
		return Arrays.toString(elements);
	}

}
