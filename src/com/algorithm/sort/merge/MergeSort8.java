package com.algorithm.sort.merge;

import java.util.Arrays;

public class MergeSort8 {
    public static void main(String[] args) {
	int a[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
	Arrays.stream(a).forEach(x -> System.out.print(x + " "));
	System.out.println();

	int low = 0;
	int high = a.length - 1;
	mergeSort(a, low, high);
	
	Arrays.stream(a).forEach(x -> System.out.print(x + " "));
	System.out.println();
    }

    private static void mergeSort(int[] a, int low, int high) {
	if (low < high) {
	    int mid = (low + high) / 2;
	    mergeSort(a, low, mid);
	    mergeSort(a, mid + 1, high);
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

	int i = 0;
	int j = 0;
	int k = low;
	while (i < n1 && j < n2) {
	    if (left[i] <= right[j]) {
		a[k] = left[i];
		i++;
	    } else {
		a[k] = right[j];
		j++;
	    }
	    k++;
	}

	while (i < n1) {
	    a[k] = left[i];
	    i++;
	    k++;
	}

	while (j < n2) {
	    a[k] = right[j];
	    k++;
	    j++;
	}
    }
}
