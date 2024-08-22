package com.algorithm.maxsubarray;

import java.util.Arrays;

public class MaximumSubArray14 {
	private static int a[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };

	private static void print(int[] arr) {
		Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
		System.out.println();
	}

	public static void main(String[] args) {
		print(a);
		int low = 0;
		int high = a.length - 1;
		int[] max = maxSubArrayDivideAndConquere(low, high);
		print(max);
		a = new int[] { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
		print(a);
		max = maxSubArrayBruteForceApproach();
		print(max);
	}

	private static int[] maxSubArrayBruteForceApproach() {
		int start = -1;
		int end = -1;
		int max_sum = Integer.MIN_VALUE;
		for (int i = 0; i < a.length - 1; i++) {
			int sum = 0;
			for (int j = i; j < a.length - 1; j++) {
				sum += a[j];
				if (sum > max_sum) {
					max_sum = sum;
					start = i;
					end = j;
				}
			}
		}
		return new int[] { start, end, max_sum };
	}

	private static int[] maxSubArrayDivideAndConquere(int low, int high) {
		if (low == high) {
			return new int[] { low, high, a[low] };
		} else {
			int mid = (low + high) / 2;
			int[] left = maxSubArrayDivideAndConquere(low, mid);
			int[] right = maxSubArrayDivideAndConquere(mid + 1, high);
			int[] cross = maxSubArrayCrossingMid(low, mid, high);
			if (left[2] >= right[2] && left[2] >= cross[2]) {
				return left;
			} else if (right[2] >= left[2] && right[2] >= cross[2]) {
				return right;
			} else {
				return cross;
			}
		}
	}

	private static int[] maxSubArrayCrossingMid(int low, int mid, int high) {
		int left_max_sum = Integer.MIN_VALUE;
		int left_index = -1;
		int sum = 0;
		for (int i = mid; i >= low; i--) {
			sum += a[i];
			if (sum > left_max_sum) {
				left_max_sum = sum;
				left_index = i;
			}
		}
		int right_max_sum = Integer.MIN_VALUE;
		int right_index = -1;
		sum = 0;
		for (int j = mid + 1; j <= high; j++) {
			sum += a[j];
			if (sum > right_max_sum) {
				right_max_sum = sum;
				right_index = j;
			}
		}
		return new int[] { left_index, right_index, left_max_sum + right_max_sum };
	}

}
