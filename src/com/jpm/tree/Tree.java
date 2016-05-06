package com.jpm.tree;

/**
 * Cracking the coding Interview, 4 edition
 * 
 * 4.1 Implement a function to check if a tree is balanced. For the purposes of
 * this question, a balanced tree is defined to be a tree such that no two leaf
 * nodes differ in distance from the root by more than one. pg 54
 * 
 * @author JPMagalhaes
 * 
 * @param <T>
 */
public class Tree<T extends Comparable<T>> {
	T data;
	Tree<T> left;
	Tree<T> right;
	
	public Tree(T data){
		this.data = data;
		left = null;
		right = null;
	}
	
	public void add(T data){
		if(data == null)
			return;
		
		int c = this.data.compareTo(data);
		if(c < 0) {
			if(right == null)
				right = new Tree<>(data);
			else
				right.add(data);
		} else if(c > 0) {
			if(left == null)
				left = new Tree<>(data);
			else
				left.add(data);	
		}
	}
	
	public void printInOrder(){
		
		if(left != null)
			left.printInOrder();
		
		System.out.print(data + " ");
		
		if(right != null)
			right.printInOrder();
		
	}
	
	public void printPreOrder(){
		
		System.out.print(data + " ");
		
		if(left != null)
			left.printInOrder();
		
		if(right != null)
			right.printInOrder();
		
	}
	
	public void printPostOrder(){
		if(left != null)
			left.printInOrder();
		
		if(right != null)
			right.printInOrder();
		
		System.out.print(data + " ");
	}
	
	public boolean isBalanced() {
		return maxDepth(this) - minDepth(this) < 2;
	}

	private int minDepth(Tree<T> tree) {
		if(tree == null)
			return 0;
		return 1+Math.min(minDepth(tree.left), minDepth(tree.right));
	}

	private int maxDepth(Tree<T> tree) {
		if(tree == null)
			return 0;
		return 1+Math.max(maxDepth(tree.left), maxDepth(tree.right));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tree<Integer> treeBasic = new Tree<Integer>(2);
		treeBasic.add(1);
		treeBasic.add(3);
		treeBasic.printInOrder();
		System.out.println();
		treeBasic.printPreOrder();
		System.out.println();
		treeBasic.printPostOrder();
		System.out.println();
		System.out.println("Is balanced = " + treeBasic.isBalanced());
		
		Tree<Integer> tree = new Tree<Integer>(50);
		System.out.print("in: ");
		for(int i = 0; i<5; i++) {
			int t = (int)(Math.random() * 100);
			System.out.print(t + " ");
			tree.add(t);
		}
		System.out.println("\nout:");
		tree.printPreOrder();
		System.out.println("Is balanced = " + tree.isBalanced());

	}

}
