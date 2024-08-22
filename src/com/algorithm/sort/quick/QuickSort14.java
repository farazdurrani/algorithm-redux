package com.algorithm.sort.quick;

import java.util.Arrays;

public class QuickSort14 {
    private static int a[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4,
        7 };

    private static void print(int[] arr) {
	Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
	System.out.println();
    }

    public static void main(String[] args) {
	print(a);
	int start = 0;
	int end = a.length - 1;
	quickSort(start, end);
	print(a);
    }

    private static void quickSort(int start, int end) {
	if (start < end) {
	    int pivot = partition(start, end);
	    quickSort(start, pivot - 1);
	    quickSort(pivot + 1, end);
	}
    }

    private static int partition(int start, int end) {
	int pivot = a[end];
	int i = start - 1;
	for (int j = start; j < end; j++) {
	    if (a[j] < pivot) {
		i++;
		swap(i, j);
	    }
	}
	swap(i+1, end);
	return i + 1;
    }

    private static void swap(int i, int j) {
	int temp = a[i];
	a[i] = a[j];
	a[j] = temp;
    }

}