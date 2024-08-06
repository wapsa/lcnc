package com.lcnc.ds.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * min stack
 * 
 * x = stack_element
 * 
 * push: x = 2*cur_min - prev_min (if stack is empty, put x = cur_min)
 * 
 * pop: prev_min = 2*cur_min - x
 * 
 * max stack (not verified)
 * 
 * x = stack_element
 * 
 * push: x = 2*cur_max - prev_max
 * 
 * pop: prev_max = 2*cur_max - x
 */
public class MinStackO1Space implements Stack {

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
		System.out.println("stack: " + stack);
	}

	private final Deque<Long> elementStack;
	private long minElement = Integer.MAX_VALUE;

	public MinStackO1Space() {
		super();
		this.elementStack = new ArrayDeque<>();
	}

	@Override
	public void push(int val) {
		if (isEmpty()) {
			elementStack.push(Long.valueOf(val));
			minElement = val;
		} else {
			if (val > minElement)
				elementStack.push(Long.valueOf(val));
			else {
				long encodedVal = 2l * val - minElement;
				elementStack.push(encodedVal);
				minElement = val;
			}
		}
	}

	@Override
	public int pop() {
		long poppedElement = elementStack.pop();
		if (poppedElement <= minElement) {
			long prevMin = 2l * minElement - poppedElement;
			poppedElement = minElement;
			minElement = prevMin;
		}
		return Math.toIntExact(poppedElement);
	}

	@Override
	public int top() {
		long peekElement = elementStack.peek();
		if (peekElement <= minElement)
			peekElement = minElement;
		return Math.toIntExact(peekElement);
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
		return Math.toIntExact(minElement);
	}

}
