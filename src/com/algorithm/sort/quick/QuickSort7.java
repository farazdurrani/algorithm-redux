package com.algorithm.sort.quick;

import java.util.Arrays;
import java.util.Random;

public class QuickSort7 {
    public static void main(String[] args) {
//	int arr[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };

	int arr[] = { 1, 2, 3, 4, 5 };

	Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
	System.out.println();

	quickSort(arr, 0, arr.length - 1);

	Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
	System.out.println();

//	int arr2[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };

	int arr2[] = { 1, 2, 3, 4, 5 };

	randomizedQuickSort(arr2, 0, arr.length - 1);

	Arrays.stream(arr2).forEach(x -> System.out.print(x + " "));
	System.out.println();

    }

    private static void randomizedQuickSort(int[] arr, int start, int end) {
	if (start < end) {
	    int rp = randomizedPartition(arr, start, end);
	    randomizedQuickSort(arr, start, rp - 1);
	    randomizedQuickSort(arr, rp + 1, end);
	}
    }

    private static int randomizedPartition(int[] arr, int start, int end) {
	int random = random(start, end);
	swap(arr, random, end);
	return partition(arr, start, end);
    }

    static Random rand = new Random();

    private static int random(int start, int end) {
	return rand.ints(start, end + 1).findFirst().getAsInt();
    }

    private static void quickSort(int[] arr, int start, int end) {
	if (start < end) {
	    int pivot = partition(arr, start, end);
	    quickSort(arr, start, pivot - 1);
	    quickSort(arr, pivot + 1, end);
	}
    }

    private static int partition(int[] arr, int start, int end) {
	int i = start - 1;
	int pivot = arr[end];
	for (int j = start; j < end; j++) {
	    if (arr[j] < pivot) {
		i++;
		swap(arr, i, j);
	    }
	}
	swap(arr, i + 1, end);
	return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
	int temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
    }
}
