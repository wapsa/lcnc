package com.lcnc.ds.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayBackedStack implements Stack {

	public static void main(String[] args) {
		Stack stack = new ArrayBackedStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		System.out.println("size: " + stack.size());
		System.out.println("top: " + stack.top());
		System.out.println("pop: " + stack.pop());
		System.out.println("pop: " + stack.top());
		System.out.println("size: " + stack.size());
		System.out.println("pop: " + stack.pop());
		System.out.println("pop: " + stack.pop());
		System.out.println("pop: " + stack.pop());
		System.out.println("size: " + stack.size());
		stack.push(3);
		stack.push(4);
		System.out.println("size: " + stack.size());
		System.out.println("stack: " + stack);
	}

	private int[] elements;
	private int size;

	public ArrayBackedStack() {
		elements = new int[2];
		size = 0;
	}

	@Override
	public void push(int val) {
		if (size == elements.length)
			grow(size >> 1);
		elements[size++] = val;
	}

	@Override
	public int pop() {
		int top = top();
		size--;
		elements[size] = 0;
		return top;
	}

	@Override
	public int top() {
		if (isEmpty())
			throw new EmptyStackException();
		return elements[size - 1];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	private void grow(int growBy) {
		int[] newStack = new int[size + growBy];
		System.arraycopy(elements, 0, newStack, 0, size);
		elements = newStack;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Stack [elements=").append(Arrays.toString(elements)).append("]");
		return builder.toString();
	}

	@Override
	public int getMin() {
		throw new UnsupportedOperationException();
	}

}
