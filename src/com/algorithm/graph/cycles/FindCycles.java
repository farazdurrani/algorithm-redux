package com.algorithm.graph.cycles;

import java.util.List;
import java.util.Map;

import com.algorithm.dynamiclist.ten.Stack;
import com.algorithm.graph.Color;
import com.algorithm.graph.Vertex;
import com.algorithm.graph.stronglyconnectedcomponent.StronglyConnectedComponents;

/**
 * @author faraz
 * 
 *         * We can use DFS to find cycles from both directed and undirected
 *         graphs. To find all the vertices that form a cycle, we can run
 *         StronglyConnectedComponents
 *
 */
/**
 * @author faraz
 *
 */
public class FindCycles {
	public static void main(String[] args) {

		// will find a cycle
		Map<Vertex, List<Vertex>> graph = testData0();

		// more testing
		// will find a cycle
		graph = testData1();

		// more testing
		// will find a cycle
		graph = testData2();

		// more testing
		// there is NO cycle
		graph = testData3();

		// more testing
		// there is NO cycle
		graph = testData4();

		DFS_findCycles_Directed(graph);

		// undirected
		// cycle detected
		graph = testData5();

		// undirected
		// cycle NOT detected
		graph = testData6();

		// undirected
		// cycle detected
		graph = testData7();

		// undirected
		// cycle NOT detected
		graph = testData8();
		DFS_findCycles_Undirected(graph);

		// undirect - print cycles
		graph = testData9();
		// As per the internet,
		// finding all the cycles in an undirected graph
		// is NP-Complete. Hence aborting attempt.
		PRINT_CYCLE_IN_UNDIRECTED(graph);
	}

	/**
	 * As per the internet, finding all the cycles in an undirected graph is
	 * NP-Complete. Hence aborting attempt.
	 */
	private static void PRINT_CYCLE_IN_UNDIRECTED(
			Map<Vertex, List<Vertex>> graph) {
		for (Vertex u : graph.keySet()) {
			u.p = null;
			u.c = Color.WHITE;
		}

		for (Vertex u : graph.keySet()) {
			if (u.c == Color.WHITE) {
				Stack<Vertex> stack = new Stack<>();
				if (DFS_DETECT_CYCLES_UNDIRECTED(graph, u, stack)) {
					System.out.println("Found Cycle!");
					Vertex last = stack.pop();
					String label = last.label;
					while (last != null) {
						System.out.print(last.label + " ");
						last = last.p;
						if (last == null || last.label.equals(label)) {
							break;
						}
					}
					System.out.println();
				}
				for (Vertex _u : graph.keySet()) {
					_u.p = null;
					// _u.c = Color.WHITE;
				}
			}
		}
	}

	private static boolean DFS_DETECT_CYCLES_UNDIRECTED(
			Map<Vertex, List<Vertex>> graph, Vertex u, Stack<Vertex> stack) {
		u.c = Color.BLACK;
		for (Vertex v : graph.get(u)) {
			if (v.c == Color.BLACK && v != u.p) {
				v.p = u;
				stack.push(v);
				return true;
			}
			if (v.c == Color.WHITE) {
				v.p = u;
				if (DFS_DETECT_CYCLES_UNDIRECTED(graph, v, stack)) {
					return true;
				}
			}
		}
		return false;
	}

	private static void DFS_findCycles_Undirected(
			Map<Vertex, List<Vertex>> graph) {
		for (Vertex u : graph.keySet()) {
			u.c = Color.WHITE;
			u.p = null;
		}

		boolean cycle = false;
		for (Vertex u : graph.keySet()) {
			if (u.c == Color.WHITE) {
				if (DFS_VISIT_findCycles_Undirected(graph, u)) {
					System.out.println("Found a cycle in Undirected Graph!");
					cycle = true;
					break;
				}
			}
		}

		if (!cycle) {
			System.out.println("No cycle found in Undirected Graph");
		}
	}

	private static boolean DFS_VISIT_findCycles_Undirected(
			Map<Vertex, List<Vertex>> graph, Vertex u) {
		u.c = Color.BLACK;
		for (Vertex v : graph.get(u)) {
			if (v.c == Color.BLACK && v != u.p) {
				return true;
			} else if (v.c == Color.WHITE) {
				v.p = u;
				if (DFS_VISIT_findCycles_Undirected(graph, v)) {
					return true;
				}
			}
		}
		return false;
	}

