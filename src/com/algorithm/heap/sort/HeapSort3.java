package com.algorithm.heap.sort;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HeapSort3 {
    public static void main(String[] args) {
	int A[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
	heapSort(A);
	IntStream.of(A).forEach(x -> System.out.print(x + " "));
	System.out.println();
	int B[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
	IntStream.of(B).forEach(x -> System.out.print(x + " "));
	System.out.println();
	List<Integer> C =IntStream.of(B).boxed().collect(Collectors.toList());
	Collections.sort(C);
	C.forEach(x -> System.out.print(x + " "));
    }

    private static void heapSort(int[] A) {
	int heapSize = A.length - 1;
	BUILD_MAX_HEAP(A, heapSize);
	for (int i = A.length - 1; i > 0; i--) {
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

    public static void MAX_HEAPIFY(int[] A, int i, int heapSize) {
	int l = LEFT(i);
	int r = RIGHT(i);
	int largest = i;
	if (l <= heapSize && A[l] > A[largest]) {
	    largest = l;
	}
	if (r <= heapSize && A[r] > A[largest]) {
	    largest = r;
	}
	if (largest != i) {
	    exchange(A, i, largest);
	    MAX_HEAPIFY(A, largest, heapSize);
	}
    }

    private static int RIGHT(int i) {
	return (2 * i) + 2;
    }

    private static int LEFT(int i) {
	return (2 * i) + 1;
    }

    private static void exchange(int[] A, int i, int largest) {
	int temp = A[i];
	A[i] = A[largest];
	A[largest] = temp;
    }
}
