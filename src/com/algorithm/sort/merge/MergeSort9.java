package com.algorithm.sort.merge;

import java.util.Arrays;

public class MergeSort9 {
    public static void main(String[] args) {
	int a[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
	Arrays.stream(a).forEach(x -> System.out.printf("%4d", x));
	System.out.println();
	ms(a, 0, a.length - 1);
	Arrays.stream(a).forEach(x -> System.out.printf("%4d", x));
	System.out.println();
    }

    private static void ms(int[] a, int low, int high) {
	if (low < high) {
	    int mid = (low + high) / 2;
	    ms(a, low, mid);
	    ms(a, mid + 1, high);
	    m(a, low, mid, high);
	}
    }

    private static void m(int[] a, int low, int mid, int high) {
	int left[] = new int[mid + 1 - low];
	int right[] = new int[high - mid];
	int i = 0;
	int j = 0;
	for (; i < left.length; i++) {
	    left[i] = a[low + i];
	}
	for (; j < right.length; j++) {
	    right[j] = a[mid + 1 + j];
	}
	i = 0;
	j = 0;
	int k = low;
	while (i < left.length && j < right.length) {
	    if (left[i] <= right[j]) {
		a[k] = left[i];
		i++;
	    } else {
		a[k] = right[j];
		j++;
	    }
	    k++;
	}
	while (i < left.length) {
	    a[k] = left[i];
	    i++;
	    k++;
	}
	while (j < right.length) {
	    a[k] = right[j];
	    k++;
	    j++;
	}
    }
}
