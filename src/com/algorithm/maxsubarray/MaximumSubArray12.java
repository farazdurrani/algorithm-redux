package com.algorithm.maxsubarray;

import java.util.Arrays;

public class MaximumSubArray12 {
    private static int a[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };

    private static void print(int[] arr) {
	Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
	System.out.println();
    }

    public static void main(String[] args) {
	print(a);
	int low = 0;
	int high = a.length - 1;
	int c[] = msa(a, low, high);
	print(c);
	c = a;
	c = msabf(c);
	print(c);

    }

    private static int[] msabf(int[] a) {
	int start = -1;
	int end = -1;
	int ms = Integer.MIN_VALUE;
	for (int i = 0; i < a.length; i++) {
	    int sum = 0;
	    for (int j = i; j < a.length; j++) {
		sum += a[j];
		if (sum > ms) {
		    ms = sum;
		    start = i;
		    end = j;
		}
	    }
	}
	return new int[] { start, end, ms };
    }

    private static int[] msa(int[] a, int low, int high) {
	if (low == high) {
	    return new int[] { low, high, a[low] };
	} else {
	    int mid = (low + high) / 2;
	    int left[] = msa(a, low, mid);
	    int right[] = msa(a, mid + 1, high);
	    int cross[] = msacm(a, low, mid, high);
	    if (left[2] >= right[2] && left[2] >= cross[2]) {
		return left;
	    } else if (right[2] >= left[2] && right[2] >= cross[2]) {
		return right;
	    } else {
		return cross;
	    }
	}
    }

    private static int[] msacm(int[] a, int low, int mid, int high) {
	int ls = Integer.MIN_VALUE;
	int sum = 0;
	int li = -1;
	for (int i = mid; i >= 0; i--) {
	    sum += a[i];
	    if (sum > ls) {
		ls = sum;
		li = i;
	    }
	}
	sum = 0;
	int rs = Integer.MIN_VALUE;
	int ri = -1;
	for (int j = mid + 1; j <= high; j++) {
	    sum += a[j];
	    if (sum > rs) {
		rs = sum;
		ri = j;
	    }
	}
	return new int[] { li, ri, ls + rs };
    }

}
