package com.algorithm.maxsubarray;

import java.util.Arrays;

public class MaximumSubArray6 {
    public static void main(String[] args) {
	int a[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
	int b[] = maxSubArrayDC(a, 0, a.length - 1);
	Arrays.stream(b).forEach(x -> System.out.print(x + " "));
	System.out.println();
	int c[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
	int d[] = maxSubArrayBF(c);
	Arrays.stream(d).forEach(x -> System.out.print(x + " "));
	System.out.println();
    }

    private static int[] maxSubArrayBF(int[] c) {
	int n = c.length;
	int start = 0;
	int end = 0;
	int maxSum = Integer.MIN_VALUE;
	for (int i = 0; i < n; i++) {
	    int sum = 0;
	    for (int j = i; j < n; j++) {
		sum += c[j];
		if (sum > maxSum) {
		    maxSum = sum;
		    start = i;
		    end = j;
		}
	    }
	}
	return new int[] { start, end, maxSum };
    }

    private static int[] maxSubArrayDC(int[] a, int low, int high) {
	if (low == high) {
	    return new int[] { low, high, a[low] };
	} else {
	    int mid = (low + high) / 2;
	    int[] leftMax = maxSubArrayDC(a, low, mid);
	    int[] rightMax = maxSubArrayDC(a, mid + 1, high);
	    int[] crossMax = maxSubArrayCrossingMid(a, low, mid, high);
	    if (leftMax[2] >= rightMax[2] && leftMax[2] >= crossMax[2]) {
		return leftMax;
	    } else if (rightMax[2] >= leftMax[2] && rightMax[2] >= crossMax[2]) {
		return rightMax;
	    } else {
		return crossMax;
	    }
	}
    }

    private static int[] maxSubArrayCrossingMid(int[] a, int low, int mid, int high) {
	int leftSum = Integer.MIN_VALUE;
	int sum = 0;
	int leftIndex = 0;
	for (int i = mid; i >= low; i--) {
	    sum += a[i];
	    if (sum > leftSum) {
		leftSum = sum;
		leftIndex = i;
	    }
	}
	int rightSum = Integer.MIN_VALUE;
	sum = 0;
	int rightIndex = 0;
	for (int j = mid + 1; j <= high; j++) {
	    sum += a[j];
	    if (sum > rightSum) {
		rightSum = sum;
		rightIndex = j;
	    }
	}
	return new int[] { leftIndex, rightIndex, leftSum + rightSum };
    }
}
