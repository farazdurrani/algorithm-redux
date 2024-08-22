package com.algorithm.dynamic.programming.cutrod;

import java.util.Arrays;

public class CutRod6 {

	public static void main(String[] args) {
		int[] p = { 0, 1, 5, 8, 9, 10, 17, 17, 20, 23, 30 };
		int n = 4;
		System.out.println("Cut Rod Naive: " + cutRod(p, n));
		// dynamic programming
		// top down approach
		System.out.println("Top down approach: " + memoizedCutRod(p, n));
		// bottom up approach
		System.out.println("Bottom Up approach: " + bottomUpCutRod(p, n));

		printCutRodSolution(p, n);
		n = 10;
		printCutRodSolution(p, n);
		n = 7;
		printCutRodSolution(p, n);

	}

	private static void printCutRodSolution(int[] p, int n) {
		int rs[][] = extendedBottomUpCutRod(p, n);

		int s[] = rs[1];

		while (n > 0) {
			System.out.print(s[n] + " ");
			n = n - s[n];
		}
		System.out.println();
	}

	private static int[][] extendedBottomUpCutRod(int[] p, int n) {
		int r[] = new int[n + 1];
		int s[] = new int[n + 1];

		r[0] = 0; // symbolic

		for (int j = 1; j <= n; j++) {
			int q = -1;
			for (int i = 1; i <= j; i++) {
				if (q < p[i] + r[j - i]) {
					q = p[i] + r[j - i];
					s[j] = i;
				}
			}
			r[j] = q;
		}
		return new int[][] { r, s };
	}

	private static int bottomUpCutRod(int[] p, int n) {
		int r[] = new int[n + 1];
		r[0] = 0;
		for (int j = 1; j <= n; j++) {
			int q = -1;
			for (int i = 1; i <= j; i++) {
				q = Math.max(q, p[i] + r[j - i]);
			}
			r[j] = q;
		}
		return r[n];
	}

	private static int memoizedCutRod(int[] p, int n) {
		int r[] = new int[n + 1];
		Arrays.fill(r, -1);
		return memoizedCutRodAuxillary(p, n, r);
	}

	private static int memoizedCutRodAuxillary(int[] p, int n, int[] r) {
		if (r[n] >= 0) {
			return r[n];
		}
		int q;
		if (n == 0) {
			q = 0;
		} else {
			q = Integer.MIN_VALUE;
		}
		for (int i = 1; i <= n; i++) {
			q = Math.max(q, p[i] + memoizedCutRodAuxillary(p, n - i, r));
		}
		r[n] = q;
		return q;
	}

	private static int cutRod(int[] p, int n) {
		if (n == 0) {
			return 0;
		}
		int q = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			q = Math.max(q, p[i] + cutRod(p, n - i));
		}
		return q;
	}

}
