package com.algorithm.graph.singlesource.shortestpath;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.algorithm.dynamiclist.ten.Stack;
import com.algorithm.graph.Color;
import com.algorithm.graph.Edge;
import com.algorithm.graph.Vertex;

/**
 * @author faraz If we follow the figure in the book, there is no path from 'r'
 *         to 'z' (0th position to 5th position) because we made 's' as source
 *         and that has 0 distance/discovery time. If you look at the picture,
 *         there is no path going back to 'r' from 's' (our source). General
 *         Problem with the algorithm: We can only go from one vertex to another
 *         if it's in the shortest path. Otherwise it won't go even though there
 *         should be a way to find distance from any vertex to another vertex.
 *         Answer: Actually you can. You just need to set the source if it's not
 *         in the shortest-path. Or use Bellman-Ford if you want to get to any
 *         vertex from any vertex. (haven't reached Dijkstra Algorithm yet),
 *
 */
public class DAGShortestPath {
	// look up difference between dag shortest path and bellman ford

	public static void main(String[] args) {
		// psuedo-code
		// topologicalSort, put it in a stack in order of finishing time
		// initialize again
		// pop items off stack,
		// for each v in u, relax-code

		Map<Vertex, List<Edge>> graph = getGraph();

		// well tested. This code is working.
		DAG_SHORTEST_PATH(graph, graph.keySet().stream()
				.filter(v -> v.equals(new Vertex("s"))).findAny().get());

		List<Vertex> vertices = new ArrayList<>(graph.keySet());

		System.out.println();
		System.out.println("Total vertices: " + vertices);
		printPath(vertices.get(0), vertices.get(5)); // from r to z
		System.out.println();
		// reverse of above
		printPath(vertices.get(5), vertices.get(0)); // from z to r
		System.out.println();
		printPath(vertices.get(1), vertices.get(5)); // from s to z
		System.out.println();
		printPath(vertices.get(3), vertices.get(5)); // from x to z
		System.out.println();
		printPath(vertices.get(4), vertices.get(5)); // from y to z
		System.out.println();

		// what happens when we make 'r' as source?
		make_r_as_source(graph);
	}

	private static void printPath(Vertex s, Vertex v) {
		if (s.equals(v)) {
			System.out.print("\'" + s.label + "\' ");
		} else if (v.p == null) {
			System.out.print(
					"No Path from \'" + s.label + "\' to \'" + v.label + "\' ");
		} else {
			printPath(s, v.p);
			System.out.print("\'" + v.label + "\' ");
		}
	}

	private static void DAG_SHORTEST_PATH(Map<Vertex, List<Edge>> graph,
			Vertex source) {
		Stack<Vertex> stack = topologicalSort(graph);
		// initializing step
		for (Vertex u : graph.keySet()) {
			u.p = null;
			u.d = Integer.MAX_VALUE - 100;
		}
		source.d = 0;
		// initializing complete
		while (!stack.isEmpty()) {
			Vertex u = stack.pop();
			System.out.print(u.label + " - ");
			for (Edge e : graph.get(u)) {
				Vertex v = e.destination;
				// relax edge
				if (v.d > u.d + e.weight) {
					v.d = u.d + e.weight;
					v.p = u;
				}
			}
		}
	}

	static int TIME;

	private static Stack<Vertex> topologicalSort(
			Map<Vertex, List<Edge>> graph) {
		return DFS(graph);
	}

	private static Stack<Vertex> DFS(Map<Vertex, List<Edge>> graph) {

		// initializing step
		for (Vertex u : graph.keySet()) {
			u.p = null;
			u.c = Color.WHITE;
		}
		TIME = 0;
		Stack<Vertex> stack = new Stack<>();

		for (Vertex u : graph.keySet()) {
			if (u.c == Color.WHITE) {
				DFS_VISIT(u, stack, graph);
			}
		}

		return stack;
	}

	private static void DFS_VISIT(Vertex u, Stack<Vertex> stack,
			Map<Vertex, List<Edge>> graph) {
		TIME = TIME + 1;
		u.d = TIME;
		u.c = Color.GRAY;
		for (Edge e : graph.get(u)) {
			Vertex v = e.destination;
			if (v.c == Color.WHITE) {
				v.p = u;
				DFS_VISIT(v, stack, graph);
			}
		}
		u.c = Color.BLACK;
		TIME = TIME + 1;
		u.f = TIME;
		stack.push(u);
	}

	private static Map<Vertex, List<Edge>> getGraph() {
		List<Vertex> vertices = getVertices();
		Vertex s = vertices.get(0);
		Vertex t = vertices.get(1);
		Vertex x = vertices.get(2);
		Vertex y = vertices.get(3);
		Vertex z = vertices.get(4);
		Vertex r = vertices.get(5);

		Map<Vertex, List<Edge>> graph = new LinkedHashMap<>();
		graph.put(r, List.of(new Edge(r, s, 5), new Edge(r, t, 3)));
		graph.put(s, List.of(new Edge(s, t, 2), new Edge(s, x, 6)));
		graph.put(t, List.of(new Edge(t, x, 7), new Edge(t, y, 4),
				new Edge(t, z, 2)));
		graph.put(x, List.of(new Edge(x, y, -1), new Edge(x, z, 1)));
		graph.put(y, List.of(new Edge(y, z, -2)));
		graph.put(z, List.of());
		return graph;
	}

	private static List<Vertex> getVertices() {
		return List.of(new Vertex("s"), new Vertex("t"), new Vertex("x"),
				new Vertex("y"), new Vertex("z"), new Vertex("r"));
	}

	private static void make_r_as_source(Map<Vertex, List<Edge>> graph) {
		System.out.println("\nMaking 'r' as source");
		DAG_SHORTEST_PATH(graph, graph.keySet().stream()
				.filter(v -> v.equals(new Vertex("r"))).findAny().get());

		List<Vertex> vertices = new ArrayList<>(graph.keySet());

		System.out.println("Total vertices: " + vertices);
		System.out.println();
		printPath(vertices.get(0), vertices.get(5)); // from r to z
		System.out.println();
		// reverse of above
		printPath(vertices.get(5), vertices.get(0)); // from z to r
		System.out.println();
		printPath(vertices.get(1), vertices.get(5)); // from s to z
		System.out.println();
		printPath(vertices.get(3), vertices.get(5)); // from x to z
		System.out.println();
		printPath(vertices.get(4), vertices.get(5)); // from y to z
		System.out.println();
	}

}
