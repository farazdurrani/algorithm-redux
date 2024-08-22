package com.algorithm.heap.sort;

import java.util.stream.IntStream;

public class HeapSort {
    public static void main(String[] args) {
	int A[] = {4,1,3,2,16,9,10,14,8,7};
	heapSort(A);
	
    }

    private static void heapSort(int[] A) {
	int heap_size = A.length - 1;
	BUILD_MAX_HEAP(A, heap_size);	
	for(int i = A.length - 1; i > 0; i--) {
	    exchange(A, 0, i);
	    heap_size -= 1; 
	    MAX_HEAPIFY(A, 0, heap_size);
	}
	IntStream.of(A).forEach(x -> System.out.print(x + " "));
    }
    
    private static void BUILD_MAX_HEAP(int[] arr, int heap_size) {	
	for (int i = (arr.length / 2); i > -1; i--) {
	    MAX_HEAPIFY(arr, i, heap_size);
	}
    }

    private static void MAX_HEAPIFY(int[] arr, int i, int heap_size) {
	int l = LEFT(i);
	int r = RIGHT(i);
	int largest = i;
	if (l <= heap_size && arr[l] > arr[i]) {
	    largest = l;
	}
	if (r <= heap_size && arr[r] > arr[largest]) {
	    largest = r;
	}
	if (largest != i) {
	    exchange(arr, largest, i);
	    MAX_HEAPIFY(arr, largest, heap_size);
	}

    }

    private static void exchange(int[] arr, int largest, int i) {
	int temp = arr[largest];
	arr[largest] = arr[i];
	arr[i] = temp;
    }

    private static int RIGHT(int i) {
	return (2 * i) + 2;
    }

    private static int LEFT(int i) {
	return (2 * i) + 1;
    }

    private static int PARENT(int i) {
	return (i - 1) / 2;
    }
}
