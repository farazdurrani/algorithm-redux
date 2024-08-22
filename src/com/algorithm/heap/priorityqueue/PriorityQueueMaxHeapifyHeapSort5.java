package com.algorithm.heap.priorityqueue;

import java.util.stream.IntStream;

public class PriorityQueueMaxHeapifyHeapSort5 {
    static int heapSize;

    public static void main(String[] args) {
	int A[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
//	int A[] = { 13, -3, -25, 20, 7, 99, 12 };
	heapSort(A);
	print(A, "After sort");
	heapSize = A.length - 1;
	buildMaxHeapify(A, heapSize);
	print(A, "After building max heapify");
	heapSize = A.length - 1;
	print(new int[] { max(A) }, "Max Value");
	print(new int[] { extractMax(A) }, "Extract Max");
	print(new int[] { extractMax(A) }, "Extract Max");
	print(new int[] { extractMax(A) }, "Extract Max");
	print(A, "After extracting max");
	insert(A, 55);
	insert(A, 44);
	insert(A, 32);
	insert(A, 21);
	print(A, "After Inserting key");
	increaseKey(A, 0, 222);
	increaseKey(A, 1, 99);
	increaseKey(A, 2, 45);
	increaseKey(A, 6, 888888);
	print(A, "After Increasing keys");
    }

    private static void increaseKey(int[] a, int i, int key) {
	if (key < a[i]) {
	    System.err.println("new key is smaller than old key");
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

    private static void insert(int[] a, int key) {
	if (heapSize < 0) {
	    System.err.println("heap underflow");
	    return;
	}

	if (heapSize >= a.length - 1) {
	    System.err.println("heap overflow");
	    return;
	}

	heapSize++;
	a[heapSize] = Integer.MIN_VALUE;
	increaseKey(a, heapSize, key);
    }

    private static int extractMax(int[] a) {
	if (heapSize < 0) {
	    throw new RuntimeException("Stack underflow");
	}
	int max = max(a);
	swap(a, 0, heapSize);
	heapSize--;
	maxHeapify(a, 0, heapSize);
	return max;
    }

    private static void heapSort(int[] a) {
	int heapSize = a.length - 1;
	buildMaxHeapify(a, heapSize);
	for (int i = a.length - 1; i > 0; i--) {
	    swap(a, 0, i);
	    heapSize--;
	    maxHeapify(a, 0, heapSize);
	}
    }

    private static int max(int[] a) {
	return a[0];
    }

    private static void buildMaxHeapify(int[] a, int heapSize) {
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

    private static int right(int i) {
	return (2 * i) + 2;
    }

    private static int left(int i) {
	return (2 * i) + 1;
    }

    private static void swap(int[] a, int i, int j) {
	int temp = a[i];
	a[i] = a[j];
	a[j] = temp;
    }

    private static void print(int[] A, String msg) {
	System.out.println(msg);
	IntStream.of(A).forEach(x -> System.out.printf("%4d", x));
	System.out.println();
    }
}
