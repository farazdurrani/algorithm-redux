package com.algorithm.graph.minimumspanningtree.greedy;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import com.algorithm.graph.Vertex;

/**
 * @author faraz
 * 
 **         From Generic-MST 1) set A is always acyclic 2) set A cannot add
 *         duplicate edges. When these 2 conditions don't match any longer, we
 *         have a MST. The MST will always have V-1. The total edges will be
 *         V-1.
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class PrimsAlgorithm {
	public static void main(String[] args) {

		Map<Vertex, List<Vertex>> graph = prepareGraph();

		System.out.println("Graph -> ");

		graph.forEach((k, v) -> {
			System.out.print(k.label + " [ ");
			v.forEach(_v -> System.out.print(_v.label + " "));
			System.out.println("]");
		});

		System.out.println("Prim's Algorithm");

		Map<Key, Integer> weight = createWeight();

		Vertex r = new Vertex("a"); // using a random vertex as root;

		primAlgorithm(graph, weight, r);

		// somehow, this print function that I wrote, is correct.
		// I don't know how.
		print(graph);

	}

	private static void primAlgorithm(Map<Vertex, List<Vertex>> graph,
			Map<Key, Integer> weight, Vertex r) {
		for (Vertex u : graph.keySet()) {
			u.key = Integer.MAX_VALUE;
			u.p = null;
		}
		r.key = 0;
		PriorityQueue<Vertex> q = new PriorityQueue<>(graph.keySet());
		while (!q.isEmpty()) {
			Vertex u = q.poll();
			for (Vertex v : graph.get(u)) {
				Key key = new Key(u.label, v.label);
				int wU_V = weight.get(key);
				if (q.contains(v) && wU_V < v.key) {
					q.remove(v);
					v.p = u;
					v.key = wU_V;
					q.add(v);
				}
			}
		}
	}

	private static void print(Map<Vertex, List<Vertex>> graph) {
		int distance = 0;
		for (Vertex u : graph.keySet()) {
			if (u.p != null && u.key != Integer.MAX_VALUE) {
				distance += u.key;
				System.out.println(u.p.label + "->" + u.label + "=" + u.key);
			}
		}
		System.out.println("distance " + distance);
	}

	private static Map<Vertex, List<Vertex>> prepareGraph() {
		Vertex a = new Vertex("a");
		Vertex b = new Vertex("b");
		Vertex c = new Vertex("c");
		Vertex d = new Vertex("d");
		Vertex e = new Vertex("e");
		Vertex f = new Vertex("f");
		Vertex g = new Vertex("g");
		Vertex h = new Vertex("h");
		Vertex i = new Vertex("i");

		Map<Vertex, List<Vertex>> graph = new LinkedHashMap<>();

		graph.put(a, List.of(b, h));
		graph.put(b, List.of(a, c, h));
		graph.put(c, List.of(b, d, f, i));
		graph.put(d, List.of(c, e, f));
		graph.put(e, List.of(d, f));
		graph.put(f, List.of(c, d, e));
		graph.put(g, List.of(f, h, i));
		graph.put(h, List.of(a, b, g, i));
		graph.put(i, List.of(c, g, h));
		return graph;
	}

	private static Map<Key, Integer> createWeight() {
		Map<Key, Integer> weight = new HashMap<>();
		weight.put(new Key("a", "b"), 4);
		weight.put(new Key("a", "h"), 8);
		weight.put(new Key("b", "a"), 4);
		weight.put(new Key("b", "c"), 8);
		weight.put(new Key("b", "h"), 11);
		weight.put(new Key("c", "b"), 8);
		weight.put(new Key("c", "d"), 7);
		weight.put(new Key("c", "f"), 4);
		weight.put(new Key("c", "i"), 2);
		weight.put(new Key("d", "c"), 7);
		weight.put(new Key("d", "e"), 9);
		weight.put(new Key("d", "f"), 14);
		weight.put(new Key("e", "d"), 9);
		weight.put(new Key("e", "f"), 10);
		weight.put(new Key("f", "d"), 14);
		weight.put(new Key("f", "e"), 10);
		weight.put(new Key("f", "c"), 4);
		weight.put(new Key("f", "g"), 2);
		weight.put(new Key("g", "f"), 2);
		weight.put(new Key("g", "h"), 1);
		weight.put(new Key("g", "i"), 6);
		weight.put(new Key("h", "a"), 8);
		weight.put(new Key("h", "b"), 11);
		weight.put(new Key("h", "g"), 1);
		weight.put(new Key("h", "i"), 7);
		weight.put(new Key("i", "c"), 2);
		weight.put(new Key("i", "g"), 6);
		weight.put(new Key("i", "h"), 7);
		return weight;
	}

}
