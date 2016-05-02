package com.jpm.stack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Cracking the coding Interview, 4 edition
 * 
 * 3.3 Imagine a (literal) stack of plates. If the stack gets too high, it might
 * topple. Therefore, in real life, we would likely start a new stack when the
 * previous stack exceeds some threshold. Implement a data structure SetOfStacks
 * that mimics this. SetOfStacks should be composed of several stacks, and
 * should create a new stack once the previous one exceeds capacity.
 * SetOfStacks.push() and SetOfStacks.pop() should behave identically to a
 * single stack (that is, pop() should return the same values as it would if
 * there were just a single stack).
 * 
 * FOLLOW UP Implement a function popAt(int index) which performs a pop
 * operation on a specific sub-stack.
 * 
 * @author JPMagalhaes
 *
 * @param <T>
 */
public class SetOfStacks <T> {
	private int capacity;
	private int index = -1;
	protected ArrayList<Stack<T>> stacks; 
	
	public SetOfStacks(int capacity) {
		this.capacity = capacity;
		stacks = new ArrayList();
	}
	
	public T push(T data) {
		if(data == null)
			return data;
		
		int stack = ++index/capacity;
		if(stack == stacks.size())
			stacks.add(new Stack());
		
		stacks.get(stack).push(data);
		return data;
	}
	
	public T pop(){
		if(index == -1)
			return null;
		
		int stack = index/capacity;
		Stack<T> s = stacks.get(stack);
		T result = (T)s.pop();
		
		if(index%capacity == 0)
			stacks.remove(stack);
		index--;
		return result;
	}
	
	public T popAt(int i) {
		if(this.index == -1 || i >= stacks.size())
			return null;
		
		Stack<T> stack = stacks.get(i);
		T data = stack.pop();
		
		// swap item between stacks
		for(int j = i; j < stacks.size()-1; j++){
			stacks.get(j).push(stacks.get(j+1).remove(0));
		}
		
		// check if last stack is empty
		if(stacks.get(stacks.size()-1).isEmpty())
			stacks.remove(stacks.size()-1);
		
		// update index
		index--;
		return data;
	}
	
	@Override
	public String toString() {
		if(index == -1)
			return "Empty set of stacks";
		
		StringBuilder builder = new StringBuilder();
		builder.append("Set of Stacks - size = ").append(stacks.size()).append("\n");
		for (int i = 0; i < stacks.size(); i++) {
			Stack<T> s = stacks.get(i);
			builder.append("Stack ").append(i).append(", size = ").append(s.size()).append("\n");
			for (int j = 0; j < s.size(); j++) {
				builder.append(s.get(j)).append(", ");
			}
			builder.append("\n");
		}
		
		return builder.toString();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SetOfStacks<Integer> stacks = new SetOfStacks<>(3);
		for (int i = 0; i < 10; i++) {
			stacks.push(i);				
		}
		System.out.println(stacks.toString());
		for (int i = 0; i < 10; i++) {
			int t = (int)(Math.random()*stacks.stacks.size());
			System.out.println("PopAt (" + t + "): " + stacks.popAt(t));
			System.out.println(stacks.toString());
		}
		System.out.println(stacks.toString());

	}

}
