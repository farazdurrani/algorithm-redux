package com.algorithm.sort.quick;

import java.util.Arrays;
import java.util.Random;

public class QuickSort16 {
	private static int a[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };

	private static void print(int[] arr) {
		Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
		System.out.println();
	}

	public static void main(String[] args) {
		print(a);
		int start = 0;
		int end = a.length - 1;
		randomizedQuicksort(a, start, end);
		print(a);
	}

	private static void randomizedQuicksort(int[] b, int start, int end) {
		if (start < end) {
			int rPivot = randomizedPartition(b, start, end);
			randomizedQuicksort(b, start, rPivot - 1);
			randomizedQuicksort(b, rPivot + 1, end);
		}

	}

	private static int randomizedPartition(int[] b, int start, int end) {
		int rand = new Random().ints(start, end + 1).findAny().getAsInt();
		swap(b, rand, end);
		return partition(b, start, end);
	}

	private static int partition(int[] b, int start, int end) {
		int i = start - 1;
		int pivot = b[end];
		for (int j = start; j < end; j++) {
			if (b[j] > pivot) {
				i++;
				swap(b, i, j);
			}
		}
		swap(b, i + 1, end);
		return i+1;
	}

	private static void swap(int[] b, int x, int y) {
		int temp = b[x];
		b[x] = b[y];
		b[y] = temp;
	}
}