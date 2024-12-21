package com.algorithm.heap.minheap;

public class Node<E> {
  E data;

  public Node(E data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return data.toString();
  }
}
