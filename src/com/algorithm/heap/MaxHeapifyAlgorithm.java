package com.algorithm.heap;

import java.util.Arrays;

public class MaxHeapifyAlgorithm {
    public static void main(String[] args) {
	int[] arr = { 16, 4, 10, 14, 7, 9, 3, 2, 8, 1 };
	int heap_size = arr.length-1;
	MAX_HEAPIFY(arr, 1, heap_size);
	Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
    }

    private static void MAX_HEAPIFY(int[] arr, int i, int heap_size) {
	int l = LEFT(i);
	int r = RIGHT(i);
	int largest = i;
	if( l <= heap_size && arr[l] > arr[i]) {
	    largest = l;
	}
	if(r <= heap_size && arr[r] > arr[largest]) {
	    largest = r;
	}
	if(largest != i) {
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
	return (2*i) + 2;
    }

    private static int LEFT(int i) {	
	return (2*i) + 1;
    }
    
    private static int PARENT(int i) {
	return (i-1)/2;
    }
}
