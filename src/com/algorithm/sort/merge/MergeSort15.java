package com.algorithm.sort.merge;

import java.util.Arrays;

public class MergeSort15 {
    private static int a[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };

    private static void print(int[] arr) {
	Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
	System.out.println();
    }

    public static void main(String[] args) {
	print(a);
	int low = 0;
	int high = a.length - 1;
	mergerSort(a, low, high);
	print(a);
    }

    private static void mergerSort(int[] a, int low, int high) {
	if (low < high) {
	    int mid = (low + high) / 2;
	    mergerSort(a, low, mid);
	    mergerSort(a, mid + 1, high);
	    merge(a, low, mid, high);
	}
    }

    private static void merge(int[] a, int low, int mid, int high) {
	int n1 = mid + 1 - low;
	int n2 = high - mid;
	int left[] = new int[n1];
	int right[] = new int[n2];
	for (int i = 0; i < n1; i++) {
	    left[i] = a[low + i];
	}

	for (int j = 0; j < n2; j++) {
	    right[j] = a[mid + 1 + j];
	}

	int i = 0, j = 0;
	int k = low;

	while (i < n1 && j < n2) {
	    if (left[i] < right[j]) {
		a[k] = left[i];
		i++;
	    } else {
		a[k] = right[j];
		j++;
	    }
	    k++;
	}

	// copy remaining items
	while (i < n1) {
	    a[k] = left[i];
	    i++;
	    k++;
	}

	while (j < n2) {
	    a[k] = right[j];
	    j++;
	    k++;
	}
    }

}