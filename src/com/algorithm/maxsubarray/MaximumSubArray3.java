package com.algorithm.maxsubarray;

import java.util.Arrays;

public class MaximumSubArray3 {

    public static void main(String[] args) {
	int arr[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
	Arrays.stream(arr).forEach(x -> System.out.print(x + ", "));
	System.out.println();
	int low = 0;
	int high = arr.length - 1;
	int[] max_sub_array = findMaxSubArrayDAC(arr, low, high);
	Arrays.stream(max_sub_array).forEach(x -> System.out.print(x + ", "));
	System.out.println();
	int arr2[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
	Arrays.stream(arr2).forEach(x -> System.out.print(x + ", "));
	System.out.println();

	int[] max_sub_arr_2 = findMaximumSubArrayBF(arr2);
	Arrays.stream(max_sub_arr_2).forEach(x -> System.out.print(x + ", "));
    }

    private static int[] findMaxSubArrayDAC(int[] arr, int low, int high) {
	if (low == high) {
	    return new int[] { low, high, arr[low] };
	} else {
	    int mid = (low + high) / 2;
	    int[] leftside = findMaxSubArrayDAC(arr, low, mid);
	    int[] rightside = findMaxSubArrayDAC(arr, mid + 1, high);
	    int[] crossside = findMaxSubArrayCrossingMid(arr, low, mid, high);
	    if (leftside[2] >= rightside[2] && leftside[2] >= crossside[2]) {
		return leftside;
	    } else if (rightside[2] >= leftside[2] && rightside[2] >= crossside[2]) {
		return rightside;
	    } else {
		return crossside;
	    }
	}
    }

    private static int[] findMaxSubArrayCrossingMid(int[] arr, int low, int mid, int high) {
	int left_sum = Integer.MIN_VALUE;
	int sum = 0;
	int max_left_index = 0;
	for (int i = mid; i >= 0; i--) {
	    sum = sum + arr[i];
	    if (sum > left_sum) {
		left_sum = sum;
		max_left_index = i;
	    }
	}
	int right_sum = Integer.MIN_VALUE;
	sum = 0;
	int max_right_index = 0;
	for (int i = mid + 1; i <= high; i++) {
	    sum = sum + arr[i];
	    if (sum > right_sum) {
		right_sum = sum;
		max_right_index = i;
	    }
	}

	return new int[] { max_left_index, max_right_index, left_sum + right_sum };
    }

    private static int[] findMaximumSubArrayBF(int[] arr) {
	
	int max_sum = Integer.MIN_VALUE;
	int n = arr.length;
	int start = 0;
	int end = 0;
	for (int i = 0; i < n; i++) {
	    int sum = 0;
	    for (int j = i; j < n; j++) {
		sum = sum + arr[j];
		if (sum > max_sum) {
		    max_sum = sum;
		    start = i;
		    end = j;
		}
	    }
	}
	return new int[] { start, end, max_sum };
    }

}
