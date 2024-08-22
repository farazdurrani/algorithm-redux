package com.algorithm.sort.quick;

import java.util.Arrays;
import java.util.Random;

public class QuickSort4 {
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

    private static void quickSortRandomized(int[] b, int start, int end) {
	if(start < end) {
	    int pivot = randomizedPivot(b, start, end);
	    quickSortRandomized(b, start, pivot - 1);
	    quickSortRandomized(b, pivot + 1, end);
	}
    }
    
    static Random rand = new Random();

    private static int randomizedPivot(int[] b, int start, int end) {
	int i = rand.ints(start, end + 1).findFirst().getAsInt();
	swap(b, i, end);
	return partition(b, start, end);
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
		i = i + 1;
		swap(a, i, j);
	    }
	}
	swap(a, i + 1, end);
	return i + 1;
    }

    private static void swap(int[] a, int first, int last) {
	int temp = a[first];
	a[first] = a[last];
	a[last] = temp;
    }
}
