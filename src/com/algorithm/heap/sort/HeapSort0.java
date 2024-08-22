package com.algorithm.heap.sort;

import java.util.stream.IntStream;

public class HeapSort0 {
    public static void main(String[] args) {
	int arr[] = { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };

	BUILD_MAX_HEAP(arr);

	IntStream.of(arr).forEach(x -> System.out.print(x + " "));

    }

    private static void BUILD_MAX_HEAP(int[] arr) {
	int heap_size = arr.length - 1;
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
