package com.algorithm.heap.priorityqueue;

import java.util.stream.IntStream;

//Notes:
//    maintainHeapProperty:
//	This function is called on an element at i that might be violating max-heap property.
//	Meaning, element at A[i] might be smaller than left or right child.

//    buildMaxHeap:
//	Build max heap in a bottom up manner by calling maintainHeapProperty. But instead of starting from A.length - 1, 
//	start from mid till the first element. Because children will be traversed by maintainHeapProperty.

//    heapSort:
//	first, buildMaxHeap. Now, the largest value is sitting in the first position. 
//	second, start the for loop from the bottom till the 2nd element in the array, 
//		swap the first element with the last, 
//		shrink the heapSize, 
//		call maintainHeapProperty on the first element (because first element might be breaching max-heap-property).
public class PriorityQueueMaxHeapifyHeapSort7 {
    static int heapSize;

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

    private static void insertKey(int[] arr, int key) {
	if (heapSize < arr.length - 1) {
	    heapSize++;
	    arr[heapSize] = Integer.MIN_VALUE;
	    increaseKey(arr, key, heapSize);
	} else {
	    System.out.println("Heap Overflow");
	}
    }

    private static void increaseKey(int[] arr, int key, int i) {
	if (arr[i] > key) {
	    System.out.println("Existing key is larger than new key");
	    return;
	}
	arr[i] = key;
	while (i > -1 && arr[parent(i)] < arr[i]) {
	    swap(arr, parent(i), i);
	    i = parent(i);
	}
    }

    private static int extractMax(int[] arr) {
	if (heapSize < 0) {
	    throw new RuntimeException("Stack underflow");
	}
	int max = max(arr);
	swap(arr, 0, heapSize);
	heapSize--;
	maintainMaxHeapProperty(arr, 0);
	return max;
    }

    private static int max(int[] arr) {
	return arr[0];
    }

    private static void print(int[] A, String msg) {
	System.out.println(msg);
	IntStream.of(A).forEach(x -> System.out.printf("%4d", x));
	System.out.println();
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
