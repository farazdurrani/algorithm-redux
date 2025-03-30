package com.algorithm.graph.singlesource.shortestpath.greedy;

import com.algorithm.graph.Edge;
import com.algorithm.graph.Vertex;

import java.util.*;

public class DijkstraAlgorithm {
  public static void main(String[] args) {
    Map<Vertex, List<Edge>> graph = getGraph();
    List<Vertex> shortestPaths = dijkstra(graph, graph.keySet().stream().findFirst().get());
    System.out.println(shortestPaths);
    printPath(vertex("s", graph), vertex("s", graph));
    System.out.println();
    printPath(vertex("s", graph), vertex("t", graph));
    System.out.println();
    printPath(vertex("s", graph), vertex("y", graph));
    System.out.println();
    printPath(vertex("s", graph), vertex("x", graph));
    System.out.println();
    printPath(vertex("s", graph), vertex("z", graph));
    System.out.println();
  }

  private static List<Vertex> dijkstra(Map<Vertex, List<Edge>> graph, Vertex source) {
    // initialize
    for (Vertex u : graph.keySet()) {
      u.key = Integer.MAX_VALUE - 100;
      u.p = null;
    }
    source.key = 0;
    //end initialize
    List<Vertex> list = new ArrayList<>();
    PriorityQueue<Vertex> q = new PriorityQueue<>(graph.keySet());
    while (!q.isEmpty()) {
      Vertex u = q.remove();
      list.add(u);
      for (Edge e : graph.get(u)) {
        Vertex v = e.destination;
        int w_uv = e.weight;
        // is 'v' part of the heap a.k.a is it visited yet?
        if (v.key > u.key + w_uv) {
          // relax
          v.key = u.key + w_uv;
          v.p = u;
          // end of relax
          //This is a min-priority-queue's decreaseKey substitute. Trust me! (Not in terms of performance though).
          q.remove(v);
          q.add(v);
        }
      }
    }
    return list;
  }

  private static void printPath(Vertex s, Vertex v) {
    if (s.label.equals(v.label)) {
      System.out.print(v.label + "/" + v.key + " ");
    } else if (v.p == null) {
      System.out.print("No path from " + s.label + " to " + v.label);
    } else {
      printPath(s, v.p);
      System.out.print(v.label + "/" + v.key + " ");
    }
  }

  private static Vertex vertex(String label, Map<Vertex, List<Edge>> graph) {
    return graph.keySet().stream().filter(v -> v.label.equals(label)).findFirst().get();
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
    graph.put(y, List.of(new Edge(y, t, 3), new Edge(y, z, 2), new Edge(y, x, 9)));
    graph.put(z, List.of(new Edge(z, s, 7), new Edge(z, x, 6)));
    return graph;
  }

  private static List<Vertex> getVertices() {
    return List.of(new Vertex("s"), new Vertex("t"), new Vertex("x"), new Vertex("y"), new Vertex("z"));
  }
}
