package com.algorithm.maxsubarray;

import java.util.Arrays;

public class MaximumSubArray15 {
	private static int a[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };

	private static void print(int[] arr) {
		Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
		System.out.println();
	}

	public static void main(String[] args) {
		print(a);
		int low = 0;
		int high = a.length - 1;
		int[] max = msa(low, high);
		System.out.println("Maxisum Sub Array Divide-&-Conquere: ");
		print(max);
		int max2[] = msabf();
		print(max2);
	}

	private static int[] msabf() {
		int start = -1;
		int end = -1;
		int max_sum = Integer.MIN_VALUE;
		for(int i = 0; i < a.length; i++) {
			int sum = 0;
			for(int j = i; j < a.length; j++) {
				sum += a[j];
				if(sum > max_sum) {
					max_sum = sum;
					start = i;
					end = j;
				}
			}
		}
		return new int[] {start, end, max_sum};
	}

	private static int[] msa(int low, int high) {
		if (low == high) {
			return new int[] { low, high, a[low] };
		}
		int mid = (low + high) / 2;
		int left[] = msa(low, mid);
		int right[] = msa(mid + 1, high);
		int cross[] = crossingMid(low, mid, high);
		if (left[2] >= right[2] && left[2] >= cross[2]) {
			return left;
		} else if (right[2] > left[2] && right[2] >= cross[2]) {
			return right;
		} else {
			return cross;
		}
	}

	private static int[] crossingMid(int low, int mid, int high) {
		int left_max = Integer.MIN_VALUE;
		int leftMaxIndex = -1;
		int sum = 0;
		for (int i = mid; i >= low; i--) {
			sum += a[i];
			if (sum > left_max) {
				left_max = sum;
				leftMaxIndex = i;
			}
		}
		int right_max = Integer.MIN_VALUE;
		int rightMaxIndex = -1;
		sum = 0;
		for (int j = mid + 1; j <= high; j++) {
			sum += a[j];
			if (sum > right_max) {
				right_max = sum;
				rightMaxIndex = j;
			}
		}
		return new int[] { leftMaxIndex, rightMaxIndex, left_max + right_max };
	}

}
