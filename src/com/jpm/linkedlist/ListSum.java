package com.jpm.linkedlist;

import com.jpm.linkedlist.LinkedList.Node;

/**
 * Cracking the coding Interview, 4 edition
 * 
 * You have two numbers represented by a linked list, where each node contains a
 * single digit. The digits are stored in reverse order, such that the 1’s digit
 * is at the head of the list. Write a function that adds the two numbers and
 * returns the sum as a linked list. EXAMPLE Input: (3 -> 1 -> 5), (5 -> 9 -> 2)
 * Output: 8 -> 0 -> 8
 * 
 * pg 50
 * 
 * @author JPMagalhaes
 * 
 */
public class ListSum {

	public static Node<Integer> sumLists(Node<Integer> in1, Node<Integer> in2) {
		if (in1 == null && in2 == null)
			return null;
		
		Node<Integer> t1 = in1;
		Node<Integer> t2 = in2;
		Node<Integer> output = new Node<Integer>();
		Node<Integer> tOut = output;
		tOut.value = 0;
		while (tOut != null) {
			if (t1 != null) {
				tOut.value += t1.value;
				t1 = t1.next;
			}
			if (t2 != null) {
				tOut.value += t2.value;
				t2 = t2.next;
			}

			int temp = tOut.value / 10;
			tOut.value %= 10;
			
			if (temp > 0 || t2 != null || t1 != null) {
				tOut.next = new Node<Integer>();
				tOut.next.value = temp;
			}
			
			tOut = tOut.next;
		}
		
		return output;
	}

	public static void testIntList() {
		Node<Integer> in1 = new Node<Integer>();
		Node<Integer> in2 = new Node<Integer>();
		
		int len1 = (int)(Math.random()*10), len2 = (int)(Math.random()*10);
		populateRandomList(in1, len1);
		populateRandomList(in2, len2);

		LinkedList.print(in1);
		LinkedList.print(in2);
		LinkedList.print(sumLists(in1, in2));
	}

	private static void populateRandomList(Node<Integer> input, int len) {
		Node<Integer> in = input;
		for (int i = 0; i < len; i++) {
			in.value = (int)(Math.random()*10);
			if(i+1 < len) {
				in.next = new Node<Integer>();
				in = in.next;
			}
		}
	}

	public static void main(String[] args) {
		testIntList();
	}

}
