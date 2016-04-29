package com.jpm.linkedlist;

/**
 * Linked List definition and utilities methods
 * 
 * @author JPMagalhaes
 *
 */
public class LinkedList {
	
	public static void print(Node<?> list) {
		Node<?> t = list;
		while(t != null){
			System.out.print(t.value + " -> ");
			t = t.next;
		}
		System.out.println();
	}
	
}
