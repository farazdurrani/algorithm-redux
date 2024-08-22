package com.algorithm.maxsubarray;

import java.util.Arrays;

public class MaximumSubArray7 {
    public static void main(String[] args) {
	int arr[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
	Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
	System.out.println();
	int low = 0;
	int high = arr.length - 1;
	int[] arr2 = maxSubArray(arr, low, high);
	Arrays.stream(arr2).forEach(x -> System.out.print(x + " "));
	System.out.println();
	int[] arr3 = maxSubArrayBF(arr);
	Arrays.stream(arr3).forEach(x -> System.out.print(x + " "));
	System.out.println();
    }

    private static int[] maxSubArrayBF(int[] arr) {
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

    private static int[] maxSubArray(int[] arr, int low, int high) {
	if (low == high) {
	    return new int[] { low, high, arr[low] };
	} else {
	    int mid = (low + high) / 2;
	    int[] left = maxSubArray(arr, low, mid);
	    int[] right = maxSubArray(arr, mid + 1, high);
	    int[] cross = maxSubArrayCrossingMid(arr, low, mid, high);
	    if (left[2] >= right[2] && left[2] >= cross[2]) {
		return left;
	    } else if (right[2] >= left[2] && right[2] >= cross[2]) {
		return right;
	    } else {
		return cross;
	    }
	}
    }

    private static int[] maxSubArrayCrossingMid(int[] arr, int low, int mid, int high) {
	int left_sum = Integer.MIN_VALUE;
	int sum = 0;
	int left_index = 0;
	for (int i = mid; i >= low; i--) {
	    sum += arr[i];
	    if (sum > left_sum) {
		left_sum = sum;
		left_index = i;
	    }
	}
	int right_sum = Integer.MIN_VALUE;
	sum = 0;
	int right_index = 0;
	for (int j = mid + 1; j <= high; j++) {
	    sum += arr[j];
	    if (sum > right_sum) {
		right_sum = sum;
		right_index = j;
	    }
	}
	return new int[] { left_index, right_index, left_sum + right_sum };
    }
}
