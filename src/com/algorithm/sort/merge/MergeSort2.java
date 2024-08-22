package com.algorithm.sort.merge;

import java.util.Arrays;

public class MergeSort2 {
    public static void main(String[] args) {
	int arr[] = {-1000, 8, 7, 6, 5, 4, 3, 2, 1, 0 , 5000};
	int low = 0;
	int high = arr.length - 1;
	mergeSort(arr, low, high);
	System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int low, int high) {
	if (low < high) {
	    int mid = (low + high) / 2;
	    mergeSort(arr, low, mid);
	    mergeSort(arr, mid + 1, high);
	    merge(arr, low, mid, high);
	}
    }

    private static void merge(int[] arr, int low, int mid, int high) {
	int n1 = mid - low + 1;
	int n2 = high - mid;
	int left[] = new int[n1];
	int right[] = new int[n2];
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
