package com.algorithm.sort.quick;

import java.security.SecureRandom;
import java.util.Arrays;

public class QuickSort3 {

    static SecureRandom rand = new SecureRandom();

    public static void main(String[] args) {
	int a[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
	Arrays.stream(a).forEach(x -> System.out.printf("%4d", x));
	System.out.println();

	quickSort(a, 0, a.length - 1);

	Arrays.stream(a).forEach(x -> System.out.printf("%4d", x));
	System.out.println();

	int b[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
	Arrays.stream(b).forEach(x -> System.out.printf("%4d", x));
	System.out.println();

	quickSortRandomized(b, 0, b.length - 1);

	Arrays.stream(b).forEach(x -> System.out.printf("%4d", x));
	System.out.println();
    }

    private static void quickSortRandomized(int[] a, int start, int end) {
	if (start < end) {
	    int randomPivot = randomizedPartition(a, start, end);
	    quickSortRandomized(a, start, randomPivot - 1);
	    quickSortRandomized(a, randomPivot + 1, end);
	}

    }

    private static int randomizedPartition(int[] a, int start, int end) {
	int i = rand.ints(start, end + 1).findFirst().getAsInt();
	swap(a, i, end);
	return partition(a, start, end);
    }

    private static void quickSort(int[] a, int start, int end) {
	if (start < end) {
	    int pivot = partition(a, start, end);
	    quickSort(a, start, pivot - 1);
	    quickSort(a, pivot + 1, end);
	}
    }

    private static int partition(int[] a, int start, int end) {
	int i = start - 1;
	for (int j = start; j < end; j++) {
	    if (a[j] <= a[end]) {
		i++;
		swap(a, i, j);
	    }
	}
	swap(a, i + 1, end);
	return i + 1;
    }

    private static void swap(int[] arr, int a, int b) {
	int temp = arr[a];
	arr[a] = arr[b];
	arr[b] = temp;

    }
}
