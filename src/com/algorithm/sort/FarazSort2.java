package com.algorithm.sort;

import java.util.Arrays;

public class FarazSort2 {
    public static void main(String[] args) {

	int arr[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
	Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
	System.out.println();
	int heapSize = arr.length - 1;
	for (int i = 0; i < heapSize; i++, heapSize--) {
	    int[] indices = findMinMaxIndex(arr, i, heapSize);
	    int mixIndex = indices[0];
	    int maxIndex = indices[1];
	    swap(arr, i, mixIndex);
	    swap(arr, heapSize, maxIndex);
	}

	Arrays.stream(arr).forEach(x -> System.out.printf("%4d", x));
	System.out.println();

    }

    private static void swap(int[] arr, int a, int b) {
	int temp = arr[a];
	arr[a] = arr[b];
	arr[b] = temp;
    }

    private static int[] findMinMaxIndex(int[] arr, int start, int end) {
	int max = Integer.MIN_VALUE;
	int maxIndex = 0;
	int min = Integer.MAX_VALUE;
	int minIndex = 0;
	for (int i = start; i <= end; i++) {
	    if (arr[i] >= max) {
		max = arr[i];
		maxIndex = i;
	    }
	    if (min >= arr[i]) {
		min = arr[i];
		minIndex = i;
	    }
	}
	return new int[] { minIndex, maxIndex };
    }
}
