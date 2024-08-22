package com.algorithm.graph.singlesource.shortestpath.greedy;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import com.algorithm.graph.Edge;
import com.algorithm.graph.Vertex;

public class DijkstraAlgorithm {
	public static void main(String[] args) {
		Map<Vertex, List<Edge>> graph = getGraph();
		List<Vertex> shortestPaths = dijkstra(graph,
				graph.keySet().stream().findFirst().get());
		System.out.println(shortestPaths);
	}

	private static List<Vertex> dijkstra(Map<Vertex, List<Edge>> graph,
			Vertex source) {
		// initialize
		for (Vertex u : graph.keySet()) {
			u.key = Integer.MAX_VALUE - 100;
			u.p = null;
		}
		source.key = 0;
		List<Vertex> list = new ArrayList<>();
		PriorityQueue<Vertex> q = new PriorityQueue<>(graph.keySet());
		while (!q.isEmpty()) {
			Vertex u = q.remove();
			list.add(u);
			for (Edge e : graph.get(u)) {
				Vertex v = e.destination;
				boolean hasV = q.remove(v);
				int w_uv = e.weight;
				// relax
				if (v.key > u.key + w_uv) {
					v.key = u.key + w_uv;
					v.p = u;
				}
				if (hasV) {
					q.add(v);
				}
			}
		}
		return list;
	}

	private static Map<Vertex, List<Edge>> getGraph() {
		List<Vertex> vertices = getVertices();
		Vertex s = vertices.get(0);
		Vertex t = vertices.get(1);
		Vertex x = vertices.get(2);
		Vertex y = vertices.get(3);
		Vertex z = vertices.get(4);

		Map<Vertex, List<Edge>> graph = new LinkedHashMap<>();
		graph.put(s, List.of(new Edge(s, t, 10), new Edge(s, y, 5)));
		graph.put(t, List.of(new Edge(t, x, 1), new Edge(t, y, 2)));
		graph.put(x, List.of(new Edge(x, z, 4)));
		graph.put(y, List.of(new Edge(y, t, 3), new Edge(y, z, 2),
				new Edge(y, x, 9)));
		graph.put(z, List.of(new Edge(z, s, 7), new Edge(z, x, 6)));
		return graph;
	}

	private static List<Vertex> getVertices() {
		return List.of(new Vertex("s"), new Vertex("t"), new Vertex("x"),
				new Vertex("y"), new Vertex("z"));
	}
}
