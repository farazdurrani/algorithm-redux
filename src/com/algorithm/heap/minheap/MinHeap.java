package com.algorithm.heap.minheap;

import java.util.stream.IntStream;

public class MinHeap {

  private final int[] initializedArray;
  private int initializedHeapSize;

  public MinHeap(int[] array) {
    initializedArray = array;
    initializedHeapSize = array.length - 1;
  }

  private static void print(int[] a, String msg) {
    System.out.println(msg);
    IntStream.of(a).forEach(x -> System.out.printf("%4d", x));
    System.out.println();
  }

  public static void main(String[] args) {
    int[] defaultArray = {13, 3, 25, 20, 7, 99, 12};
    MinHeap heap = new MinHeap(defaultArray);
    int[] a = heap.initializedArray;
    heap.heapSort(a);
    print(a, "After Sorting");
    heap.initializedHeapSize = a.length - 1;
    heap.buildMinHeap(a);
    print(a, "After Building Min Heap");
    print(new int[]{heap.extractMin(a)}, "After extracting min");
    print(new int[]{heap.extractMin(a)}, "After extracting min");
    print(new int[]{heap.extractMin(a)}, "After extracting min");
    print(new int[]{heap.extractMin(a)}, "After extracting min");
    print(new int[]{heap.extractMin(a)}, "After extracting min");
    print(new int[]{heap.extractMin(a)}, "After extracting min");
    print(new int[]{heap.extractMin(a)}, "After extracting min");
    print(a, "After extracting mins 7 times");
    print(new int[]{heap.initializedHeapSize}, "heapSize after extracting mins 7 times");
    heap.insertKey(a, 7);
    heap.insertKey(a, 6);
    heap.insertKey(a, 5);
    heap.insertKey(a, 4);
    heap.insertKey(a, 3);
    heap.insertKey(a, 2);
    heap.insertKey(a, 1);
    print(a, "After inserting keys");
    print(new int[]{heap.extractMin(a)}, "After extracting min");
    print(new int[]{heap.extractMin(a)}, "After extracting min");
    print(new int[]{heap.extractMin(a)}, "After extracting min");
    print(new int[]{heap.extractMin(a)}, "After extracting min");
    print(new int[]{heap.extractMin(a)}, "After extracting min");
    print(new int[]{heap.extractMin(a)}, "After extracting min");
    print(new int[]{heap.extractMin(a)}, "After extracting min");
    print(a, "After extracting mins 7 times");
    heap.insertKey(a, 7);
    heap.insertKey(a, 6);
    heap.insertKey(a, 5);
    heap.insertKey(a, 4);
    heap.insertKey(a, 3);
    heap.insertKey(a, 2);
    heap.insertKey(a, 1);
    print(a, "After inserting keys");
    heap.decreaseKey(a, -1, 0);
    print(a, "After decreaing key");
    heap.decreaseKey(a, 5, 1);
    heap.decreaseKey(a, 1, 6);
    print(a, "After decreaing key");
  }

  private int min(int[] a) {
    return a[0];
  }

  private void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  private int right(int parent) {
    return (parent * 2) + 2;
  }

  private int left(int parent) {
    return (parent * 2) + 1;
  }

  public void insertKey(int[] a, int key) {
    if (initializedHeapSize >= -1 && initializedHeapSize < a.length) {
      initializedHeapSize++;
      a[initializedHeapSize] = Integer.MAX_VALUE;
      decreaseKey(a, key, initializedHeapSize);
    } else {
      System.out.println("Heap under/overflow");
    }
  }

  public void decreaseKey(int[] a, int key, int index) {
    if (a[index] < key) {
      System.out.println("Existing key is already smaller");
      return;
    }
    a[index] = key;
    while (index > -1 && a[parent(index)] > a[index]) {
      swap(a, parent(index), index);
      index = parent(index);
    }
  }

  private int parent(int child) {
    return (child - 1) / 2;
  }

  public int extractMin(int[] a) {
    if (initializedHeapSize < 0) {
      throw new RuntimeException("Stack underflow");
    }
    int min = min(a);
    swap(a, 0, initializedHeapSize);
    initializedHeapSize--;
    maintainMinHeap(a, 0);
    return min;
  }

  private void heapSort(int[] a) {
    buildMinHeap(a);
    for (int i = a.length - 1; i > 0; i--) {
      swap(a, 0, i);
      initializedHeapSize--;
      maintainMinHeap(a, 0);
    }
  }

  private void buildMinHeap(int[] a) {
    for (int i = a.length / 2; i > -1; i--) {
      maintainMinHeap(a, i);
    }
  }

  private void maintainMinHeap(int[] a, int parent) {
    int lc = left(parent);
    int rc = right(parent);
    int lowest = parent;
    if (lc <= initializedHeapSize && a[lc] < a[lowest]) {
      lowest = lc;
    }
    if (rc <= initializedHeapSize && a[rc] < a[lowest]) {
      lowest = rc;
    }
    if (lowest != parent) {
      swap(a, lowest, parent);
      maintainMinHeap(a, lowest);
    }
  }
}
