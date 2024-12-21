package com.algorithm.graph.minimumspanningtree.greedy;

import com.algorithm.graph.Vertex;

import java.util.*;

/**
 * @author faraz
 * <p>
 * *         From Generic-MST 1) set A is always acyclic 2) set A cannot add
 * duplicate edges. When these 2 conditions don't match any longer, we
 * have a MST. The MST will always have V-1. The total edges will be
 * V-1.
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class PrimsAlgorithm {
  public static void main(String[] args) {

    Map<Vertex, List<Vertex>> graph = prepareGraph();

    print(graph);

    Map<Key, Integer> weights = createWeight();

    System.out.println("Prim's Algorithm");

    // using a random vertex as root
    Vertex r = graph.keySet().stream().filter(v -> v.label.equals("a")).findFirst().get();

    primAlgorithm(graph, weights, r);

    Vertex v = graph.keySet().stream().filter(vertex -> vertex.label.equals("e")).findFirst().get();
    System.out.println("\n\"route\" from " + r.label + " to " + v.label);
    print(r, v);
    v = graph.keySet().stream().filter(vertex -> vertex.label.equals("f")).findFirst().get();
    System.out.println("\n\"route\" from " + r.label + " to " + v.label);
    print(r, v);
    v = graph.keySet().stream().filter(vertex -> vertex.label.equals("h")).findFirst().get();
    System.out.println("\n\"route\" from " + r.label + " to " + v.label);
    print(r, v);
  }

  private static void primAlgorithm(Map<Vertex, List<Vertex>> graph, Map<Key, Integer> weights, Vertex r) {
    // initialize
    for (Vertex u : graph.keySet()) {
      u.key = Integer.MAX_VALUE;
      u.p = null;
    }
    r.key = 0;
    // end of initialize
    PriorityQueue<Vertex> q = new PriorityQueue<>(graph.keySet());
    while (!q.isEmpty()) {
      alphabetSort(q); //this is not part of the algo. Just have it to match the book's tracking.
      Vertex u = q.poll();
      System.out.print(u.label + " ");
      for (Vertex v : graph.get(u)) {
        Key key = new Key(u.label, v.label);
        int w_uv = weights.get(key);
        if (q.contains(v) && v.key > w_uv) {
          // Update: There's no way original min-priority-queue would ever expose decrease key to the outside world.
          // Even if we did, we would not know the index to it. And if we were to find that out, which is easy to
          // figure out no doubt, the performance of it would be worse than just deleting and adding it back.
          // Regardless, I implemented a generic min-priority-queue and learned the hard way why decreaseKey
          // operation is not public.
          // Original: since we need to do the decrease key operation, which is not provided by the
          // java.util.PriorityQueue library, we resort to and suffice by removing the key and then adding
          // it back with the new decreased value. It does maintain the min-heap property.
          q.remove(v);
          v.p = u;
          v.key = w_uv;
          q.add(v);
        }
      }
    }
  }

  private static void print(Vertex s, Vertex v) {
    if (s.label.equals(v.label)) {
      System.out.print(s.label + " ");
    } else if (v.p == null) {
      System.out.println("No connection from " + s.label + " to " + v.label);
    } else {
      print(s, v.p);
      System.out.print(v.label + " ");
    }
  }

  /**
   * Data from the book in perfect order!
   */
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
    graph.put(f, List.of(c, d, e, g));
    graph.put(g, List.of(f, h, i));
    graph.put(h, List.of(a, b, g, i));
    graph.put(i, List.of(c, g, h));
    return graph;
  }

  /**
   * Weights from the book.
   */
  private static Map<Key, Integer> createWeight() {
    Map<Key, Integer> weight = new LinkedHashMap<>();
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
    weight.put(new Key("f", "c"), 4);
    weight.put(new Key("f", "d"), 14);
    weight.put(new Key("f", "e"), 10);
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

  private static void alphabetSort(PriorityQueue<Vertex> q) {
    Vertex[] arr = q.toArray(new Vertex[0]);
    boolean change = false;
    for (int i = 1; i < arr.length; i++) {
      if (arr[0].key == arr[i].key && arr[0].label.charAt(0) > arr[i].label.charAt(0)) {
        Vertex temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;
        change = true;
      }
    }
    if (change) {
      q.clear();
      Collections.addAll(q, arr);
    }
  }

  private static void print(Map<Vertex, List<Vertex>> graph) {
    System.out.println("Graph -> ");
    graph.forEach((k, v) -> {
      System.out.print(k.label + " [ ");
      v.forEach(_v -> System.out.print(_v.label + " "));
      System.out.println("]");
    });
  }

}
