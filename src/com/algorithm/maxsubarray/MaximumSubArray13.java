package com.algorithm.maxsubarray;

import java.util.Arrays;

public class MaximumSubArray13 {
    private static int a[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4,
        7 };

    private static void print(int[] arr) {
	Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
	System.out.println();
    }

    public static void main(String[] args) {
	int res[] = msadc(0, a.length - 1);
	print(res);
	int []b = a;
	int res2[] = msabf(); 
	print(res2);
    }

    private static int[] msabf() {
	int start = 0;
	int end = 0;
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

    private static int[] msadc(int low, int high) {
	if (low == high) {
	    return new int[] { low, high, a[low] };
	} else {
	    int mid = (low + high) / 2;
	    int[] l = msadc(low, mid);
	    int[] r = msadc(mid + 1, high);
	    int[] cm = msadcCrossingMid(low, mid, high);
	    if (l[2] >= r[2] && l[2] >= cm[2]) {
		return l;
	    } else if (r[2] >= l[2] && r[2] >= cm[2]) {
		return r;
	    } else {
		return cm;
	    }
	}
    }

    private static int[] msadcCrossingMid(int low, int mid, int high) {
	int ls = Integer.MIN_VALUE;
	int li = -1;
	int sum = 0;
	for (int i = mid; i >= low; i--) {
	    sum += a[i];
	    if (sum > ls) {
		ls = sum;
		li = i;
	    }
	}
	int rs = Integer.MIN_VALUE;
	int ri = -1;
	sum = 0;
	for (int j = mid + 1; j <= high; j++) {
	    sum += a[j];
	    if (sum > rs) {
		rs = sum;
		ri = j;
	    }
	}
	return new int[] { li, ri, ls + rs };
    }

}
