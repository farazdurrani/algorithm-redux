package com.algorithm.heap.sort;

import java.util.stream.IntStream;

public class HeapSort4 {

    public static void main(String[] args) {
	int A[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
	heapSort(A);
	IntStream.of(A).forEach(x -> System.out.print(x + " "));
    }

    private static void heapSort(int[] A) {
	int heapSize = A.length - 1;
	BUILD_MAX_HEAP(A, heapSize);
	for (int i = A.length - 1; i > 0; i--) {
	    //we will operate on 0th index
	    exchange(A, 0, i);
	    heapSize -= 1;
	    MAX_HEAPIFY(A, 0, heapSize);
	}
    }

    private static void BUILD_MAX_HEAP(int[] A, int heapSize) {
	for (int i = A.length / 2; i > -1; i--) {
	    MAX_HEAPIFY(A, i, heapSize);
	}
    }

    private static void MAX_HEAPIFY(int[] A, int i, int heapSize) {
	int l = left(i);
	int r = right(i);
	int largest = i;
	if (l <= heapSize && A[l] > A[largest]) {
	    largest = l;
	}
	if (r <= heapSize && A[r] > A[largest]) {
	    largest = r;
	}
	if (i != largest) {
	    exchange(A, i, largest);
	    MAX_HEAPIFY(A, largest, heapSize);
	}
    }

    private static void exchange(int[] arr, int a, int b) {
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

    private static int parent(int i) {
	return (i - 1) / 2;
    }

    private static int leftWhenOneBased(int i) {
	return 2 * i;
    }

    private static int rightWhenOneBased(int i) {
	return (2 * i) + 1;
    }

    private static int parentWhenOneBased(int i) {
	return i / 2;
    }
}
