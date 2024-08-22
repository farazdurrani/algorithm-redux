package com.algorithm.maxsubarray;

import java.util.stream.IntStream;

public class MaxinumSubArray4 {
    public static void main(String[] args) {
	int arr[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
	int low = 0;
	int high = arr.length - 1;
	int maxSubArray[] = findMaxSubArrayDC(arr, low, high);
	IntStream.of(maxSubArray).forEach(x -> System.out.print(x + ", "));
	maxSubArray = findMaxSubArrayBF(arr);
	System.out.println();
	IntStream.of(maxSubArray).forEach(x -> System.out.print(x + ", "));
    }

    private static int[] findMaxSubArrayBF(int[] arr) {
	int start = 0;
	int end = 0;
	int n = arr.length;
	int maxSum = Integer.MIN_VALUE;
	for (int i = 0; i < n; i++) {
	    int sum = 0; // don't forget this sum part. It must start between two for loops.
	    for (int j = i; j < n; j++) {
		sum = sum + arr[j];
		if (sum > maxSum) {
		    maxSum = sum;
		    start = i;
		    end = j;
		}
	    }
	}
	return new int[] { start, end, maxSum };
    }

    private static int[] findMaxSubArrayDC(int[] arr, int low, int high) {
	if (low == high) {
	    return new int[] { low, high, arr[low] };
	} else {
	    int mid = (low + high) / 2;
	    int[] leftMaxSum = findMaxSubArrayDC(arr, low, mid);
	    int[] rightMaxSum = findMaxSubArrayDC(arr, mid + 1, high);
	    int[] crossMaxSum = findMaxSubArrayCrossingMid(arr, low, mid, high);
	    System.out.print("low is: " + low + ", mid is: " + mid + ", high is: " + high);
	    System.out.println();
	    if (leftMaxSum[2] >= rightMaxSum[2] && leftMaxSum[2] >= crossMaxSum[2]) {
		return leftMaxSum;
	    } else if (rightMaxSum[2] >= leftMaxSum[2] && rightMaxSum[2] >= crossMaxSum[2]) {
		return rightMaxSum;
	    } else {
		return crossMaxSum;
	    }
	}
    }

    private static int[] findMaxSubArrayCrossingMid(int[] arr, int low, int mid, int high) {
	int leftSum = Integer.MIN_VALUE;
	int sum = 0;
	int max_left_index = 0;
	for (int i = mid; i >= low; i--) {
	    sum += arr[i];
	    if (sum > leftSum) {
		leftSum = sum;
		max_left_index = i;
	    }
	}
	int rightSum = Integer.MIN_VALUE;
	sum = 0;
	int max_right_index = 0;
	for (int j = mid + 1; j <= high; j++) {
	    sum += arr[j];
	    if (sum > rightSum) {
		rightSum = sum;
		max_right_index = j;
	    }
	}
	return new int[] { max_left_index, max_right_index, leftSum + rightSum };
    }
}
