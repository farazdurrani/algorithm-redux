package com.algorithm.sort.quick;

import java.util.Arrays;
import java.util.Random;

public class QuickSort9 {
    private static int arr[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };

    private static void print(int[] arr) {
	Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
	System.out.println();
    }

    public static void main(String[] args) {
	print(arr);
	int start = 0;
	int end = arr.length - 1;
	quickSort(arr, start, end);
	print(arr);
	arr = new int[]{ 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
	quickSortRandomizedPivot(arr, start, end);
	print(arr);
    }

    private static void quickSortRandomizedPivot(int[] arr, int start, int end) {
	if(start < end) {
	    int randomPivot = randomizedPivot(arr, start, end);
	    quickSortRandomizedPivot(arr, start, randomPivot - 1);
	    quickSortRandomizedPivot(arr, randomPivot + 1, end);
	}
    }

    private static int randomizedPivot(int[] arr, int start, int end) {
	int randomPosition = random(start, end);
	swap(arr,randomPosition, end);
	return partition(arr, start, end);
    }

    private static int random(int start, int end) {
	return new Random().ints(start,  end + 1).findFirst().getAsInt();
    }

    private static void quickSort(int[] arr, int start, int end) {
	if(start<end) {
	    int pivot = partition(arr, start, end);
	    quickSort(arr, start, pivot - 1);
	    quickSort(arr, pivot + 1, end);
	}
    }

    private static int partition(int[] arr, int start, int end) {
	int assumedPivot = arr[end];
	int i = start - 1;
	for(int j = start; j < end; j++) {
	    if(arr[j] < assumedPivot) {
		i++;
		swap(arr, i, j);
	    }
	}
	int pivot = i + 1;
	swap(arr, pivot, end);
	return pivot;
    }

    private static void swap(int[] arr, int i, int j) {
	int temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
    }
}
