package com.algorithm.heap.priorityqueue;

import java.util.stream.IntStream;

public class PriorityQueueMaxHeapify2 {

    static int heapSize;

    public static void main(String[] args) {
	int A[] = { 13, -3, -25, 20, 7, 99, 12 };
	heapSort(A);
	print(A, "After sort");
	heapSize = A.length - 1;
	buildMaxHeapify(A, heapSize);	
	heapSize= A.length - 1;
	print(new int[] {max(A)}, "Max Value");
	print(new int[] {extractMax(A)}, "Extract Max");
	print(new int[] {extractMax(A)}, "Extract Max");
	print(new int[] {extractMax(A)}, "Extract Max");
	print(A, "After extracting max");
	insert(A, 55);
	insert(A, 44);
	insert(A, 32);
	insert(A, 21);
	print(A, "After Inserting key");
	increaseKey(A,0,222);
	increaseKey(A,1,99);
	increaseKey(A,2,45);
	increaseKey(A,6,888888);
	print(A, "After Increasing keys");
	

    }

    private static void insert(int[] A, int key) {
	if(heapSize < 0) {
	    System.out.println("Heap is empty");
	    return;
	}
	if(heapSize == A.length-1) {
	    System.out.println("Heap is full");
	    return;
	}
	heapSize += 1;
	A[heapSize] = Integer.MIN_VALUE;
	increaseKey(A, heapSize, key);
    }

    private static void increaseKey(int[] A, int i, int key) {
	if(A[i] > key) {
	    System.out.println("existing key is bigger than new key");
	    return;
	}
	A[i] = key;
	while(i > -1 && A[parent(i)] < A[i]) {
	    exchange(A, parent(i), i);
	    i = parent(i);
	}
    }

    private static void print(int[] A, String msg) {
	System.out.println(msg);
	IntStream.of(A).forEach(x -> System.out.printf("%4d", x));
	System.out.println();
    }

    private static int extractMax(int[] A) {
	if(heapSize < 0) {
	   throw new RuntimeException("Stack underflow");
	}
	int max = max(A);
	exchange(A, 0, heapSize);
	heapSize -= 1;
	maxHeapify(A, 0, heapSize);
	return max;
    }

    private static int max(int[] A) {
	return A[0];
    }

    private static void heapSort(int[] A) {
	int heapSize = A.length - 1;
	buildMaxHeapify(A, heapSize);
	for (int i = A.length - 1; i > 0; i--) {
	    exchange(A, 0, i);
	    heapSize -= 1;
	    maxHeapify(A, 0, heapSize);
	}
    }

    private static void buildMaxHeapify(int[] A, int heapSize) {
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

    private static void exchange(int[] A, int a, int b) {
	int temp = A[a];
	A[a] = A[b];
	A[b] = temp;
    }

    private static int left(int i) {
	return (2 * i) + 1;
    }

    private static int right(int i) {
	return (2 * i) + 2;
    }

    private static int parent(int i) {
	return (i - 1) / 2;
    }
}
