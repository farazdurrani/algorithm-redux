package com.algorithm.graph.stronglyconnectedcomponent;

import java.util.List;
import java.util.Map;

import com.algorithm.dynamiclist.ten.Stack;
import com.algorithm.graph.Color;
import com.algorithm.graph.Vertex;
import com.algorithm.graph.transpose.Transpose;

/**
 * @author faraz
 *
 **         We can find cycles through DFS. And if asked to show cycles, we can
 *         run Strongly Connected Components to find all the cycles.
 */
public class StronglyConnectedComponents {

	private static int TIME;

	public static void main(String[] args) {

		// this is from the book Cormen Algorithm 3rd edition
		Map<Vertex, List<Vertex>> graph = testData0();

		// more testing

		graph = testData1();

		// more testing

		graph = testData2();

		// it's working for all 3 test cases

		System.out.println("Graph -> ");
		graph.forEach((k, v) -> System.out.println(k + " " + v));

		System.out.println("Strong Connected Components");
		stronglyConnectedComponents(graph);
	}

	public static void stronglyConnectedComponents(
			Map<Vertex, List<Vertex>> graph) {
		// stack contains vertices in order of decreasing u.f
		Stack<Vertex> s = new Stack<>();
		DFS(graph, s);
		Map<Vertex, List<Vertex>> graphT = Transpose.transpose(graph);
		DFS_MODIFIED(graphT, s);
	}

	private static void DFS(Map<Vertex, List<Vertex>> graph, Stack<Vertex> s) {
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

	/**
	 * This is a modified version of Depth First Search
	 */
	private static void DFS_MODIFIED(Map<Vertex, List<Vertex>> graphT,
			Stack<Vertex> s) {
		for (Vertex u : graphT.keySet()) {
			u.p = null;
			u.c = Color.WHITE;
		}

		while (!s.isEmpty()) {
			Vertex u = s.pop();
			if (u.c == Color.WHITE) {
				System.out.print(u.label + " ");
				DFS_VISIT(u, graphT);
				System.out.println();
			}
		}
	}

	/**
	 * This is a modified version of DFS-Visit
	 */
	private static void DFS_VISIT(Vertex u, Map<Vertex, List<Vertex>> graphT) {
		u.c = Color.GRAY;
		for (Vertex v : graphT.get(u)) {
			if (v.c == Color.WHITE) {
				System.out.print(v.label + " ");
				DFS_VISIT(v, graphT);
			}
		}
		u.c = Color.BLACK;
	}
	
	private static Map<Vertex, List<Vertex>> testData0() {
		Vertex a = new Vertex("a");
		Vertex b = new Vertex("b");
		Vertex c = new Vertex("c");
		Vertex d = new Vertex("d");
		Vertex e = new Vertex("e");
		Vertex f = new Vertex("f");
		Vertex g = new Vertex("g");
		Vertex h = new Vertex("h");
		Map<Vertex, List<Vertex>> graph = Map.of(a, List.of(b), b,
				List.of(c, e, f), c, List.of(d, g), d, List.of(c, h), e,
				List.of(a, f), f, List.of(g), g, List.of(f, h), h, List.of(h));
		return graph;
	}

	/**
	 * https://www.programiz.com/dsa/strongly-connected-components
	 */
	private static Map<Vertex, List<Vertex>> testData2() {
		Vertex zero = new Vertex("0");
		Vertex one = new Vertex("1");
		Vertex two = new Vertex("2");
		Vertex three = new Vertex("3");
		Vertex four = new Vertex("4");
		Vertex five = new Vertex("5");
		Vertex six = new Vertex("6");
		Vertex seven = new Vertex("7");
		Map<Vertex, List<Vertex>> graph = Map.of(zero, List.of(one), one,
				List.of(two), two, List.of(three, four), three, List.of(zero),
				four, List.of(five), five, List.of(six), six,
				List.of(four, seven), seven, List.of());
		return graph;
	}

	/**
	 * https://www.geeksforgeeks.org/strongly-connected-components/
	 */
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
}
