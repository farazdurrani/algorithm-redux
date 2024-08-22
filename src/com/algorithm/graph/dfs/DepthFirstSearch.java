package com.algorithm.graph.dfs;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.algorithm.graph.Color;
import com.algorithm.graph.Vertex;

public class DepthFirstSearch {

	static int TIME;

	public static void main(String[] args) {

		Map<Vertex, List<Vertex>> graph = new LinkedHashMap<>();
		Vertex u = new Vertex("u");
		Vertex v = new Vertex("v");
		Vertex w = new Vertex("w");
		Vertex x = new Vertex("x");
		Vertex y = new Vertex("y");
		Vertex z = new Vertex("z");

		graph.put(u, List.of(v, x));
		graph.put(v, List.of(y));
		graph.put(w, List.of(y, z));
		graph.put(x, List.of(v));
		graph.put(y, List.of(x));
		graph.put(z, List.of(z));

		System.out.println("Graph ->");
		graph.forEach((k, _v) -> System.out.println(k + " | " + _v));
		System.out.println("Depth-First-Search -> ");
		DFS(graph);
	}

	public static void DFS(Map<Vertex, List<Vertex>> graph) {
		for (Vertex u : graph.keySet()) {
			u.c = Color.WHITE;
			u.p = null; // symbolically
		}
		TIME = 0; // symbolic
		for (Vertex u : graph.keySet()) {
			if (u.c == Color.WHITE) {
				DFS_VISIT(graph, u);
			}
		}
	}

	private static void DFS_VISIT(Map<Vertex, List<Vertex>> graph, Vertex u) {
		TIME = TIME + 1;
		u.d = TIME;
		u.c = Color.GRAY;
		for (Vertex v : graph.get(u)) {
			if (v.c == Color.WHITE) {
				v.p = u;
				DFS_VISIT(graph, v);
			}
		}
		u.c = Color.BLACK;
		TIME = TIME + 1;
		u.f = TIME;
		System.out.println(u.label + " " + u.d + "/" + u.f);
	}
}
