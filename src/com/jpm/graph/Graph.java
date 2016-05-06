package com.jpm.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Graph<T> {
	Map<T, Vertex<T>> vertices;
	
	public Graph(){
		vertices = new HashMap<>();
	}
	
	public void addEdge(T from, T to){
		Vertex<T> f = getVertex(from);
		Vertex<T> t = getVertex(to);
		f.addEdge(t);
	}
	
	private Vertex<T> getVertex(T data) {
		Vertex<T> result = vertices.get(data);
		if(result == null) {
			result = new Vertex<>(data);
			vertices.put(data, result);
		}
		return result;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (Vertex v : vertices.values()) {
			builder.append(v).append("\n");
		}
		return builder.toString();
	}
	
	public boolean search(T from, T to) {
		Vertex f = vertices.get(from);
		Vertex t = vertices.get(to);
		
		if(f == null || t == null)
			return false;
		
		resetGraph();
		
		Stack<Vertex<T>> stack = new Stack<>();
		stack.add(f);
		while (!stack.isEmpty()) {
			Vertex v = stack.pop();
			v.visited = true;
			for(Object n : v.edges.values()){
				if(((Vertex)n).data == to)
					return true;
				else if(!((Vertex)n).visited)
					stack.add((Vertex)n);
			}
		}
		return false;
	}
	
	private void resetGraph(){
		for (Vertex v : vertices.values()) {
			v.visited = false;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] in = { { 6, 2, 1, 5 },
						{ 0 },
						{ 0 },
						{ 5, 4 },
						{ 5, 6, 3 },
						{ 3, 4, 0 },
						{ 0, 4 },
						{ 8 },
						{ 7 },
						{ 11, 10, 12 },
						{ 9 },
						{ 9, 12 },
						{ 11, 9 } };
		Graph<Integer> graph = new Graph<>();
		for (int i = 0; i < in.length; i++) {
			for (int j = 0; j < in[i].length; j++) {
				graph.addEdge(i, in[i][j]);
			}
		}
		System.out.println(graph.search(0, 3));
	}

}
