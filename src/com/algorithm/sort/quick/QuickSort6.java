package com.algorithm.sort.quick;

import java.util.Arrays;

public class QuickSort6 {
    public static void main(String[] args) {
	int arr[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
	Arrays.stream(arr).forEach(x -> System.out.printf("%4d", x));
	System.out.println();

	int start = 0;
	int end = arr.length - 1;
	quickSort(arr, start, end);
	
	Arrays.stream(arr).forEach(x -> System.out.printf("%4d", x));
	System.out.println();

    }

    private static void quickSort(int[] arr, int start, int end) {
	if (start < end) {
	    int pivot = partition(arr, start, end);
	    quickSort(arr, start, pivot - 1);
	    quickSort(arr, pivot + 1, end);
	}
    }

    private static int partition(int[] arr, int start, int end) {
	int pivot = arr[end];
	int i = start - 1;
	for (int j = start; j < end; j++) {
	    if (arr[j] < pivot) {
		i++;
		swap(arr, i, j);
	    }
	}
	swap(arr, i + 1, end);
	return i + 1;
    }

    private static void swap(int[] arr, int a, int b) {
	int temp = arr[a];
	arr[a] = arr[b];
	arr[b] = temp;
    }
}
