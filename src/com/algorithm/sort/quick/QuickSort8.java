package com.algorithm.sort.quick;

import java.util.Arrays;
import java.util.Random;

public class QuickSort8 {
    private static int arr[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };

    private static void print(int[] arr) {
	Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
	System.out.println();
    }

    public static void main(String[] args) {
	print(arr);
	quickSort(arr, 0, arr.length - 1);
	print(arr);
	arr = new int[]{ 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
	print(arr);
	quickSortRandomized(arr, 0, arr.length - 1);
	print(arr);
    }

    private static void quickSort(int[] arr, int start, int end) {
	if (start < end) {
	    int pivot = partition(arr, start, end);
	    quickSort(arr, start, pivot - 1);
	    quickSort(arr, pivot + 1, end);
	}
    }

    private static int partition(int[] arr, int start, int end) {
	int assumedPivot = arr[end];
	int i = start - 1;
	for (int j = start; j < end; j++) {
	    if (arr[j] < assumedPivot) {
		i++;
		swap(arr, i, j);
	    }
	}
	int pivot = i + 1;
	swap(arr, pivot, end);
	return pivot;
    }
    
    private static void quickSortRandomized(int[] arr, int start, int end) {
	if(start < end) {
	    int randomPivot = randomizedPartition(arr, start, end);
	    quickSortRandomized(arr, start, randomPivot - 1);
	    quickSortRandomized(arr, randomPivot + 1, end);
	}
    }

    private static int randomizedPartition(int[] arr, int start, int end) {
	int random = random(start, end);
	swap(arr, random, end);
	return partition(arr, start, end);
    }
    
    private static int random(int start, int end) {
	return new Random().ints(start, end + 1).findFirst().getAsInt();
    }

    private static void swap(int[] arr, int i, int j) {
	int temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
    }
}
