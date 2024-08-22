package com.algorithm.maxsubarray;

import java.util.Arrays;

public class MaximumSubArray10 {
    private static int a[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };

    private static void print(int[] arr) {
	Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
	System.out.println();
    }

    public static void main(String[] args) {
	int low = 0;
	int high = a.length - 1;
	int b[] = msbdc(low, high);
	print(b);

	int [] c = msbbf();
	
	print(c);

    }

    private static int[] msbbf() {
	int start = 0;
	int end = 0;
	int maxsum = Integer.MIN_VALUE;
	for (int i = 0; i < a.length; i++) {
	    int sum = 0;
	    for (int j = i; j < a.length; j++) {
		sum += a[j];
		if (sum > maxsum) {
		    maxsum = sum;
		    start = i;
		    end = j;
		}
	    }
	}
	return new int[] { start, end, maxsum };
    }

    private static int[] msbdc(int low, int high) {
	if (low == high) {
	    return new int[] { low, high, a[low] };
	} else {
	    int mid = (low + high) / 2;
	    int l[] = msbdc(low, mid);
	    int r[] = msbdc(mid + 1, high);
	    int c[] = msbdc(low, mid, high);
	    if (l[2] >= r[2] && l[2] >= c[2]) {
		return l;
	    } else if (r[2] >= l[2] && r[2] >= c[2]) {
		return r;
	    } else {
		return c;
	    }
	}
    }

    private static int[] msbdc(int low, int mid, int high) {
	int leftsum = Integer.MIN_VALUE;
	int sum = 0;
	int li = -1;
	for (int i = mid; i >= low; i--) {
	    sum += a[i];
	    if (sum > leftsum) {
		leftsum = sum;
		li = i;
	    }
	}

	sum = 0;
	int ri = -1;
	int rightsum = Integer.MIN_VALUE;
	for (int i = mid + 1; i <= high; i++) {
	    sum += a[i];
	    if (sum > rightsum) {
		rightsum = sum;
		ri = i;
	    }
	}
	return new int[] { li, ri, leftsum + rightsum };
    }
}
