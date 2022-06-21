package com.revature.ds.weightedgraph;

public class Edge {
	private Vertex to;
	private double weight;
	
	public Edge(Vertex to, double weight) {
		this.to = to;
		this.weight = weight;
	}

	public Vertex getTo() {
		return to;
	}

	public void setTo(Vertex to) {
		this.to = to;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}
