package com.jpm.linkedlist;

/**
 * Cracking the coding Interview, 4 edition
 * 
 * 2.2 Implement an algorithm to find the nth to last element of a singly linked
 * list. pg 50
 * 
 * @author JPMagalhaes
 * 
 */
public class FindNthToLastElement {
	
	public static Node findNthToLastElement(Node list, int position) {
		if(list == null)
			return null;
		
		Node current = list;
		Node result = null;
		int count = position;
		
		while(current != null) {
			if(count == 0){
				if(result == null)
					result = list;
				else
					result = result.next;
			} else {
				count--;
			}
			current = current.next;
		}
		
		return result;
	}
	
	public static void testIntList(){
		Node<Integer> intList = new Node<Integer>();
		Node<Integer> temp = intList, last = temp;
		
		for (int i = 0; i < 4; i++) {
			temp.value = i;
			temp.next = new Node<Integer>();
			last = temp;
			temp = temp.next;
		}
		last.next = null;
		
		LinkedList.print(intList);
		LinkedList.print(findNthToLastElement(intList, 3));
	}
	
	public static void main(String[] args) {
		testIntList();
		
	}
}
