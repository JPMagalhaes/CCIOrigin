package com.jpm.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Cracking the coding Interview, 4 edition
 * 
 * 3.2 How would you design a stack which, in addition to push and pop, also has
 * a function min which returns the minimum element? Push, pop and min should
 * all operate in O(1) time. pg 52
 * 
 * @author JPMagalhaes
 * 
 * @param <T>
 */
@SuppressWarnings("serial")
public class StackWithMin extends Stack<Integer> {
	Stack<Integer> minStack = new Stack<Integer>();

	public Integer push(Integer value) {
		if (minStack.isEmpty() || minStack.peek() > value)
			minStack.push(value);
		
		return super.push(value);
	}

	public Integer pop() {
		Integer r = super.pop();
		if(!minStack.isEmpty() && minStack.peek() == r)
			minStack.pop();
		
		return r;
	}
	
	public Integer min(){
		if(minStack.isEmpty())
			return Integer.MAX_VALUE;
		else
			return minStack.peek();
	}
	
	public static void print(StackWithMin stack) {
		System.out.println("Stack (min = " + stack.min() + ")");
		System.out.println(Arrays.toString(stack.toArray()));
	}
	
	public static void main(String[] args) {
		StackWithMin stack = new StackWithMin();
		System.out.println("Min empty = " + stack.min());
		
		for (int i = 0; i < 10; i++) {
			stack.push((int)(Math.random()*100));
		}
		print(stack);
		for (int i = 0; i < 10; i++) {
			System.out.print("min: " + (stack.minStack.isEmpty() ? "EMPTY" : stack.minStack.peek()));
			System.out.println(", pop: " + stack.pop());
		}
	}
}
