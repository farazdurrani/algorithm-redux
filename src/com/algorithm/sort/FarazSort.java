package com.algorithm.sort;

import java.util.Arrays;

/**
 * Turns out, this is a variation of SelectionSort. 
 * @author Faraz
 *
 */
public class FarazSort {
    
    public static void main(String[] args) {

	int arr[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
	Arrays.stream(arr).forEach(x -> System.out.printf("%4d", x));
	System.out.println();

	int heapSize = arr.length - 1;
	int comp = 0;
	for (int i = 0; i < arr.length; i++) {
	    comp++;
	    int maxIndex = findMaxIndex(arr, heapSize);
	    swap(arr, heapSize, maxIndex);
	    heapSize--;
	}

	Arrays.stream(arr).forEach(x -> System.out.printf("%4d", x));
	System.out.println();
	System.out.println("Number of comparisons: " + comp);

    }

    private static void swap(int[] arr, int a, int b) {
	int temp = arr[a];
	arr[a] = arr[b];
	arr[b] = temp;
    }

    private static int findMaxIndex(int[] a, int heapSize) {
	int max = Integer.MIN_VALUE;
	int index = 0;
	for (int i = 0; i <= heapSize; i++) {
	    if (a[i] > max) {
		max = a[i];
		index = i;
	    }
	}
	return index;
    }
}
