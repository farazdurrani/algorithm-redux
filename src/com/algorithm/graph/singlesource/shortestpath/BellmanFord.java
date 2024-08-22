package com.algorithm.graph.singlesource.shortestpath;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.algorithm.graph.Edge;
import com.algorithm.graph.Vertex;

/**
 * @author faraz
 * 
 **         The Bellman-Ford algorithm solves the single-source shortest-paths
 *         problem in the general case in which edge weights may be negative.
 * 
 *         It has to be weighted and directed graph.
 *
 */
public class BellmanFord {
	public static void main(String[] args) {

		List<Edge> edges = getWeight();

		List<Vertex> vertices = getVertices(edges);

		//bellmanFord will report if there are negative weight cycles
		boolean cycle = bellmanFordAlgorithm(edges, vertices, vertices.get(0));
		System.out.println(cycle);

		printPath(vertices.get(0), vertices.get(4)); // from s to z
		System.out.println();
		//reverse of above
		printPath(vertices.get(4), vertices.get(0)); // from z to s
		System.out.println();
		printPath(vertices.get(2), vertices.get(4)); // from x to z
		System.out.println();
		printPath(vertices.get(3), vertices.get(4)); // from y to z
		System.out.println();
	}

	private static void printPath(Vertex s, Vertex v) {
		if (s.equals(v)) {
			System.out.print(v.label + "/" + v.d + " ");
		} else if (v.p == null) {
			System.out.print("No path from " + s.label + " to " + v.label);
		} else {
			printPath(s, v.p);
			System.out.print(v.label + "/" + v.d + " ");
		}
	}

	private static boolean bellmanFordAlgorithm(List<Edge> edges,
			List<Vertex> vertices, Vertex source) {
		// Initialize!
		for (Vertex v : vertices) {
			v.d = Integer.MAX_VALUE;
			v.p = null;
		}
		source.d = 0;
		// algorithm
		for (int i = 0; i < vertices.size() - 1; i++) {
			for (Edge edge : edges) {
				// relaxation part
				Vertex v = edge.destination;
				Vertex u = edge.source;
				if (v.d > u.d + edge.weight) {
					v.d = u.d + edge.weight;
					v.p = u;
				}
			}
		}
		// detect cycles
		for (Edge edge : edges) {
			Vertex v = edge.destination;
			Vertex u = edge.source;
			if (v.d > u.d + edge.weight) {
				// cycle detected
				return false;
			}
		}
		return true;
	}

	private static List<Edge> getWeight() {
		List<Vertex> vertices = getVertices();
		Vertex s = vertices.get(0);
		Vertex t = vertices.get(1);
		Vertex x = vertices.get(2);
		Vertex y = vertices.get(3);
		Vertex z = vertices.get(4);
		return List.of(new Edge(s, t, 6), new Edge(s, y, 7), new Edge(t, x, 5),
				new Edge(t, y, 8), new Edge(t, z, -4), new Edge(x, t, -2),
				new Edge(y, x, -3), new Edge(y, z, 9), new Edge(z, s, 2),
				new Edge(z, x, 7));
	}

	private static List<Vertex> getVertices() {
		return List.of(new Vertex("s"), new Vertex("t"), new Vertex("x"),
				new Vertex("y"), new Vertex("z"));
	}

	private static List<Vertex> getVertices(List<Edge> edges) {
		Set<Vertex> _vertices = edges.stream().map(e -> e.source)
				.collect(Collectors.toSet());
		_vertices.addAll(edges.stream().map(e -> e.destination)
				.collect(Collectors.toSet()));
		return new ArrayList<>(_vertices);
	}
}
