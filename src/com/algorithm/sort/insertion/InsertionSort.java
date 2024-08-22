package com.algorithm.sort.insertion;

import java.util.stream.IntStream;

public class InsertionSort {
    public static void main(String[] args) {
	int arr[]= {9,8,7,6,5,4,3,2,1,0};

	
	System.out.println("\nBefore Sorting");
	IntStream.of(arr).forEach(System.out::print);
	insertionSort(arr);
	System.out.println("\nAfter Sorting");
	IntStream.of(arr).forEach(System.out::print);
	
    }

    private static void insertionSort(int[] arr) {
	for(int i = 1; i < arr.length; i++) {
	    int key = arr[i];
	    int j = i - 1;
	    while(j > -1 && arr[j] > key) {
		arr[j+1] = arr[j];
		j = j - 1;
	    }
	    arr[j + 1] = key;
	}
	
    }

}
