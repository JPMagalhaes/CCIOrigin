package com.jpm.linkedlist;

public class LinkedList {
	
	public static class Node<T> {
		T value;
		Node<T> next;
	}
	
	public static void print(Node<?> list) {
		Node<?> t = list;
		while(t != null){
			System.out.print(t.value + " -> ");
			t = t.next;
		}
		System.out.println();
	}
	
}
