package com.algorithm.heap.minheap;

import java.util.stream.IntStream;

public class MinHeap1 {

	static int heapSize;
	static int a[] = {13, 3, 25, 20, 7, 99, 12};

	private static void print(int[] a, String msg) {
		System.out.println(msg);
		IntStream.of(a).forEach(x -> System.out.printf("%4d", x));
		System.out.println();
	}

	public static void main(String[] args) {
		heapSize = a.length - 1;
		heapSort(a);
		print(a, "After Sorting");
		heapSize = a.length - 1;
		buildMinHeap(a);
		print(a, "After Building Min Heap");
		print(new int[]{extractMin(a)}, "After extracting min");
		print(new int[]{extractMin(a)}, "After extracting min");
		print(new int[]{extractMin(a)}, "After extracting min");
		print(new int[]{extractMin(a)}, "After extracting min");
		print(new int[]{extractMin(a)}, "After extracting min");
		print(new int[]{extractMin(a)}, "After extracting min");
		print(new int[]{extractMin(a)}, "After extracting min");
		print(a, "After extracting mins 7 times");
		print(new int[]{heapSize}, "heapSize after extracting mins 7 times");
		insertKey(a, 7);
		insertKey(a, 6);
		insertKey(a, 5);
		insertKey(a, 4);
		insertKey(a, 3);
		insertKey(a, 2);
		insertKey(a, 1);
		print(a, "After inserting keys");
		print(new int[]{extractMin(a)}, "After extracting min");
		print(new int[]{extractMin(a)}, "After extracting min");
		print(new int[]{extractMin(a)}, "After extracting min");
		print(new int[]{extractMin(a)}, "After extracting min");
		print(new int[]{extractMin(a)}, "After extracting min");
		print(new int[]{extractMin(a)}, "After extracting min");
		print(new int[]{extractMin(a)}, "After extracting min");
		print(a, "After extracting mins 7 times");
		insertKey(a, 7);
		insertKey(a, 6);
		insertKey(a, 5);
		insertKey(a, 4);
		insertKey(a, 3);
		insertKey(a, 2);
		insertKey(a, 1);
		print(a, "After inserting keys");
		decreaseKey(a, -1, 0);
		print(a, "After decreaing key");
		decreaseKey(a, 5, 1);
		decreaseKey(a, 1, 6);
		print(a, "After decreaing key");
	}

	private static void insertKey(int[] a, int key) {
		if (heapSize >= -1 && heapSize < a.length) {
			heapSize++;
			a[heapSize] = Integer.MAX_VALUE;
			decreaseKey(a, key, heapSize);
		} else {
			System.out.println("Heap under/overflow");
		}
	}

	private static void decreaseKey(int[] a, int key, int index) {
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

	private static int parent(int child) {
		return (child - 1) / 2;
	}

	private static int extractMin(int[] a) {
		if (heapSize < 0) {
			throw new RuntimeException("Stack underflow");
		}
		int min = min(a);
		swap(a, 0, heapSize);
		heapSize--;
		maintainMinHeap(a, 0);
		return min;
	}

	private static int min(int[] aa) {
		return a[0];
	}

	private static void heapSort(int[] a) {
		buildMinHeap(a);
		for (int i = a.length - 1; i > 0; i--) {
			swap(a, 0, i);
			heapSize--;
			maintainMinHeap(a, 0);
		}
	}

	private static void buildMinHeap(int[] a) {
		for (int i = a.length / 2; i > -1; i--) {
			maintainMinHeap(a, i);
		}
	}

	private static void maintainMinHeap(int[] a, int parent) {
		int lc = left(parent);
		int rc = right(parent);
		int lowest = parent;
		if (lc <= heapSize && a[lc] < a[lowest]) {
			lowest = lc;
		}
		if (rc <= heapSize && a[rc] < a[lowest]) {
			lowest = rc;
		}
		if (lowest != parent) {
			swap(a, lowest, parent);
			maintainMinHeap(a, lowest);
		}
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	private static int right(int parent) {
		return (parent * 2) + 2;
	}

	private static int left(int parent) {
		return (parent * 2) + 1;
	}
}
