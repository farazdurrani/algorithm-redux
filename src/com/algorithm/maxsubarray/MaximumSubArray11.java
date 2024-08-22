package com.algorithm.maxsubarray;

import java.util.Arrays;

public class MaximumSubArray11 {
    private static int a[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };

    private static void print(int[] arr) {
	Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
	System.out.println();
    }

    public static void main(String[] args) {
	print(a);
	int low = 0;
	int high = a.length - 1;
	int[] b = msa(low, high);
	print(b);

	b = a;
	b = msabf(b);

	print(b);

    }

    private static int[] msabf(int[] arr) {
	int start = 0;
	int end = 0;
	int max = Integer.MIN_VALUE;
	for (int i = 0; i < arr.length; i++) {
	    int sum = 0;
	    for (int j = i; j < arr.length; j++) {
		sum += arr[j];
		if (sum > max) {
		    max = sum;
		    start = i;
		    end = j;
		}
	    }
	}
	return new int[] { start, end, max };
    }

    private static int[] msa(int low, int high) {
	if (low == high) {
	    return new int[] { low, high, a[low] };
	} else {
	    int mid = (low + high) / 2;
	    int left[] = msa(low, mid);
	    int right[] = msa(mid + 1, high);
	    int cross[] = msacm(low, mid, high);
	    if (left[2] >= right[2] && left[2] >= cross[2]) {
		return left;
	    } else if (right[2] >= left[2] && right[2] >= cross[2]) {
		return right;
	    } else {
		return cross;
	    }
	}
    }

    private static int[] msacm(int low, int mid, int high) {
	int left_max = Integer.MIN_VALUE;
	int sum = 0;
	int left_max_index = -1;
	for (int i = mid; i >= low; i--) {
	    sum += a[i];
	    if (sum > left_max) {
		left_max = sum;
		left_max_index = i;
	    }
	}
	int right_max = Integer.MIN_VALUE;
	sum = 0;
	int right_max_index = -1;
	for (int j = mid + 1; j <= high; j++) {
	    sum += a[j];
	    if (sum > right_max) {
		right_max = sum;
		right_max_index = j;
	    }
	}
	return new int[] { left_max_index, right_max_index, left_max + right_max };
    }

}
