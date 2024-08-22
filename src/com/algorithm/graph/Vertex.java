package com.algorithm.graph;

public class Vertex implements Comparable<Vertex> {

	public String label;
	public Color c;
	public Vertex p; // parent
	public int d; // discovery time for DFS. Or distance for BFS;
	public int f; // found time
	public int key; // edge weight at the time of Prim's Algorithm.
					// Alternatively we could use attribute 'd'

	public Vertex(String label) {
		this.label = label;
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
		return "[" + label + "=" + key + "]";
	}

	@Override
	public int compareTo(Vertex o) {
		if (this.key > o.key) {
			return 1;
		} else if (this.key < o.key) {
			return -1;
		} else {
			return 0;
		}
	}

}
