package com.revature.ds.weightedgraph;

import java.util.HashSet;
import java.util.Set;

public class Vertex {
	private String label;
	private Set<Edge> edges;
	private double distance;
	private Vertex previous;

	public Vertex(String label) {
		this.label = label;
		this.edges = new HashSet<>();
		this.distance = Double.MAX_VALUE;
		this.previous = null;
	}
	
	public String getLabel() {
		return label;
	}

	public void addEdge(Edge edge) {
		edges.add(edge);
	}
	
	public Set<Edge> getEdges() {
		return edges;
	}
	
	public double getDistance() {
		return distance;
	}
	
	public void setDistance(double distance) {
		this.distance = distance;
	}

	public Vertex getPrevious() {
		return previous;
	}

	public void setPrevious(Vertex previous) {
		this.previous = previous;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vertex [label=" + label + ", distance=" + distance + ", previous=" + previous + "]";
	}

}
