package com.algorithm.sort.insertion;

import java.util.Arrays;

public class InsertionSort13 {
    private static int arr[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };

    private static void print(int[] arr) {
	Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
	System.out.println();
    }

    public static void main(String[] args) {
	print(arr);
	for (int i = 1; i < arr.length; i++) {
	    int key = arr[i];
	    int j = i - 1;
	    while (j > -1 && arr[j] > key) {
		arr[j + 1] = arr[j];
		j = j - 1;
	    }
	    arr[j + 1] = key;
	}
	print(arr);
    }
}
