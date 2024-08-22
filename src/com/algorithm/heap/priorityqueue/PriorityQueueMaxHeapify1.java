package com.algorithm.heap.priorityqueue;

import java.security.SecureRandom;
import java.util.Random;
import java.util.stream.IntStream;

public class PriorityQueueMaxHeapify1 {

    static int heapSizeForExtracting;

    public static void main(String[] args) {

	int A[] = { 13, -3, -25, 20, 7, 99,12 };
//	int A[] = { 13, -3, 20, 7 };
	heapSort(A);
	System.out.println("After Sorting");
	IntStream.of(A).forEach(x -> System.out.print(x + " "));
	System.out.println();
	int heapSize = A.length - 1;
	heapSizeForExtracting = A.length - 1;
	buildMaxHeap(A, heapSize);
	System.out.println("After building Heap");
	IntStream.of(A).forEach(x -> System.out.print(x + " "));
	System.out.println();
	System.out.println("HEAP MAXINUM " + heapMaximum(A));
	IntStream.of(A).forEach(x -> System.out.printf("%4d", x));
	System.out.println();
	increaseKey(A, 4, 21);
	IntStream.of(A).forEach(x -> System.out.printf("%4d", x));
	System.out.println();
	increaseKey(A, 3, 15);
	IntStream.of(A).forEach(x -> System.out.printf("%4d", x));
	System.out.println();
	for (int i = 0; i < 7; i++) {
	    System.out.println("Extract Heap Max " + extractHeapMax(A));
	}
	System.out.println("Inserting keys into Heap");
	SecureRandom random = new SecureRandom();
	for (int i = 0; i < 7; i++) {
	    maxHeapInsert(A, random.nextInt(99));
	    IntStream.of(A).forEach(x -> System.out.printf("%4d", x));
	    System.out.println();
	}
    }

    private static void maxHeapInsert(int[] A, int key) {
	heapSizeForExtracting += 1;
	A[heapSizeForExtracting] = Integer.MIN_VALUE;
	increaseKey(A, heapSizeForExtracting, key);

    }

    private static void increaseKey(int[] A, int i, int key) {
	if (key < A[i]) {
	    throw new RuntimeException("key being increased is lower than the original one");
	}
	A[i] = key;
	while (i > -1 && A[parent(i)] < A[i]) {
	    exchange(A, i, parent(i));
	    i = parent(i);
	}
    }

    private static int parent(int i) {
	return (i - 1) / 2;
    }

    private static int extractHeapMax(int[] A) {
	if (heapSizeForExtracting < 0) {
	    throw new RuntimeException("Stack underflow");
	}
	int max = heapMaximum(A);
	exchange(A, 0, heapSizeForExtracting);
	heapSizeForExtracting -= 1;
	maxHeapify(A, 0, heapSizeForExtracting);
	return max;
    }

    public static void heapSort(int[] A) {
	int heapSize = A.length - 1;
	buildMaxHeap(A, heapSize);
	for (int i = A.length - 1; i > 0; i--) {
	    exchange(A, 0, i);
	    heapSize -= 1;
	    maxHeapify(A, 0, heapSize);
	}
    }

    private static void buildMaxHeap(int[] A, int heapSize) {
	for (int i = A.length / 2; i > -1; i--) {
	    maxHeapify(A, i, heapSize);
	}
    }

    private static void maxHeapify(int[] A, int i, int heapSize) {
	int l = left(i);
	int r = right(i);
	int largest = i;
	if (l <= heapSize && A[l] > A[largest]) {
	    largest = l;
	}
	if (r <= heapSize && A[r] > A[largest]) {
	    largest = r;
	}
	if (largest != i) {
	    exchange(A, largest, i);
	    maxHeapify(A, largest, heapSize);
	}
    }

    private static int left(int i) {
	return (2 * i) + 1;
    }

    private static int right(int i) {
	return (2 * i) + 2;
    }

    private static void exchange(int[] A, int a, int b) {
	int temp = A[a];
	A[a] = A[b];
	A[b] = temp;
    }

    public static int heapMaximum(int[] A) {
	return A[0];
    }
}
