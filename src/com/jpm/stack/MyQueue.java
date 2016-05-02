package com.jpm.stack;

import java.util.Stack;

/**
 * Cracking the coding Interview, 4 edition 
 * 
 * 3.5 Implement a MyQueue class which implements a queue using two stacks. pg
 * 52
 * 
 * @author JPMagalhaes
 * 
 */
public class MyQueue<T> {
	protected Stack<T> s1, s2;
	
	public MyQueue() {
		s1 = new Stack<>();
		s2 = new Stack<>();
	}
	
	public T push(T data) {
		if(data == null)
			return data;
		
		s1.push(data);
		return data;
	}
	
	public T pop(){
		if(s2.isEmpty()) {
			while(!s1.isEmpty())
				s2.push(s1.pop());
		}
		return s2.pop();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = s2.size()-1; i >= 0; i--) {
			builder.append(s2.get(i)).append(", ");
		}
		for (int i = 0; i < s1.size(); i++) {
			builder.append(s1.get(i)).append(", ");
		}
		builder.append("\n");
		return builder.toString();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyQueue<Integer> q = new MyQueue<>();
		for (int i = 0; i < 10; i++) {
			q.push(i);
		}
		System.out.println("MyQueue 0-10: " + q.toString());
		for (int i = 0; i < 5; i++) {
			System.out.println("pop: " + q.pop());
		}
		System.out.println("MyQueue 5-9: " + q.toString());
		for (int i = 10; i < 20; i++) {
			q.push(i);
		}
		System.out.println("MyQueue 5-20: " + q.toString());
		for (int i = 0; i < 9; i++) {
			System.out.println("pop: " + q.pop());
		}
		System.out.println("MyQueue final 14-20: " + q.toString());
	}

}
