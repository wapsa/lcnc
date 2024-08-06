package com.lcnc.ds.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseStack {

	public static void main(String[] args) {
		Stack stack = new ArrayBackedStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		System.out.println("original: " + stack);
		reverse(stack);
		System.out.println("reverse 1: " + stack);

		reverseUsingQueue(stack);
		System.out.println("reverse 2: " + stack);

		reverseUsingQueuePractice(stack);
		System.out.println("reverse 3: " + stack);

	}

	private static void reverseUsingQueuePractice(Stack stack) {

	}

	private static void reverseUsingQueue(Stack stack) {
		Deque<Integer> queue = new ArrayDeque<>();
		while (!stack.isEmpty())
			queue.offer(stack.pop());
		while (!queue.isEmpty())
			stack.push(queue.poll());
	}

	private static void reverse(Stack stack) {
		if (stack.isEmpty())
			return;
		int current = stack.pop();
		reverse(stack);
		insertAtBottom(stack, current);
	}

	private static void insertAtBottom(Stack stack, int element) {
		if (stack.isEmpty()) {
			stack.push(element);
			return;
		}
		int current = stack.pop();
		insertAtBottom(stack, element);
		stack.push(current);
	}

}
