package com.revature.ds.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Graph {
	
	private HashMap<Integer, List<Integer>> vertices;
	
	public Graph(int count) {
		vertices = new HashMap<>(count);
		for (int i = 0; i < count; i++) {
			List<Integer> values = new ArrayList<>();
			vertices.put(i, values);
		}
	}
	
	public void display() {
		Set<Integer> nodes = vertices.keySet();
		for (Integer node : nodes) {
			System.out.println(node + " -> " + vertices.get(node));
		}
	}
	
	public void addEdge(int source, int destination) {
		vertices.get(source).add(destination);
	}
	
	public void traverseDepthFirst() {
		Stack<Integer> stack = new Stack<>();
		Set<Integer> discovered = new HashSet<>();
		stack.push(0);
		while (!stack.isEmpty()) {
			int vertex = stack.pop();
			if (!discovered.contains(vertex)) {
				discovered.add(vertex);
				System.out.println(vertex);
				List<Integer> adjacentNodes = vertices.get(vertex);
				for (Integer node : adjacentNodes) {
					stack.push(node);
				}
			}
		}
	}
	
	public void traverseBreadthFirst() {
		Deque<Integer> queue = new ArrayDeque<>();
		Set<Integer> discovered = new HashSet<>();
		queue.add(0);
		while (!queue.isEmpty()) {
			int vertex = queue.poll();
			if (!discovered.contains(vertex)) {
				discovered.add(vertex);
				System.out.println(vertex);
				List<Integer> adjacentNodes = vertices.get(vertex);
				for (Integer node : adjacentNodes) {
					queue.add(node);
				}
			}
		}
		
	}
	
	public static void main(String args[]) {
		Graph graph = new Graph(7);
		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 0);
		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(1, 5);
		graph.addEdge(2, 1);
		graph.addEdge(2, 3);
		graph.addEdge(2, 5);
		graph.addEdge(3, 2);
		graph.addEdge(3, 6);
		graph.addEdge(4, 0);
		graph.addEdge(4, 1);
		graph.addEdge(5, 1);
		graph.addEdge(5, 2);
		graph.addEdge(5, 6);
		graph.addEdge(6, 5);
		graph.addEdge(6, 3);
		graph.display();
		graph.traverseDepthFirst();
	}

}
