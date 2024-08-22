package com.algorithm.heap.sort;

import java.util.Arrays;
import java.util.stream.IntStream;

public class HeapSort7 {
    private static int heapSize;

    public static void main(String[] args) {
	int arr[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };

	System.out.println("Original Array");
	Arrays.stream(arr).forEach(x -> System.out.printf("%4d", x));
	System.out.println();

	heapSize = arr.length - 1;
	heapSort(arr);

	System.out.println("After Sorting: ");
	IntStream.of(arr).forEach(x -> System.out.printf("%4d", x));
	System.out.println();

    }

    private static void heapSort(int[] arr) {
	// 1st, build a heap
	buildHeap(arr);
	// visit each element from the bottom till the 0th element (not including)
	// swap it with 0th element (because in max-heap, the greatest value is at the
	// top)
	// decrease heapSize
	// maintain heap (because value at 0, might be violating max-heap-property
	for (int i = arr.length - 1; i > 0; i--) {
	    swap(arr, 0, i);
	    heapSize--;
	    maintainHeap(arr, 0);
	}
    }

    private static void buildHeap(int[] arr) {
	// build heap from mid, because last elements or
	// children will be taken care of when maintaining heap
	for (int i = arr.length / 2; i > -1; i--) {
	    maintainHeap(arr, i);
	}
    }

    private static void maintainHeap(int[] arr, int i) {
	// element at i in arr might be violating max-heap-property.
	// i is parent. we match with children, if they are bigger, gotta swap that and
	// find i's place
	// gotta fix that
	int left = left(i);
	int right = right(i);
	int largest = i; // assume parent is largest
	if (left <= heapSize && arr[left] > arr[largest]) {
	    largest = left;
	}
	if (right <= heapSize && arr[right] > arr[largest]) {
	    largest = right;
	}
	if (i != largest) {
	    swap(arr, largest, i);
	    maintainHeap(arr, largest);// because largest has the original parent value which has gone down the tree.
				       // still need to find it's place.
	}
    }

    private static void swap(int[] arr, int a, int b) {
	int temp = arr[a];
	arr[a] = arr[b];
	arr[b] = temp;
    }

    private static int right(int i) {
	return (2 * i) + 2;
    }

    private static int left(int i) {
	return (2 * i) + 1;
    }
}
