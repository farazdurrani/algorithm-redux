package com.algorithm.graph.bfs;

import java.util.List;
import java.util.Map;

import com.algorithm.dynamiclist.one.Queue;
import com.algorithm.graph.Color;
import com.algorithm.graph.Vertex;

public class BreadthFirstSearch {
	public static void main(String[] args) {
		Vertex r = new Vertex("r");
		Vertex s = new Vertex("s");
		Vertex t = new Vertex("t");
		Vertex u = new Vertex("u");
		Vertex v = new Vertex("v");
		Vertex w = new Vertex("w");
		Vertex x = new Vertex("x");
		Vertex y = new Vertex("y");

		Map<Vertex, List<Vertex>> graph = Map.of(r, List.of(s, v), s,
				List.of(r, w), t, List.of(w, u, x), u, List.of(t, x, y), v,
				List.of(r), w, List.of(s, t, x), x, List.of(w, t, u, y), y,
				List.of(x, u));

		graph.forEach((k, va) -> {
			System.out.print(k.label + " [ ");
			va.forEach(_v -> System.out.print(_v.label + " "));
			System.out.println("]");
		});

		BFS(graph, s);

		printPath(s, y); // print path from source to destination
	}

	/**
	 * print path from source to destination
	 */
	private static void printPath(Vertex s, Vertex v) {

		if (s == v) {
			System.out.print(s.label + " ");
		} else if (v.p == null) {
			System.out.println(v.label + " has no way to " + s.label);
		} else {
			printPath(s, v.p);
			System.out.print(v.label + " ");
		}
	}

	private static void BFS(Map<Vertex, List<Vertex>> graph, Vertex s) {
		for (Vertex u : graph.keySet()) {
			u.c = Color.WHITE;
			u.p = null; // symbolic
			u.d = Integer.MIN_VALUE;
		}

		s.c = Color.GRAY;
		s.d = 0;
		s.p = null; // symbolic

		// Queue will always have gray items. ALWAYS.

		Queue<Vertex> q = new Queue<>();
		q.enqueue(s);

		while (!q.isEmpty()) {
			Vertex u = q.dequeue();
			for (Vertex v : graph.get(u)) {
				if (v.c == Color.WHITE) {
					v.d = u.d + 1;
					v.p = u;
					v.c = Color.GRAY;
					q.enqueue(v);
				}
			}
			u.c = Color.BLACK;
			System.out.println(u.label + " " + u.d);
		}
	}
}
