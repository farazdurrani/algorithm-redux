package com.algorithm.graph.topologicalsort;

import java.util.List;
import java.util.Map;

import com.algorithm.dynamiclist.ten.Stack;
import com.algorithm.graph.Color;
import com.algorithm.graph.Vertex;

public class TopologicalSort {

	static int TIME;
	public static void main(String[] args) {
		Map<Vertex, List<Vertex>> graph = testData0();

		printGraph(graph);

		topologicalSort(graph);

	}

	public static void topologicalSort(Map<Vertex, List<Vertex>> graph) {
		Stack<Vertex> s = new Stack<>(); // contains vertices in order of
											// decreasing u.f
		DFS(graph, s);
		System.out.println("Topological Sort");
		while (!s.isEmpty()) {
			Vertex vertex = s.pop();
			System.out.println(
					vertex.label + "-" + vertex.d + "/" + vertex.f + "  ");
		}
	}

	public static void DFS(Map<Vertex, List<Vertex>> graph, Stack<Vertex> s) {
		for (Vertex u : graph.keySet()) {
			u.c = Color.WHITE;
			u.p = null; // symbolically
		}
		TIME = 0; // symbolic
		for (Vertex u : graph.keySet()) {
			if (u.c == Color.WHITE) {
				DFS_VISIT(graph, u, s);
			}
		}
	}

	private static void DFS_VISIT(Map<Vertex, List<Vertex>> graph, Vertex u,
			Stack<Vertex> s) {
		TIME = TIME + 1;
		u.d = TIME;
		u.c = Color.GRAY;
		for (Vertex v : graph.get(u)) {
			if (v.c == Color.WHITE) {
				v.p = u;
				DFS_VISIT(graph, v, s);
			}
		}
		u.c = Color.BLACK;
		TIME = TIME + 1;
		u.f = TIME;
		s.push(u);
	}

	private static Map<Vertex, List<Vertex>> testData0() {
		Vertex undershorts = new Vertex("undershorts");
		Vertex pants = new Vertex("pants");
		Vertex belt = new Vertex("belt");
		Vertex shirt = new Vertex("shirt");
		Vertex tie = new Vertex("tie");
		Vertex jacket = new Vertex("jacket");
		Vertex socks = new Vertex("socks");
		Vertex shoes = new Vertex("shoes");
		Vertex watch = new Vertex("watch");

		return Map.of(undershorts, List.of(shoes, pants), pants,
				List.of(shoes, belt), belt, List.of(jacket), shirt,
				List.of(belt, tie), tie, List.of(jacket), jacket, List.of(),
				socks, List.of(shoes), shoes, List.of(), watch, List.of());

	}

	private static Map<Vertex, List<Vertex>> testData1() {
		Vertex zero = new Vertex("0");
		Vertex one = new Vertex("1");
		Vertex two = new Vertex("2");
		Vertex three = new Vertex("3");
		Vertex four = new Vertex("4");
		Map<Vertex, List<Vertex>> graph = Map.of(one, List.of(zero), zero,
				List.of(two, three), two, List.of(one), three, List.of(four),
				four, List.of());
		return graph;
	}

	private static void printGraph(Map<Vertex, List<Vertex>> graph) {
		System.out.println("Graph -> ");
		graph.forEach((k, v) -> {
			System.out.print(k.label + " [ ");
			v.forEach(_v -> System.out.print(_v.label + " "));
			System.out.println("]");
		});
	}
}
