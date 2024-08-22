package com.algorithm.heap.sort;

import java.util.Arrays;

public class HeapSort5 {
    public static void main(String[] args) {
	String A[] = { "d", "c", "b", "a", "h", "g", "f", "e", "m", "l", "k", "j", "i", "p", "o", "n" };
	heapSort(A);
	Arrays.stream(A).forEach(x -> System.out.print(x + " "));
    }

    private static void heapSort(String[] A) {
	int heapSize = A.length - 1;
	buildMaxHeap(A, heapSize);
	for (int i = A.length - 1; i > 0; i--) {
	    exchange(A, 0, i);
	    heapSize -= 1;
	    maxHeapify(A, 0, heapSize);
	}
    }

    private static void buildMaxHeap(String[] a, int heapSize) {
	for (int i = a.length / 2; i > -1; i--) {
	    maxHeapify(a, i, heapSize);
	}
    }

    private static void maxHeapify(String[] a, int i, int heapSize) {
	//int parent = (i-1)/2
	int l = (2 * i) + 1;
	int r = (2 * i) + 2;
	int largest = i;
	if (l <= heapSize && a[l].compareTo(a[largest]) > 0) { // n > e, p > f
	    largest = l;
	}
	if (r <= heapSize && a[r].compareTo(a[largest]) > 0) { // o > p
	    largest = r;
	}
	if (i != largest) {
	    exchange(a, i, largest);
	    maxHeapify(a, largest, heapSize);
	}
    }

    private static void exchange(String[] a2, int a, int b) {
	String temp = a2[a];
	a2[a] = a2[b];
	a2[b] = temp;
    }



}
