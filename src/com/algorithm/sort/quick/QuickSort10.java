package com.algorithm.sort.quick;

import java.util.Arrays;
import java.util.Random;

public class QuickSort10 {
    private static int a[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };

    private static void print(int[] arr) {
	Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
	System.out.println();
    }
    public static void main(String[] args) {
	int start = 0;
	int end = a.length - 1;
	quickSort(a, start, end);
	print(a);
	a = new int[] {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 }; 
	quickSortR(a, start, end);
	print(a);
    }

    private static void quickSortR(int[] a, int start, int end) {
	if (start < end) {
	    int pivot = rPartition(a, start, end);
	    quickSort(a, start, pivot - 1);
	    quickSort(a, pivot + 1, end);
	}
    }
    private static int rPartition(int[] a, int start, int end) {
	int i = new Random().ints(start, end + 1).findFirst().getAsInt();
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
	int key = a[end];
	for (int j = start; j < end; j++) {
	    if (a[j] < key) {
		i++;
		swap(a, i, j);
	    }
	}
	swap(a, i + 1, end);
	return i + 1;
    }

    private static void swap(int[] a, int i, int j) {
	int t = a[i];
	a[i] = a[j];
	a[j] = t;
    }

}
