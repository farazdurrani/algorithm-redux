package com.algorithm.maxsubarray;

import java.util.stream.IntStream;

public class MaxinumSubArray5 {
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
	for(int i = 0; i < arr.length; i++) {
	    int sum = 0;
	    for(int j = i; j < arr.length; j++) {
		sum+= arr[j];
		if(sum > max_sum) {
		    max_sum = sum;
		    start = i;
		    end = j;
		}
	    }
	}
	return new int[] {start, end, max_sum};
    }

    private static int[] maxSumArrayDaC(int[] arr, int low, int high) {
	if (low == high) {
	    return new int[] { low, high, arr[low] };
	} else {
	    int mid = (low + high) / 2;
	    int left_max[] = maxSumArrayDaC(arr, low, mid);
	    int right_max[] = maxSumArrayDaC(arr, mid + 1, high);
	    int cross_max[] = maxSumArrayDaCCrossingMid(arr, low, mid, high);
	    if (left_max[2] >= right_max[2] && left_max[2] >= cross_max[2]) {
		return left_max;
	    } else if (right_max[2] >= left_max[2] && right_max[2] >= cross_max[2]) {
		return right_max;
	    } else {
		return cross_max;
	    }
	}

    }

    private static int[] maxSumArrayDaCCrossingMid(int[] arr, int low, int mid, int high) {
	int left_max = Integer.MIN_VALUE;
	int sum = 0;
	int left_most_index = 0;
	for (int i = mid; i >= low; i--) {
	    sum += arr[i];
	    if (sum > left_max) {
		left_max = sum;
		left_most_index = i;
	    }
	}

	int right_max = Integer.MIN_VALUE;
	sum = 0;
	int right_most_index = 0;
	for (int j = mid + 1; j <= high; j++) {
	    sum += arr[j];
	    if (sum > right_max) {
		right_max = sum;
		right_most_index = j;
	    }
	}
	return new int[] { left_most_index, right_most_index, left_max + right_max };
    }
}
