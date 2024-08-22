package com.algorithm.heap.sort;

import java.util.Arrays;

public class HeapSort6 {
    public static void main(String[] args) {
	int a[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
	Arrays.stream(a).forEach(x -> System.out.print(x + " "));
	System.out.println();
	heapSort(a);
	Arrays.stream(a).forEach(x -> System.out.print(x + " "));
	System.out.println();
    }

    private static void heapSort(int[] a) {
	int heapSize = a.length - 1;
	buildMaxHeapify(a, heapSize);
	for (int i = a.length - 1; i > 0; i--) {
	    exchange(a, 0, i);
	    heapSize -= 1;
	    maintainHeap(a, 0, heapSize);
	}
    }

    private static void maintainHeap(int[] a, int i, int heapSize) {
	int l = left(i);
	int r = right(i);
	int largest = i;
	if(l <= heapSize && a[l] > a[largest]) {
	    largest = l;
	}
	if(r <= heapSize && a[r] > a[largest]) {
	    largest = r;
	}
	if(i != largest) {
	    exchange(a, largest, i);
	    maintainHeap(a, largest, heapSize);
	}
	    
    }

    private static int right(int i) {
	return (2*i) + 2;
    }

    private static int left(int i) {
	return (2*i) + 1;
    }

    private static void exchange(int[] a, int f, int l) {
	int temp = a[f];
	a[f] = a[l];
	a[l] = temp;
    }

    private static void buildMaxHeapify(int[] a, int heapSize) {
	for (int i = a.length / 2; i > -1; i--) {
	    maintainHeap(a, i, heapSize);
	}
    }
}
