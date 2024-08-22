package com.algorithm.sort.quick;

import java.util.Arrays;
import java.util.Random;

public class QuickSort11 {
    private static int a[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };

    private static void print(int[] arr) {
	Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
	System.out.println();
    }

    public static void main(String[] args) {
	print(a);
	int start = 0;
	int end = a.length - 1;
	qs(start, end);
	print(a);
    }

    private static void qs(int start, int end) {
	if (start < end) {
	    int pivot = partition(start, end);
	    qs(start, pivot - 1);
	    qs(pivot + 1, end);
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
	return i+1;
    }

    private static void swap(int i, int j) {
	int temp = a[i];
	a[i] = a[j];
	a[j] = temp;
    }

}
