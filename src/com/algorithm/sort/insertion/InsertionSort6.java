package com.algorithm.sort.insertion;

import java.util.stream.IntStream;

public class InsertionSort6 {
    public static void main(String[] args) {
	int arr[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };

	for(int i = 1; i < arr.length; i++) {
	    int key = arr[i];
	    int j = i - 1;
	    while(j > -1 && arr[j] > key) {
		arr[j+1] =arr[j];
		j = j - 1;
	    }
	    arr[j+1] = key;
	}
	IntStream.of(arr).forEach(x -> System.err.print(x + ", "));
    }
}
