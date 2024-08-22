package com.algorithm.graph.transpose;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.algorithm.graph.Vertex;

public class Transpose {
	public static void main(String[] args) {
		Map<Vertex, List<Vertex>> graph = new LinkedHashMap<>();

		graph.put(new Vertex("a"), List.of(new Vertex("b")));
		graph.put(new Vertex("b"), List.of(new Vertex("c"), new Vertex("e"), new Vertex("f")));
		graph.put(new Vertex("c"), List.of(new Vertex("d"), new Vertex("g")));
		graph.put(new Vertex("d"), List.of(new Vertex("c"), new Vertex("h")));
		graph.put(new Vertex("e"), List.of(new Vertex("a"), new Vertex("f")));
		graph.put(new Vertex("f"), List.of(new Vertex("g")));
		graph.put(new Vertex("g"), List.of(new Vertex("h"), new Vertex("f")));
		graph.put(new Vertex("h"), List.of(new Vertex("h")));

		System.out.println("Graph ->");
		graph.forEach((k, v) -> System.out.println(k + " | " + v));
		System.out.println("Transposed Graph ->");
		Map<Vertex, List<Vertex>> graphT = transpose(graph);
		graphT.forEach((k, v) -> System.out.println(k + " | " + v));
	}

	public static Map<Vertex, List<Vertex>> transpose(Map<Vertex, List<Vertex>> graph) {
		Map<Vertex, List<Vertex>> graphT = new LinkedHashMap<>();
		for (Vertex u : graph.keySet()) {
			for (Vertex v : graph.get(u)) {
				List<Vertex> list = graphT.getOrDefault(v, new ArrayList<>());
				list.add(u);
				graphT.put(v, list);
			}
		} 
		return graphT;
	}
}
