package com.lcnc.ds.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * Implement the MinStack class:
 * 
 * - MinStack() initializes the stack object.
 * 
 * - void push(int val) pushes the element val onto the stack.
 * 
 * - void pop() removes the element on the top of the stack.
 * 
 * - int top() gets the top element of the stack.
 * 
 * - int getMin() retrieves the minimum element in the stack.
 * 
 * You must implement a solution with O(1) time complexity for each function.
 */
public class MinStackONSpace implements Stack {

	public static void main(String[] args) {
		Stack stack = new MinStackONSpace();
		stack.push(3);
		System.out.println("min: " + stack.getMin());
		stack.push(2);
		System.out.println("min: " + stack.getMin());
		stack.push(4);
		System.out.println("min: " + stack.getMin());
		System.out.println("size: " + stack.size());
		System.out.println("top: " + stack.top());
		System.out.println("pop: " + stack.pop());
		System.out.println("top: " + stack.top());
		System.out.println("size: " + stack.size());
		System.out.println("pop: " + stack.pop());
		System.out.println("pop: " + stack.pop());
		System.out.println("size: " + stack.size());
		stack.push(1);
		System.out.println("min: " + stack.getMin());
		stack.push(2);
		System.out.println("min: " + stack.getMin());
		System.out.println("size: " + stack.size());
		stack.pop();
		System.out.println("stack: " + stack);
	}

	private final Deque<Integer> elementStack;
	private final Deque<Integer> minStack;

	public MinStackONSpace() {
		this.elementStack = new ArrayDeque<>();
		this.minStack = new ArrayDeque<>();
	}

	@Override
	public void push(int val) {
		elementStack.push(val);
		if (minStack.isEmpty() || val <= minStack.peek()) {
			minStack.push(val);
		}
	}

	@Override
	public int pop() {
		int poppedElement = elementStack.pop();
		if (poppedElement == minStack.peek())
			minStack.pop();
		return poppedElement;
	}

	@Override
	public int top() {
		return elementStack.peek();
	}

	@Override
	public boolean isEmpty() {
		return elementStack.isEmpty();
	}

	@Override
	public int size() {
		return elementStack.size();
	}

	@Override
	public int getMin() {
		return minStack.peek();
	}

	@Override
	public String toString() {
		return elementStack.toString();
	}

}
