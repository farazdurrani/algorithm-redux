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

public class PriorityQueueMaxHeapifyHeapSort9 {
    static int heapSize;
//	static int a[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
    static int A[] = { 13, -3, -25, 20, 7, 99, 12 };

    private static void print(int[] a, String msg) {
	System.out.println(msg);
	IntStream.of(a).forEach(x -> System.out.printf("%4d", x));
	System.out.println();
    }

    public static void main(String[] args) {
	heapSize = A.length - 1;
	print(A, "Before sort");
	heapSort(A);
	print(A, "After sort");
	heapSize = A.length - 1;
	buildHeap(A);
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
	heapSize++;
	if (heapSize > a.length - 1) {
	    System.out.println("Heap Overflow");
	    heapSize--;
	    return;
	}

	a[heapSize] = Integer.MIN_VALUE;
	increaseKey(a, key, heapSize);
    }

    private static void increaseKey(int[] a, int key, int i) {
	if (a[i] > key) {
	    System.out.println("Existing value is greater");
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
	    throw new RuntimeException("Stack underflow");
	}
	int max = max(a);
	swap(a, 0, heapSize);
	heapSize--;
	maintainHeap(a, 0);
	return max;
    }

    private static int max(int[] a) {
	return a[0];
    }

    private static void heapSort(int[] a) {
	buildHeap(a);
	for (int i = a.length; i > 0; i--) {// leave 0th as it as the largest value resides there after building
		 			    // max heap.
	    swap(a, 0, heapSize);
	    heapSize--;
	    maintainHeap(a, 0); // because now, an element at 0 might be breaking max-heap-property
	}
    }

    private static void buildHeap(int a[]) {
	for (int i = a.length / 2; i > -1; i--) {
	    maintainHeap(a, i);
	}
    }

    private static void maintainHeap(int[] a, int parent) {
	int lc = leftchild(parent);
	int rc = rightchild(parent);
	int largest = parent;
	if (lc <= heapSize && a[lc] > a[largest]) {
	    largest = lc;
	}

	if (rc <= heapSize && a[rc] > a[largest]) {
	    largest = rc;
	}
	if (largest != parent) {
	    swap(a, largest, parent);
	    maintainHeap(a, largest); //becaue the original parent index reside in largest variable after the swap.
	}
    }

    private static void swap(int[] a, int i, int j) {
	int temp = a[i];
	a[i] = a[j];
	a[j] = temp;

    }

    private static int rightchild(int parent) {
	return (2 * parent) + 2;
    }

    private static int leftchild(int parent) {
	return (2 * parent) + 1;
    }

}