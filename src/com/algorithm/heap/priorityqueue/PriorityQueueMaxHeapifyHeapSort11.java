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

public class PriorityQueueMaxHeapifyHeapSort11 {
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
	print(a, "Before sort");
	heapSort(a);
	print(a, "After sort");
	heapSize = a.length - 1;
	buildHeap(a);
	print(a, "After building max heapify");
	print(new int[] { max(a) }, "Max Value");
	extractMax(a);
	print(a, "After extracting max");
	extractMax(a);
	print(a, "After extracting max");
	extractMax(a);
	print(a, "After extracting max");
	extractMax(a);
	print(a, "After extracting max");
	extractMax(a);
	print(a, "After extracting max");
	extractMax(a);
	print(a, "After extracting max");
	extractMax(a);
	print(a, "After extracting max");
	try {
	    extractMax(a);
	    print(a, "After extracting max");
	} catch (Exception e) {
	    System.out.println("HeapSize is gone in reverse");
	}
	insertKey(a, 0);
	print(a, "After Inserting key");
	insertKey(a, 1);
	print(a, "After Inserting key");
	insertKey(a, 2);
	print(a, "After Inserting key");
	insertKey(a, 3);
	print(a, "After Inserting key");
	insertKey(a, 4);
	print(a, "After Inserting key");
	insertKey(a, 5);
	print(a, "After Inserting key");
	insertKey(a, 6);
	print(a, "After Inserting key");
	insertKey(a, 7);
	increaseKey(a, 222, 0);
	print(a, "After Increasing keys");
	increaseKey(a, 99, 1);
	print(a, "After Increasing keys");
	increaseKey(a, 45, 2);
	print(a, "After Increasing keys");
	increaseKey(a, 888888, 6);
	print(a, "After Increasing keys");
	heapSort(a);
	print(a, "After Sort");
    }

    private static void increaseKey(int[] a, int key, int index) {
	if (a[index] > key) {
	    System.out.println("Existing value already bigger");
	    return;
	}
	a[index] = key;
	while (index > -1 && a[parent(index)] < a[index]) {
	    swap(a, parent(index), index);
	    index = parent(index);
	}
    }

    private static int parent(int index) {
	return (index - 1) / 2;
    }

    private static void insertKey(int[] a, int key) {
	if (heapSize < a.length - 1) {
	    heapSize++;
	    a[heapSize] = Integer.MIN_VALUE;
	    increaseKey(a, key, heapSize);
	} else {
	    System.out.println("Heap under/overflow: heap size " + heapSize);
	}
    }

    private static void extractMax(int[] a) {
	swap(a, 0, heapSize);
	heapSize--;
	maintainHeap(a, 0);
    }

    private static int max(int[] a) {
	return a[0];
    }

    private static void buildHeap(int[] a) {
	for (int i = a.length / 2; i > -1; i--) {
	    maintainHeap(a, i);
	}
    }

    private static void maintainHeap(int[] a, int parent) {
	int left = left(parent);
	int right = right(parent);
	int largest = parent;
	if (left <= heapSize && a[left] > a[largest]) {
	    largest = left;
	}
	if (right <= heapSize && a[right] > a[largest]) {
	    largest = right;
	}
	if (largest != parent) {
	    swap(a, largest, parent);
	    maintainHeap(a, largest);
	}
    }

    private static void swap(int[] a, int i, int j) {
	int temp = a[i];
	a[i] = a[j];
	a[j] = temp;
    }

    private static int right(int parent) {
	return (2 * parent) + 2;
    }

    private static int left(int parent) {
	return (2 * parent) + 1;
    }

    private static void heapSort(int[] a) {
	buildHeap(a);
	for (int i = a.length - 1; i > 0; i--) {
	    swap(a, 0, i);
	    heapSize--;
	    maintainHeap(a, 0);
	}
    }

}