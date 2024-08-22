package com.algorithm.heap.priorityqueue;

import java.util.stream.IntStream;

public class MaxPriorityQueue8 {
    static int heapSize;

    private static void print(int[] A, String msg) {
	System.out.println(msg);
	IntStream.of(A).forEach(x -> System.out.printf("%4d", x));
	System.out.println();
    }

    public static void main(String[] args) {
//	int A[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
	int A[] = { 13, -3, -25, 20, 7, 99, 12 };
	heapSize = A.length - 1;
	print(A, "Before sort");
	heapSort(A);
	print(A, "After sort");
	heapSize = A.length - 1;
	buildMaxHeap(A);
	print(A, "After building max heapify");
	print(new int[] { max(A) }, "Max Value");
	extractMax(A);
	print(A, "After extracting max");
	extractMax(A);
	print(A, "After extracting max");
	extractMax(A);
	print(A, "After extracting max");
	extractMax(A);
	print(A, "After extracting max");
	extractMax(A);
	print(A, "After extracting max");
	extractMax(A);
	print(A, "After extracting max");
	extractMax(A);
	print(A, "After extracting max");
	try {
	    extractMax(A);
	    print(A, "After extracting max");
	} catch (Exception e) {
	    System.out.println("HeapSize is gone in reverse");
	}
	insertKey(A, 0);
	print(A, "After Inserting key");
	insertKey(A, 1);
	print(A, "After Inserting key");
	insertKey(A, 2);
	print(A, "After Inserting key");
	insertKey(A, 3);
	print(A, "After Inserting key");
	insertKey(A, 4);
	print(A, "After Inserting key");
	insertKey(A, 5);
	print(A, "After Inserting key");
	insertKey(A, 6);
	print(A, "After Inserting key");
	insertKey(A, 7);
	increaseKey(A, 222, 0);
	print(A, "After Increasing keys");
	increaseKey(A, 99, 1);
	print(A, "After Increasing keys");
	increaseKey(A, 45, 2);
	print(A, "After Increasing keys");
	increaseKey(A, 888888, 6);
	print(A, "After Increasing keys");

	heapSort(A);
	print(A, "After Sort");
    }

    private static void insertKey(int[] a, int key) {
	if (heapSize < a.length - 1) {
	    heapSize++;
	    a[heapSize] = Integer.MIN_VALUE;
	    increaseKey(a, heapSize, key);
	} else {
	    System.out.println("No space in an array as arrays are fixed size");
	}
    }

    private static void increaseKey(int[] a, int key, int index) {
	if (a[index] > key) {
	    System.out.println("Value that's present is already bigger than the key");
	    return;
	}
	a[index] = key;
	while (index > -1 && a[parent(index)] < a[index]) {
	    swap(a, parent(index), index);
	    index = parent(index);
	}
    }

    private static int extractMax(int[] a) {
	if (heapSize < 0) {
	    throw new RuntimeException("Heap Underflow");
	}

	int max = max(a);
	swap(a, 0, heapSize);
	heapSize--;
	maintainMaxHeapProperty(a, 0);
	return max;
    }

    private static int max(int[] a) {
	return a[0];
    }

    private static void heapSort(int[] arr) {
	buildMaxHeap(arr);
	print(arr, "After Building Heap");
	for (int i = arr.length - 1; i > 0; i--) { // leave 0th as it as the largest value resides there after building
						   // max heap.
	    swap(arr, 0, i);
	    heapSize--;
	    maintainMaxHeapProperty(arr, 0); // because an element at 0 might be breaking max-heap-property
	}
    }

    private static void maintainMaxHeapProperty(int[] arr, int parent) {
	int leftChild = left(parent);
	int rightChild = right(parent);
	int largest = parent; // assume
	if (leftChild <= heapSize && arr[leftChild] > arr[largest]) {
	    largest = leftChild;
	}
	if (rightChild <= heapSize && arr[rightChild] > arr[largest]) {
	    largest = rightChild;
	}
	if (parent != largest) {
	    swap(arr, largest, parent);
	    maintainMaxHeapProperty(arr, largest);
	}

    }

    private static void swap(int[] arr, int first, int second) {
	int temp = arr[first];
	arr[first] = arr[second];
	arr[second] = temp;

    }

    private static void buildMaxHeap(int[] arr) {
	for (int i = arr.length / 2; i > -1; i--) {
	    maintainMaxHeapProperty(arr, i);
	}
    }

    static int left(int i) {
	return (2 * i) + 1;
    }

    static int right(int i) {
	return (2 * i) + 2;
    }

    static int parent(int i) {
	return (i - 1) / 2;
    }
}