	private static void DFS_findCycles_Directed(
			Map<Vertex, List<Vertex>> graph) {
		for (Vertex u : graph.keySet()) {
			u.c = Color.WHITE;
			u.p = null;
		}

		boolean cycle = false;
		for (Vertex u : graph.keySet()) {
			if (u.c == Color.WHITE) {
				if (DFS_VISIT_findCycles_Directed(graph, u)) {
					cycle = true;
					System.out.println(
							"Found a cycle in directed Graph. Cycle is");
					StronglyConnectedComponents
							.stronglyConnectedComponents(graph);
					break;
				}
			}
		}
		if (!cycle) {
			System.out.println("No Cycle Found in Directed Graph!");
			StronglyConnectedComponents.stronglyConnectedComponents(graph);
		}

	}

	private static boolean DFS_VISIT_findCycles_Directed(
			Map<Vertex, List<Vertex>> graph, Vertex u) {
		u.c = Color.GRAY;
		for (Vertex v : graph.get(u)) {
			if (v.c == Color.GRAY) {
				return true;
			}
			if (v.c == Color.WHITE) {
				v.p = u;
				if (DFS_VISIT_findCycles_Directed(graph, v)) {
					return true;
				}
			}
		}
		u.c = Color.BLACK;
		return false;
	}

	/**
	 * From the book Cormen's Algorithm 3rd edition
	 */
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

	/**
	 * https://www.algotree.org/algorithms/tree_graph_traversal/depth_first_search/cycle_detection_in_directed_graphs/
	 */
	private static Map<Vertex, List<Vertex>> testData4() {
		Vertex zero = new Vertex("0");
		Vertex one = new Vertex("1");
		Vertex two = new Vertex("2");
		Vertex three = new Vertex("3");
		Vertex four = new Vertex("4");
		return Map.of(zero, List.of(one, two), one, List.of(), two,
				List.of(three), three, List.of(four), four, List.of(one));
	}

	/**
	 * https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
	 */
	private static Map<Vertex, List<Vertex>> testData3() {
		Vertex zero = new Vertex("0");
		Vertex one = new Vertex("1");
		Vertex two = new Vertex("2");
		Vertex three = new Vertex("3");
		return Map.of(zero, List.of(one, two), one, List.of(two), two,
				List.of(three), three, List.of());
	}

	private static Map<Vertex, List<Vertex>> testData8() {
		Vertex a = new Vertex("a");
		Vertex b = new Vertex("b");
		Vertex c = new Vertex("c");
		Vertex d = new Vertex("d");
		Vertex e = new Vertex("e");
		Vertex f = new Vertex("f");
		Vertex g = new Vertex("g");
		Vertex h = new Vertex("h");
		return Map.of(a, List.of(b, h), b, List.of(a), h, List.of(a, g), g,
				List.of(h, f), f, List.of(c, g), c, List.of(d, f), d,
				List.of(c, e), e, List.of(d));
	}

	private static Map<Vertex, List<Vertex>> testData7() {
		Vertex one = new Vertex("1");
		Vertex two = new Vertex("2");
		Vertex three = new Vertex("3");
		Vertex four = new Vertex("4");
		Vertex five = new Vertex("5");
		Vertex six = new Vertex("6");
		return Map.of(one, List.of(two, five), two, List.of(one, three, four),
				three, List.of(two, four), four, List.of(two, three, five, six),
				five, List.of(one, four, six), six, List.of(four, five));
	}

	private static Map<Vertex, List<Vertex>> testData6() {
		Vertex zero = new Vertex("0");
		Vertex one = new Vertex("1");
		Vertex two = new Vertex("2");
		Vertex three = new Vertex("3");
		Vertex four = new Vertex("4");
		Vertex five = new Vertex("5");
		Vertex six = new Vertex("6");
		return Map.of(zero, List.of(one, two), one, List.of(zero), two,
				List.of(zero, three, four), three, List.of(two), four,
				List.of(two, five, six), five, List.of(four), six,
				List.of(four));
	}

	private static Map<Vertex, List<Vertex>> testData5() {
		Vertex zero = new Vertex("0");
		Vertex one = new Vertex("1");
		Vertex two = new Vertex("2");
		Vertex three = new Vertex("3");
		return Map.of(zero, List.of(one, two), one, List.of(zero, three), two,
				List.of(zero, three), three, List.of(one, two));
	}

	private static Map<Vertex, List<Vertex>> testData9() {
		Vertex _1 = new Vertex("1");
		Vertex _2 = new Vertex("2");
		Vertex _3 = new Vertex("3");
		Vertex _4 = new Vertex("4");
		Vertex _5 = new Vertex("5");
		Vertex _6 = new Vertex("6");
		Vertex _7 = new Vertex("7");
		Vertex _8 = new Vertex("8");
		return Map.of(_1, List.of(_2), _2, List.of(_1, _3, _5), _3,
				List.of(_2, _4), _4, List.of(_3, _5), _5, List.of(_2, _4), _6,
				List.of(_5, _7), _7, List.of(_6, _8), _8, List.of(_6, _7));
	}
}
