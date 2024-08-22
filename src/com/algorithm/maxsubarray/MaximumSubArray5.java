package com.algorithm.maxsubarray;

import java.util.stream.IntStream;

public class MaximumSubArray5 {

    public static void main(String[] args) {
	int arr[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
	System.out.println("Original");
	IntStream.of(arr).forEach(x -> System.out.print(x + ", "));
	int low = 0;
	int high = arr.length - 1;
	int[] arr2 = maxSumArrayDaC(arr, low, high);
	System.out.println("\nDaC -> Indexes and Max Sum");
	IntStream.of(arr2).forEach(x -> System.out.print(x + ", "));
	System.out.println("\nBF -> Indexes and Max Sum");
	arr2 = maxSumArrayBF(arr);
	IntStream.of(arr2).forEach(x -> System.out.print(x + ", "));
    }

    private static int[] maxSumArrayBF(int[] arr) {
	int n = arr.length;
	int maxSum = Integer.MIN_VALUE;

	int start = 0;
	int end = 0;

	for (int i = 0; i < n; i++) {
	    int sum = 0;
	    for (int j = i; j < n; j++) {
		sum += arr[j];
		if (sum > maxSum) {
		    maxSum = sum;
		    start = i;
		    end = j;
		}
	    }
	}

	return new int[] { start, end, maxSum };
    }

    private static int[] maxSumArrayDaC(int[] arr, int low, int high) {
	if (low == high) {
	    return new int[] { low, high, arr[low] };
	} else {
	    int mid = (low + high) / 2;
	    int[] leftMaxSum = maxSumArrayDaC(arr, low, mid);
	    int[] rightMaxSum = maxSumArrayDaC(arr, mid + 1, high);
	    int[] maxSumCrossingMid = maxSumArrayCrossingMidDaC(arr, low, mid, high);
	    if (leftMaxSum[2] >= rightMaxSum[2] && leftMaxSum[2] >= maxSumCrossingMid[2]) {
		return leftMaxSum;
	    } else if (rightMaxSum[2] >= leftMaxSum[2] && rightMaxSum[2] >= maxSumCrossingMid[2]) {
		return rightMaxSum;
	    } else {
		return maxSumCrossingMid;
	    }
	}
    }

    private static int[] maxSumArrayCrossingMidDaC(int[] arr, int low, int mid, int high) {
	int leftSum = Integer.MIN_VALUE;
	int sum = 0;
	int leftIndex = 0;
	for (int i = mid; i >= low; i--) {
	    sum += arr[i];
	    if (sum > leftSum) {
		leftSum = sum;
		leftIndex = i;
	    }
	}
	int rightSum = Integer.MIN_VALUE;
	sum = 0;
	int rightIndex = 0;
	for (int j = mid + 1; j <= high; j++) {
	    sum += arr[j];
	    if (sum > rightSum) {
		rightSum = sum;
		rightIndex = j;
	    }
	}
	return new int[] { leftIndex, rightIndex, leftSum + rightSum };
    }

}
