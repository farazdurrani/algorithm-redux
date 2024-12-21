package com.algorithm.heap.minheap;

import com.algorithm.graph.Vertex;

import java.util.Arrays;
import java.util.Collection;

public class GenericMinPriorityQueue<E extends Comparable<E>> {

  private final Node<E>[] storage;
  private int heapSize;

  public GenericMinPriorityQueue(E[] array) {
    this.storage = Arrays.stream(array).map(Node<E>::new).toArray(Node[]::new);
    this.heapSize = array.length - 1;
  }

  public GenericMinPriorityQueue(Collection<E> c) {
    this.storage = c.stream().map(Node<E>::new).toArray(Node[]::new);
    this.heapSize = c.size() - 1;
  }

  public static void main(String[] args) {
    Vertex a = new Vertex("a", 13);
    Vertex b = new Vertex("b", 3);
    Vertex c = new Vertex("c", 25);
    Vertex d = new Vertex("d", 20);
    Vertex e = new Vertex("e", 7);
    Vertex f = new Vertex("f", 99);
    Vertex g = new Vertex("g", 12);
    Vertex[] defaultArray = new Vertex[]{a, b, c, d, e, f, g};
    GenericMinPriorityQueue<Vertex> heap = new GenericMinPriorityQueue<>(defaultArray);
    heap.heapSort();
    heap.print("After Sorting", heap.storage);
    heap.heapSize = heap.storage.length - 1;
    heap.buildMinHeap();
    heap.print("After Building Min Heap", heap.storage);
    heap.print("After extracting min", new Node<>(heap.extractMin()));
    heap.print("After extracting min", new Node<>(heap.extractMin()));
    heap.print("After extracting min", new Node<>(heap.extractMin()));
    heap.print("After extracting min", new Node<>(heap.extractMin()));
    heap.print("After extracting min", new Node<>(heap.extractMin()));
    heap.print("After extracting min", new Node<>(heap.extractMin()));
    heap.print("After extracting min", new Node<>(heap.extractMin()));
    heap.print("After extracting min 7 times", heap.storage);
    heap.insertKey(new Vertex(7));
    heap.insertKey(new Vertex(6));
    heap.insertKey(new Vertex(5));
    heap.insertKey(new Vertex(4));
    heap.insertKey(new Vertex(3));
    heap.insertKey(new Vertex(2));
    heap.insertKey(new Vertex(1));
    heap.print("After inserting keys", heap.storage);
    heap.print("After extracting min", new Node<>(heap.extractMin()));
    heap.print("After extracting min", new Node<>(heap.extractMin()));
    heap.print("After extracting min", new Node<>(heap.extractMin()));
    heap.print("After extracting min", new Node<>(heap.extractMin()));
    heap.print("After extracting min", new Node<>(heap.extractMin()));
    heap.print("After extracting min", new Node<>(heap.extractMin()));
    heap.print("After extracting min", new Node<>(heap.extractMin()));
    heap.print("After extracting min 7 times", heap.storage);
    heap.insertKey(new Vertex(7));
    heap.insertKey(new Vertex(6));
    heap.insertKey(new Vertex(5));
    heap.insertKey(new Vertex(4));
    heap.insertKey(new Vertex(3));
    heap.insertKey(new Vertex(2));
    heap.insertKey(new Vertex(1));
    heap.print("After inserting keys", heap.storage);
    heap.decreaseKey(new Vertex(-1), 0);
    heap.print("After decreaing key", heap.storage);
    heap.decreaseKey(new Vertex(5), 1);
    heap.decreaseKey(new Vertex(1), 6);
    heap.print("After decreaing key", heap.storage);
  }

  private void print(String msg, Node<E>... a) {
    System.out.println(msg);
    Arrays.stream(a).forEach(x -> System.out.printf("%4s", x));
    System.out.println();
  }

  private Node<E> min() {
    return storage[0];
  }

  private void swap(int i, int j) {
    Node<E> temp = storage[i];
    storage[i] = storage[j];
    storage[j] = temp;
  }

  private int right(int parent) {
    return (parent * 2) + 2;
  }

  private int left(int parent) {
    return (parent * 2) + 1;
  }

  public void insertKey(E key) {
    if (heapSize >= -1 && heapSize < storage.length) {
      heapSize++;
      storage[heapSize].data = null;
      decreaseKey(key, heapSize);
    } else {
      System.out.println("Heap under/overflow");
    }
  }

  public void decreaseKey(E key, int index) {
    if (storage[index] != null && storage[index].data != null && storage[index].data.compareTo(key) < 0) {
      System.out.println("Existing key is already smaller");
      return;
    }
    storage[index] = new Node<>(key);
    while (index > -1 && storage[parent(index)].data.compareTo(storage[index].data) > 0) {
      swap(parent(index), index);
      index = parent(index);
    }
  }

  public void decreaseKey() {
    buildMinHeap();
  }

  private int parent(int child) {
    return (child - 1) / 2;
  }

  public E extractMin() {
    if (heapSize < 0) {
      throw new RuntimeException("Stack underflow");
    }
    Node<E> min = min();
    swap(0, heapSize);
    heapSize--;
    maintainMinHeap(0);
    return min.data;
  }

  private void heapSort() {
    buildMinHeap();
    for (int i = storage.length - 1; i > 0; i--) {
      swap(0, i);
      heapSize--;
      maintainMinHeap(0);
    }
  }

  private void buildMinHeap() {
    for (int i = storage.length / 2; i > -1; i--) {
      maintainMinHeap(i);
    }
  }

  private void maintainMinHeap(int parent) {
    int lc = left(parent);
    int rc = right(parent);
    int lowest = parent;
    if (lc <= heapSize && storage[lc].data.compareTo(storage[lowest].data) < 0) {
      lowest = lc;
    }
    if (rc <= heapSize && storage[rc].data.compareTo(storage[lowest].data) < 0) {
      lowest = rc;
    }
    if (lowest != parent) {
      swap(lowest, parent);
      maintainMinHeap(lowest);
    }
  }

  public boolean isEmpty() {
    return heapSize < 0;
  }

  public Object[] getAll() {
    return Arrays.stream(this.storage).map(n -> n.data).toArray();
  }

  public boolean contains(E e) {
    for (int i = 0; i < heapSize; i++) {
      if (storage[i].data.compareTo(e) == 0) {
        return true;
      }
    }
    return false;
  }
}
