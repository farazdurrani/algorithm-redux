package com.algorithm.sort.insertion;

import java.util.Arrays;

public class InsertionSort9 {
    public static void main(String[] args) {
	int a[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
	Arrays.stream(a).forEach(x -> System.out.printf("%4d", x));
	System.out.println();

	for (int i = 1; i < a.length; i++) {
	    int key = a[i];
	    int j = i - 1;
	    while (j > -1 && a[j] > key) {
		a[j + 1] = a[j];
		j--;
	    }
	    a[j + 1] = key;
	}
	Arrays.stream(a).forEach(x -> System.out.printf("%4d", x));
	System.out.println();
	
    }
}
