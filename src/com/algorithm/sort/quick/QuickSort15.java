package com.algorithm.sort.quick;

import java.util.Arrays;
import java.util.Random;

public class QuickSort15 {
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

	int b[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
	print(b);
	quickSortRandomized(b, start, end);
	print(b);
    }

    private static void quickSortRandomized(int[] b, int start, int end) {
	if (start < end) {
	    int pivot = randomizedPartition(b, start, end);
	    quickSortRandomized(b, start, pivot - 1);
	    quickSortRandomized(b, pivot + 1, end);
	}
    }

    private static int randomizedPartition(int[] b, int start, int end) {
	int rand = new Random().ints(start, end + 1).findAny().getAsInt();
	swap(b, rand, end);
	return partition(b, start, end);
    }

    private static int partition(int[] b, int start, int end) {
	int i = start - 1;
	int pivot = b[end];
	for (int j = start; j < end; j++) {
	    if (b[j] > pivot) {
		i++;
		swap(b, i, j);
	    }
	}
	swap(b, i + 1, end);
	return i + 1;
    }

    private static void swap(int[] b, int i, int j) {
	int temp = b[i];
	b[i] = b[j];
	b[j] = temp;
    }

    private static void quickSort(int start, int end) {
	if (start < end) {
	    int pivot = partition(start, end);
	    quickSort(start, pivot - 1);
	    quickSort(pivot + 1, end);
	}
    }

    private static int partition(int start, int end) {
	int i = start - 1;
	int pivot = a[end];
	for (int j = start; j < end; j++) {
	    if (a[j] > pivot) {
		i++;
		swap(i, j);
	    }
	}
	swap(i + 1, end);
	return i + 1;
    }

    private static void swap(int i, int j) {
	int t = a[i];
	a[i] = a[j];
	a[j] = t;
    }

}