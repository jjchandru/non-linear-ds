package com.revature.ds.weightedgraph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class WeightedGraph {
	private Set<Vertex> vertices;
	
	public WeightedGraph() {
		vertices = new HashSet<>();
	}
	
	public void addVertex(Vertex vertex) {
		vertices.add(vertex);
	}
	
	public Set<Vertex> getVertices() {
		return vertices;
	}
	
	public Vertex getVertex(String label) {
		for (Vertex vertex : vertices) {
			if (vertex.getLabel().equals(label)) {
				return vertex;
			}
		}
		return null;
	}
	
	public void traverseBreadthFirst(String start) {
		Deque<Vertex> queue = new ArrayDeque<>();
		Set<String> discovered = new HashSet<>();
		//System.out.println("******" + getVertex(start));
		queue.add(getVertex(start));
		while (!queue.isEmpty()) {
			Vertex vertex = queue.poll();
			if (!discovered.contains(vertex.getLabel())) {
				discovered.add(vertex.getLabel());
				System.out.println("Current: " + vertex.getLabel());
				for (Edge edge : vertex.getEdges()) {
					//System.out.println("Adjacent: " + edge.getTo().getLabel());
					queue.add(edge.getTo());
				}
				//System.out.println("==========");
			}
		}
	}

	public void shortestPath(String start, String end) {
		Vertex current = getVertex(start);
		current.setDistance(0);
		Deque<Vertex> queue = new ArrayDeque<>();
		for (Vertex vertex : vertices) {
			queue.add(vertex);
		}
		while (!queue.isEmpty()) {
			//System.out.println(queue);
			Vertex minVertex = getMinimumDistanceVertex(queue);
			queue.remove(minVertex);
			for (Edge edge : minVertex.getEdges()) {
				Vertex adjacentVertex = edge.getTo();
				if (queue.contains(adjacentVertex)) {
					double newDistance = minVertex.getDistance() + edge.getWeight();
					if (newDistance < adjacentVertex.getDistance() && 
							minVertex.getDistance() != Double.MAX_VALUE) {
						adjacentVertex.setDistance(newDistance);
						adjacentVertex.setPrevious(minVertex);
					}
				}
			}
		}
		
		/*for (Vertex vertex : vertices) {
			if (vertex.getPrevious() == null) {
				System.out.println(vertex.getLabel() + " " + vertex.getDistance() + " Prev: " + vertex.getPrevious());
			} else {
				System.out.println(vertex.getLabel() + " " + vertex.getDistance() + " Prev: " + vertex.getPrevious().getLabel());
			}
		}*/
		
		System.out.println("Shortest Path from '" + start + "' to '" + end + "'");
		Vertex destination = getVertex(end);
		System.out.println("Total Distance: " + destination.getDistance());
		Stack<Vertex> stack = new Stack<>();
		while (destination != null) {
			//System.out.println(destination.getLabel());
			stack.push(destination);
			destination = destination.getPrevious();
		}
		
		System.out.println("Route: ");
		while (!stack.isEmpty()) {
			System.out.print(stack.pop().getLabel() + " -> ");
		}
	}
	
	private Vertex getMinimumDistanceVertex(Deque<Vertex> queue) {
		Vertex minVertex = null;
		double minDistance = Double.MAX_VALUE;
		for (Vertex vertex : queue) {
			if (vertex.getDistance() < minDistance) {
				minDistance = vertex.getDistance();
				minVertex = vertex;
			}
		}
		return minVertex;
	}
}
