package com.algorithm.maxsubarray;

import java.util.stream.IntStream;

public class MaxinumSubArray6 {
    public static void main(String[] args) {
	int arr[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
	int low = 0;
	int high = arr.length - 1;
	arr = maxSumArrayDaC(arr, low, high);
	IntStream.of(arr).forEach(x -> System.out.print(x + ", "));
	int arr2[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
	int arr3[] = findMaxSubArrayBF(arr2);
	System.out.println();
	IntStream.of(arr3).forEach(x -> System.out.print(x + ", "));
    }

    private static int[] findMaxSubArrayBF(int[] arr) {
	int start = 0;
	int end = 0;
	int max_sum = Integer.MIN_VALUE;
	for (int i = 0; i < arr.length; i++) {
	    int sum = 0;
	    for (int j = i; j < arr.length; j++) {
		sum += arr[j];
		if (sum > max_sum) {
		    max_sum = sum;
		    start = i;
		    end = j;
		}
	    }
	}

	return new int[] { start, end, max_sum };
    }

    private static int[] maxSumArrayDaC(int[] arr, int low, int high) {
	if (low == high) {
	    return new int[] { low, high, arr[low] };
	} else {
	    int mid = (low + high) / 2;
	    int leftMax[] = maxSumArrayDaC(arr, low, mid);
	    int rightMax[] = maxSumArrayDaC(arr, mid + 1, high);
	    int crossMax[] = maxSumArrayCrossingMidDaC(arr, low, mid, high);
	    if (leftMax[2] >= rightMax[2] && leftMax[2] >= crossMax[2]) {
		return leftMax;
	    } else if (rightMax[2] >= leftMax[2] && rightMax[2] >= crossMax[2]) {
		return rightMax;
	    } else {
		return crossMax;
	    }
	}
    }

    private static int[] maxSumArrayCrossingMidDaC(int[] arr, int low, int mid, int high) {
	int left_max = Integer.MIN_VALUE;
	int sum = 0;
	int left_max_index = 0;
	for (int i = mid; i >= low; i--) {
	    sum += arr[i];
	    if (sum > left_max) {
		left_max = sum;
		left_max_index = i;
	    }
	}
	sum = 0;
	int right_max = Integer.MIN_VALUE;
	int right_max_index = 0;
	for (int j = mid + 1; j <= high; j++) {
	    sum += arr[j];
	    if (sum > right_max) {
		right_max = sum;
		right_max_index = j;
	    }
	}
	return new int[] { left_max_index, right_max_index, left_max + right_max };
    }

}
