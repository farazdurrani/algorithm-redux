package com.algorithm.maxsubarray;

import java.util.Arrays;

public class MaximumSubArray {
    public static void main(String[] args) {
	int arr[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
	int low = 0;
	int high = arr.length - 1;
	int result[] = FIND_MAX_SUBARRAY_DAC(arr, low, high);
	System.out.println(Arrays.toString(result));
	result = FIND_MAX_SUBARRAY_BF(arr);
	System.out.println(Arrays.toString(result));

    }

    /**
     * BF = BRUTE-FORCE
     */
    private static int[] FIND_MAX_SUBARRAY_BF(int[] arr) {
	int start = 0;
	int end = 0;
	int max_subarray_sum = Integer.MIN_VALUE;
	for (int left = 0; left < arr.length; left++) {
	    int sum = 0;
	    for (int right = left; right < arr.length; right++) {
		sum = sum + arr[right];
		if (sum > max_subarray_sum) {
		    max_subarray_sum = sum;
		    start = left;
		    end = right;
		}
	    }
	}
	return new int[] { start, end, max_subarray_sum };
    }

    /**
     * DAC = DIVIDE-AND-CONQUER
     */
    private static int[] FIND_MAX_SUBARRAY_DAC(int[] arr, int low, int high) {
	if (low == high) {
	    return new int[] { low, high, arr[low] };
	} else {
	    int mid = (low + high) / 2;
	    int left[] = FIND_MAX_SUBARRAY_DAC(arr, low, mid);
	    int right[] = FIND_MAX_SUBARRAY_DAC(arr, mid + 1, high);
	    int cross[] = FIND_MAX_SUBARRAY_CROSSING_DAC(arr, low, mid, high);
	    if (left[2] >= right[2] && left[2] >= cross[2])
		return left;
	    else if (right[2] >= left[2] && right[2] >= cross[2])
		return right;
	    else
		return cross;
	}
    }

    /**
     * DAC = DIVIDE-AND-CONQUER
     */
    private static int[] FIND_MAX_SUBARRAY_CROSSING_DAC(int[] arr, int low, int mid,
        int high) {
	int left_sum = Integer.MIN_VALUE;
	int sum = 0;
	int max_left_index = 0;
	for (int i = mid; i >= low; i--) {
	    sum = sum + arr[i];
	    if (sum > left_sum) {
		left_sum = sum;
		max_left_index = i;
	    }
	}
	int right_sum = Integer.MIN_VALUE;
	sum = 0;
	int max_right_index = 0;
	for (int j = mid + 1; j <= high; j++) {
	    sum = sum + arr[j];
	    if (sum > right_sum) {
		right_sum = sum;
		max_right_index = j;
	    }
	}
	return new int[] { max_left_index, max_right_index, left_sum + right_sum };
    }

}
