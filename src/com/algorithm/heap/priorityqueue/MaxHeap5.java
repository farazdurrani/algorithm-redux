package com.algorithm.heap.priorityqueue;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

public class MaxHeap5 {

    static int heapSize;

    public static void main(String[] args) {
	int a[] = { 13, -3, -25, 20, 7, 99, 12 };
	System.out.println("Original Array");
	Arrays.stream(a).forEach(x -> System.out.printf("%4d", x));
	System.out.println();

	heapSort(a);
	System.out.println("After Sorting: ");
	IntStream.of(a).forEach(x -> System.out.printf("%4d", x));
	System.out.println();

	heapSize = a.length - 1;
	buildMaxHeap(a, heapSize);
	print(a, "After building max heapify");
	print(new int[] { max(a) }, "Max Value");
	print(new int[] { extractMax(a) }, "Extract Max");
	print(new int[] { extractMax(a) }, "Extract Max");
	print(new int[] { extractMax(a) }, "Extract Max");
	print(a, "After extracting max");
	insert(a, 55);
	insert(a, 44);
	insert(a, 32);
	insert(a, Integer.MAX_VALUE);
	print(a, "After Inserting key");
	increaseKey(a, 0, 222);
	increaseKey(a, 1, 99);
	increaseKey(a, 2, 45);
	increaseKey(a, 6, 888888);
	print(a, "After Increasing keys");

    }

    private static void insert(int[] a, int key) {
	if (heapSize < 0) {
	    System.err.println("Heap Underflow");
	    return;
	}

	if (heapSize >= a.length - 1) {
	    System.err.println("Heap Overflow");
	    return;
	}
	heapSize++;
	a[heapSize] = Integer.MIN_VALUE;
	increaseKey(a, heapSize, key);
    }

    private static void increaseKey(int[] a, int i, int key) {
	if (key < a[i]) {
	    System.err.println("new key is smaller than prev key");
	    return;
	}
	a[i] = key;
	while (i > -1 && a[parent(i)] < a[i]) {
	    swap(a, parent(i), i);
	    i = parent(i);
	}
    }

    private static int parent(int i) {
	return (i - 1) / 2;
    }

    private static int extractMax(int[] a) {
	if (heapSize < 0) {
	    throw new NoSuchElementException();
	}

	int max = max(a);
	swap(a, 0, heapSize);
	heapSize--;
	maxHeapify(a, 0, heapSize);

	return max;
    }

    private static int max(int[] a) {
	return a[0];
    }

    private static void print(int[] A, String msg) {
	System.out.println(msg);
	IntStream.of(A).forEach(x -> System.out.printf("%4d", x));
	System.out.println();
    }

    private static void heapSort(int[] a) {
	int heapSize = a.length - 1;
	buildMaxHeap(a, heapSize);
	for (int i = a.length - 1; i > 0; i--) {
	    swap(a, 0, i);
	    heapSize--;
	    maxHeapify(a, 0, heapSize);
	}
    }

    private static void buildMaxHeap(int[] a, int heapSize) {
	for (int i = a.length / 2; i > -1; i--) {
	    maxHeapify(a, i, heapSize);
	}
    }

    private static void maxHeapify(int[] a, int i, int heapSize) {
	int l = left(i);
	int r = right(i);
	int largest = i;
	if (l <= heapSize && a[l] > a[largest]) {
	    largest = l;
	}
	if (r <= heapSize && a[r] > a[largest]) {
	    largest = r;
	}
	if (i != largest) {
	    swap(a, largest, i);
	    maxHeapify(a, largest, heapSize);
	}
    }

    private static void swap(int[] a, int first, int second) {
	int temp = a[first];
	a[first] = a[second];
	a[second] = temp;
    }

    private static int right(int i) {
	return (2 * i) + 2;
    }

    private static int left(int i) {
	return (2 * i) + 1;
    }
}
