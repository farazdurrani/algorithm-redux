package com.algorithm.maxsubarray;

import java.util.Arrays;

public class MaximumSubArray2 {
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
	int maxSum = Integer.MIN_VALUE;
	int start = 0;
	int end = 0;
	int n = arr.length;
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

    /**
     * DAC = DIVIDE-AND-CONQUER
     */
    private static int[] FIND_MAX_SUBARRAY_DAC(int[] arr, int low, int high) {
	if (low == high) {
	    return new int[] { low, high, arr[low] };
	} else {
	    int mid = (low + high) / 2;
	    int left_max[] = FIND_MAX_SUBARRAY_DAC(arr, low, mid);
	    int right_max[] = FIND_MAX_SUBARRAY_DAC(arr, mid + 1, high);
	    int crossing_mid_max[] = FIND_MAX_SUBARRAY_CROSSING_DAC(arr, low, mid, high);
	    if(left_max[2] >= right_max[2] && left_max[2] >= crossing_mid_max[2]) {
		return left_max;
	    } else if(right_max[2] >= left_max[2] && right_max[2] >= crossing_mid_max[2]) {
		return right_max;
	    } else {
		return crossing_mid_max;
	    }
	}
    }

    /**
     * DAC = DIVIDE-AND-CONQUER
     */
    private static int[] FIND_MAX_SUBARRAY_CROSSING_DAC(int[] arr, int low, int mid, int high) {
	int max_left_sum = Integer.MIN_VALUE;
	int sum = 0;
	int max_left_index = 0;
	for (int i = mid; i >= low; i--) {
	    sum += arr[i];
	    if (sum > max_left_sum) {
		max_left_sum = sum;
		max_left_index = i;
	    }
	}
	int max_right_sum = Integer.MIN_VALUE;
	sum = 0;
	int max_right_index = 0;
	for (int j = mid + 1; j <= high; j++) {
	    sum += arr[j];
	    if (sum > max_right_sum) {
		max_right_sum = sum;
		max_right_index = j;
	    }
	}
	return new int[] { max_left_index, max_right_index, max_left_sum + max_right_sum };
    }

}
