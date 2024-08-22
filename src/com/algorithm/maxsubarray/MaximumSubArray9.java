package com.algorithm.maxsubarray;

import java.util.Arrays;

public class MaximumSubArray9 {
    
    private static int a[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };

    private static void print(int[] arr) {
	Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
	System.out.println();
    }
    public static void main(String[] args) {

	int low = 0;
	int high = a.length - 1;
	int maxSubArray[] = maxSubArray(a, low, high);
	print(maxSubArray);
	int maxSubArray2[] = maxSubArrayBF();
	print(maxSubArray2);

    }

    private static int[] maxSubArray(int[] a, int low, int high) {
	if (low == high) {
	    return new int[] { low, high, a[low] };
	} else {
	    int mid = (low + high) / 2;
	    int left[] = maxSubArray(a, low, mid);
	    int right[] = maxSubArray(a, mid + 1, high);
	    int cross[] = maxSubArrayCrossingMid(a, low, mid, high);
	    if (left[2] >= right[2] && left[2] >= cross[2]) {
		return left;
	    } else if (right[2] >= left[2] && right[2] >= cross[2]) {
		return right;
	    } else {
		return cross;
	    }
	}
    }

    private static int[] maxSubArrayCrossingMid(int[] a, int low, int mid, int high) {
	int lmax = Integer.MIN_VALUE;
	int sum = 0;
	int li = 0;
	for (int i = mid; i >= low; i--) {
	    sum += a[i];
	    if (sum > lmax) {
		lmax = sum;
		li = i;
	    }
	}
	sum = 0;
	int ri = 0;
	int rmax = Integer.MIN_VALUE;
	for (int j = mid + 1; j <= high; j++) {
	    sum += a[j];
	    if (sum > rmax) {
		rmax = sum;
		ri = j;
	    }
	}
	return new int[] { li, ri, lmax + rmax };
    }

    private static int[] maxSubArrayBF() {
	int maxsum = Integer.MIN_VALUE;
	int start = 0;
	int end = 0;
	for (int i = 0; i < a.length; i++) {
	    int sum = 0;
	    for (int j = i; j < a.length; j++) {
		sum += a[j];
		if (sum > maxsum) {
		    maxsum = sum;
		    start = i;
		    end = j;
		}
	    }
	}
	return new int[] { start, end, maxsum };
    }
}
