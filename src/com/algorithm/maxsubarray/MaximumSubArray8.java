package com.algorithm.maxsubarray;

import java.util.Arrays;

public class MaximumSubArray8 {
    public static void main(String[] args) {
	int a[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
	Arrays.stream(a).forEach(x -> System.out.printf("%4d", x));
	System.out.println();

	int low = 0;
	int high = a.length - 1;
	int[] b = maxSubArray(a, low, high);

	Arrays.stream(b).forEach(x -> System.out.printf("%4d", x));
	System.out.println();

	int c[] = maxSumArrayBF(a);
	Arrays.stream(c).forEach(x -> System.out.printf("%4d", x));
	System.out.println();

    }

    private static int[] maxSumArrayBF(int[] a) {
	int n = a.length;
	int start = 0;
	int end = 0;
	int max = Integer.MIN_VALUE;
	for (int i = 0; i < n; i++) {
	    int sum = 0;
	    for (int j = i; j < n; j++) {
		sum += a[j];
		if(sum > max) {
		    max = sum;
		    start = i;
		    end = j;
		}
	    }
	}

	return new int[] {start, end, max};
    }

    private static int[] maxSubArray(int[] a, int low, int high) {
	if (low == high) {
	    return new int[] { low, high, a[low] };
	} else {
	    int mid = (low + high) / 2;
	    int leftmax[] = maxSubArray(a, low, mid);
	    int rightmax[] = maxSubArray(a, mid + 1, high);
	    int crossmax[] = maxSubArrayCrossingMid(a, low, mid, high);
	    if (leftmax[2] >= rightmax[2] && leftmax[2] >= crossmax[2]) {
		return leftmax;
	    } else if (rightmax[2] >= leftmax[2] && rightmax[2] >= crossmax[2]) {
		return rightmax;
	    } else {
		return crossmax;
	    }
	}
    }

    private static int[] maxSubArrayCrossingMid(int[] a, int low, int mid, int high) {
	int leftmax = Integer.MIN_VALUE;
	int sum = 0;
	int leftindex = 0;
	for (int i = mid; i >= low; i--) {
	    sum += a[i];
	    if (sum > leftmax) {
		leftmax = sum;
		leftindex = i;
	    }
	}

	int rightmax = Integer.MIN_VALUE;
	sum = 0;
	int rightindex = 0;
	for (int i = mid + 1; i <= high; i++) {
	    sum += a[i];
	    if (sum > rightmax) {
		rightmax = sum;
		rightindex = i;
	    }
	}

	return new int[] { leftindex, rightindex, leftmax + rightmax };
    }
}
