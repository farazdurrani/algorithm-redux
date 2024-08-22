package com.algorithm.sort.quick;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuickSort2 {
    
    static Random rand = new Random();
    
    public static void main(String[] args) {
	Collections.sort(List.of(1,2,3));
	int a[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
	Arrays.stream(a).forEach(x -> System.out.printf("%4d", x));
	System.out.println();

	int start = 0;
	int end = a.length - 1;
	quickSort(a, start, end);

	Arrays.stream(a).forEach(x -> System.out.printf("%4d", x));
	System.out.println();

	int b[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
	Arrays.stream(b).forEach(x -> System.out.printf("%4d", x));
	System.out.println();
	randomizedQuickSort(b, start, end);

	Arrays.stream(b).forEach(x -> System.out.printf("%4d", x));
	System.out.println();
    }

    private static void randomizedQuickSort(int[] b, int start, int end) {
	if (start < end) {
	    int pivot = randomizedPartition(b, start, end);
	    randomizedQuickSort(b, start, pivot - 1);
	    randomizedQuickSort(b, pivot + 1, end);
	}
    }

    private static int randomizedPartition(int[] b, int start, int end) {
	int i = random(start, end);
	swap(b, i, end);
	return partition(b, start, end);
    }

    private static int random(int start, int end) {
	return rand.ints(start, end + 1).findFirst().getAsInt();
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

    private static void swap(int[] a, int i, int j) {
	int temp = a[i];
	a[i] = a[j];
	a[j] = temp;
    }
}
