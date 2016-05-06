package com.jpm.graph;

import java.util.HashMap;
import java.util.Map;

public class Vertex<T> {
	T data;
	Map<T, Vertex<T>> edges;
	
	boolean visited = false;
	Vertex<T> last = null;
	
	public Vertex(T data){
		this.data = data;
		this.edges = new HashMap<T, Vertex<T>>();
	}
	
	public void addEdge(Vertex<T> to){
		edges.put(to.data, to);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(data).append(": ");
		for (Vertex v : edges.values()) {
			builder.append(v.data).append(" ");
		}
		return builder.toString();
	}

}
