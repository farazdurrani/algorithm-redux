package com.algorithm.heap.priorityqueue;

import java.util.stream.IntStream;
//Notes:
//maintainHeapProperty:
//	This function is called on an element at i that might be violating max-heap property.
//	Meaning, element at A[i] might be smaller than left or right child.

//buildMaxHeap:
//	Build max heap in a bottom up manner by calling maintainHeapProperty. But instead of starting from A.length - 1, 
//	start from mid till the first element. Because children will be traversed by maintainHeapProperty.

//heapSort:
//	first, buildMaxHeap. Now, the largest value is sitting in the first position. 
//	second, start the for loop from the bottom till the 2nd element in the array, 
//		swap the first element with the heapSize, 
//		shrink the heapSize, 
//		call maintainHeapProperty on the first element (because first element might be breaching max-heap-property).

public class PriorityQueueMaxHeapifyHeapSort12 {
    static int heapSize;
//	static int a[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
    static int a[] = { 13, -3, -25, 20, 7, 99, 12 };

    private static void print(int[] a, String msg) {
	System.out.println(msg);
	IntStream.of(a).forEach(x -> System.out.printf("%4d", x));
	System.out.println();
    }

    public static void main(String[] args) {
	heapSize = a.length - 1;
	// increase key
	// insert key
	// buildheap
	// maintainheap
	// max
	// extract max
	heapSize = a.length - 1;
	print(a, "Before sort");
	heapSort();
	print(a, "After sort");
	heapSize = a.length - 1;
	buildHeap();
	print(a, "After building max heapify");
	print(new int[] { max() }, "Max Value");
	extractMax();
	print(a, "After extracting max");
	extractMax();
	print(a, "After extracting max");
	extractMax();
	print(a, "After extracting max");
	extractMax();
	print(a, "After extracting max");
	extractMax();
	print(a, "After extracting max");
	extractMax();
	print(a, "After extracting max");
	extractMax();
	print(a, "After extracting max");
	try {
	    extractMax();
	    print(a, "After extracting max");
	} catch (Exception e) {
	    System.out.println("HeapSize is gone in reverse");
	}
	insertKey(0);
	print(a, "After Inserting key");
	insertKey(1);
	print(a, "After Inserting key");
	insertKey(2);
	print(a, "After Inserting key");
	insertKey(3);
	print(a, "After Inserting key");
	insertKey(4);
	print(a, "After Inserting key");
	insertKey(5);
	print(a, "After Inserting key");
	insertKey(6);
	print(a, "After Inserting key");
	insertKey(7);
	increaseKey(222, 0);
	print(a, "After Increasing keys");
	increaseKey(99, 1);
	print(a, "After Increasing keys");
	increaseKey(45, 2);
	print(a, "After Increasing keys");
	increaseKey(888888, 6);
	print(a, "After Increasing keys");
	heapSort();
	print(a, "After Sort");

    }

    private static void insertKey(int key) {
	heapSize++;
	if (heapSize < a.length) {
	    a[heapSize] = Integer.MIN_VALUE;
	    increaseKey(key, heapSize);
	} else {
	    heapSize--;
	    System.out.println("Heapoverflow");
	}
    }

    private static void increaseKey(int key, int pos) {
	if (a[pos] > key) {
	    System.out.println("Existing key is greater than");
	    return;
	}
	a[pos] = key;
	while (pos > -1 && a[parent(pos)] < key) {
	    swap(parent(pos), pos);
	    pos = parent(pos);
	}
    }

    private static int parent(int pos) {
	return (pos - 1) / 2;
    }

    private static void extractMax() {
	swap(0, heapSize);
	heapSize--;
	maintainHeap(0);
    }

    private static int max() {
	return a[0];
    }

    private static void heapSort() {
	buildHeap();
	for (int i = a.length - 1; i > 0; i--) {
	    swap(0, i);
	    heapSize--;
	    maintainHeap(0);
	}
    }

    private static void buildHeap() {
	for (int i = a.length / 2; i > -1; i--) {
	    maintainHeap(i);
	}
    }

    private static void maintainHeap(int parent) {
	int l = left(parent);
	int r = right(parent);
	int largest = parent;
	if (l <= heapSize && a[l] > a[largest]) {
	    largest = l;
	}
	if (r <= heapSize && a[r] > a[largest]) {
	    largest = r;
	}
	if (largest != parent) {
	    swap(largest, parent);
	    maintainHeap(largest);
	}
    }

    private static int right(int parent) {
	return (2 * parent) + 2;
    }

    private static int left(int parent) {
	return (2 * parent) + 1;
    }

    private static void swap(int i, int j) {
	int temp = a[i];
	a[i] = a[j];
	a[j] = temp;
    }

}