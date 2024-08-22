package com.algorithm.sort.merge;

import java.util.Arrays;

public class MergeSort13 {
    private static int a[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };

    private static void print(int[] arr) {
	Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
	System.out.println();
    }

    public static void main(String[] args) {
	print(a);

	int low = 0;
	int high = a.length - 1;
	mergeSort(low, high);

	print(a);
    }

    private static void mergeSort(int low, int high) {
	if (low < high) {
	    int mid = (low + high) / 2;
	    mergeSort(low, mid);
	    mergeSort(mid + 1, high);
	    merge(low, mid, high);
	}
    }

    private static void merge(int low, int mid, int high) {
	int n1 = mid + 1 - low;
	int n2 = high - mid;
	int[] left = new int[n1];
	int[] right = new int[n2];

	for (int i = 0; i < n1; i++) {
	    left[i] = a[low + i];
	}

	for (int i = 0; i < n2; i++) {
	    right[i] = a[mid + 1 + i];
	}
	
	int i = 0, j = 0, k = low;
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
	while(i < n1) {
	    a[k] = left[i];
	    i++;
	    k++;
	}
	while(j < n2) {
	    a[k] = right[j];
	    j++;
	    k++;
	}

    }

}
