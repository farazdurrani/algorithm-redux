package com.algorithm.sort.merge;

import java.util.Arrays;

public class MergeSort3 {
    public static void main(String[] args) {
	int arr[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
	Arrays.stream(arr).forEach(x -> System.out.print(x + ", "));
	System.out.println();

	int low = 0;
	int high = arr.length - 1;
	mergeSortDAC(arr, low, high);
	Arrays.stream(arr).forEach(x -> System.out.print(x + ", "));
	
    }

    private static void mergeSortDAC(int[] arr, int low, int high) {
	if (low < high) {
	    int mid = (low + high) / 2;
	    mergeSortDAC(arr, low, mid);
	    mergeSortDAC(arr, mid + 1, high);
	    mergeDAC(arr, low, mid, high);
	}
    }

    private static void mergeDAC(int[] arr, int low, int mid, int high) {
	int n1 = mid + 1 - low;
	int n2 = high - mid;
	int[] left = new int[n1];
	int[] right = new int[n2];
	for (int i = 0; i < n1; i++) {
	    left[i] = arr[low + i];
	}

	for (int j = 0; j < n2; j++) {
	    right[j] = arr[mid + 1 + j];
	}

	int k = low;
	int i = 0;
	int j = 0;
	while (i < n1 && j < n2) {
	    if (left[i] <= right[j]) {
		arr[k] = left[i];
		i++;
	    } else {
		arr[k] = right[j];
		j++;
	    }
	    k++;
	}
	while (i < n1) {
	    arr[k] = left[i];
	    i++;
	    k++;
	}
	while (j < n2) {
	    arr[k] = right[j];
	    j++;
	    k++;
	}

    }
}
