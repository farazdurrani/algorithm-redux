package com.algorithm.sort.insertion;

import java.util.Arrays;

public class InsertionSort2 {
    public static void main(String[] args) {
	int arr[] = {-2, 7, 6, 5, 4, 3, 2, 1, 100 };
	insertionSort(arr);
	System.out.println(Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {
	for (int i = 1; i < arr.length; i++) {
	    int key = arr[i];
	    int j = i - 1;
	    while (j > -1 && arr[j] > key) {
		arr[j + 1] = arr[j];
		j--;
	    }
	    arr[j + 1] = key;
	}
    }
}
