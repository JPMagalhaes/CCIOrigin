package com.jpm.linkedlist;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;



/**
 * Cracking the coding Interview, 4 edition
 * 2.1 Write code to remove duplicates from an unsorted linked list.
 * 
 * FOLLOW UP How would you solve this problem if a temporary buffer is not allowed?
 * pg 50
 *  
 * @author JPMagalhaes
 *
 */
public class RemoveDuplicates {
	
	public static void removeDuplicates(Node<?> list, boolean useBuffer) {
		if(useBuffer)
			removeDuplicatesBuffer(list);
		else
			removeDuplicatesNoBuffer(list);
	}
	
	public static void removeDuplicatesBuffer(Node<?> list) {
		if(list == null || list.next == null)
			return;
			
		HashSet set = new HashSet();
		Node current = list;
		Node last = null;
		while(current != null) {
			if(set.contains(current.value)) {
				last.next = current.next;
				current = last.next;
			} else {
				set.add(current.value);
				last = current;
				current = current.next;
			}
		}
		
	}
	
	public static void removeDuplicatesNoBuffer(Node list) {
		if(list == null)
			return;
		
		Node temp = list.next;
		Node last = list;
		while(temp != null) {
			if(temp.value == list.value) {
				last.next = temp.next;
				temp = last.next;
			} else {
				last = temp;
				temp = temp.next;
			}
		}
		removeDuplicatesNoBuffer(list.next);
	}
	
	public static void testIntList(boolean useBuffer){
		Node<Integer> intList = new Node<Integer>();
		Node<Integer> temp = intList;
		Node<Integer> last = temp;
		for (int i = 0; i < 21; i++) {
			temp.value = i/2;
			temp.next = new Node<Integer>();
			last = temp;
			temp = temp.next;
		}
		last.next = null;
		
		LinkedList.print(intList);
		removeDuplicates(intList, useBuffer);
		LinkedList.print(intList);
	}
	
	public static void testTxtList( boolean useBuffer){
		Node<String> txtList = new Node<String>();
		Node<String> t = txtList;
		t.value = "first";
		
		t.next = new Node<String>();
		t = t.next;
		t.value = "first";
		
		LinkedList.print(txtList);
		removeDuplicates(txtList, useBuffer);
		LinkedList.print(txtList);
		
		t = txtList;
		t.next = new Node<String>();
		t = t.next;
		t.value = "second";
		
		LinkedList.print(txtList);
		removeDuplicates(txtList, useBuffer);
		LinkedList.print(txtList);
		
		Node last = t;
		t.next = new Node<String>();
		t = t.next;
		t.value = "second";
		
		LinkedList.print(txtList);
		removeDuplicates(txtList, useBuffer);
		LinkedList.print(txtList);
		
		t = last;
		t.next = new Node<String>();
		t = t.next;
		t.value = "first";
		
		t.next = new Node<String>();
		t = t.next;
		t.value = "third";
		
		LinkedList.print(txtList);
		removeDuplicates(txtList, useBuffer);
		LinkedList.print(txtList);
	}
	
	public static void main(String[] args) {
		testIntList(false);
		testTxtList(false);
		
	}

}
