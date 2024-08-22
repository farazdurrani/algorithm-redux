package com.algorithm.heap.sort;

import java.util.stream.IntStream;

public class HeapSort2 {
    public static void main(String[] args) {
	int A[] = {4,1,3,2,16,9,10,14,8,7};
	heapSort(A);
	IntStream.of(A).forEach(x -> System.out.print(x + " "));
    }

    private static void heapSort(int[] A) {
	int heapSize = A.length - 1;
	BUILD_MAX_HEAP(A, heapSize);
	for(int i = A.length - 1; i > 0; i--) {
	    exchange(A, 0, i);
	    heapSize -= 1;
	    MAX_HEAPIFY(A, 0, heapSize);
	}	
    }
    
    private static void BUILD_MAX_HEAP(int[] A, int heapSize) {
	for(int i = (A.length) / 2; i > -1; i--) {
	    MAX_HEAPIFY(A, i, heapSize);
	}
    }

    private static void MAX_HEAPIFY(int[] A, int i, int heapSize) {
	int l = LEFT(i);
	int r = RIGHT(i);
	int largest = i;
	if(l <= heapSize && A[l] > A[i]) {
	    largest = l;
	}
	if(r <= heapSize && A[r] > A[largest]) {
	    largest = r;
	}
	if(largest != i) {
	    exchange(A, i, largest);
	    MAX_HEAPIFY(A, largest, heapSize);
	}
    }

    private static int RIGHT(int i) {
	return (2*i) + 2;
    }

    private static int LEFT(int i) {
	return (2*i) + 1;
    }
    
    private static int PARENT(int i) {
	return (i-1) / 2;
    }

    private static void exchange(int[] A, int i, int i2) {
	int temp = A[i];
	A[i] = A[i2];
	A[i2] = temp;
	
    }
}
