package com.algorithm.dynamic.programming.lcs;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

/**
 * In-order, non-consecutive Longest Common Subsequence
 * 
 * @author Faraz
 *
 */
public class LongestCommonSubsequence2 {

	private static final String NORTHWEST_ARROW = "\u2196";

	private static final String NORTH_ARROW = "\u2191";

	private static final String WEST_ARROW = "\u2190";

	public static void main(String[] args) {
//		char[] X = { 'A', 'B', 'C', 'B', 'D', 'A', 'B' };
//		char[] Y = { 'B', 'D', 'C', 'A', 'B', 'A' };
		String s1 = "ACCGGTCGAGTGCGCGGAAGCCGGCCGAA";
		String s2 = "GTCGTTCGGAATGCCGTTGCTCTGTAAA";
		char [] X = s1.toCharArray();
		char [] Y = s2.toCharArray();

		Instant start = Instant.now();
		System.out.println("Starting brute-force " +  start);
		int length = LCS_LENGTH_BF(X, Y, X.length - 1, Y.length - 1);
		Instant end = Instant.now();
		System.out.println("End of Brute-Force Approach " + end);
		System.out.println("Brute-Force Longest Common Subsequence (non-consecutive) " + length);
		

		LCS_DYNAMICPROGRAMMING(X, Y);

	}

	private static void LCS_DYNAMICPROGRAMMING(char[] X, char[] Y) {
		int m = X.length;
		int n = Y.length;
		int[][] c = new int[m + 1][n + 1];
		String[][] b = new String[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (X[i - 1] == Y[j - 1]) {
					c[i][j] = 1 + c[i - 1][j - 1];
					b[i][j] = NORTHWEST_ARROW;
				} else if (c[i - 1][j] >= c[i][j - 1]) {
					c[i][j] = c[i - 1][j];
					b[i][j] = NORTH_ARROW;
				} else {
					c[i][j] = c[i][j - 1];
					b[i][j] = WEST_ARROW;
				}
			}
		}
		
		System.out.println("Dynamic Longest Common Subsequence (non-consecutive)  " + c[X.length][Y.length]);
		int p = b[0].length;
		int k = b[1].length;
		for (int i = 0; i <= p; i++) {
			for (int j = 0; j < k; j++) {
				if (b[i][j] != null) {
					System.out.print(b[i][j] + c[i][j] + "      ");
				} else {
					System.out.print(" " + c[i][j] + "      ");
				}
			}
			System.out.println("\n");
		}
		PRINT_LCS(b, X, X.length, Y.length);
	}

	private static void PRINT_LCS(String[][] b, char[] x, int i, int j) {
		if (i == 0 || j == 0) {
			return;
		}
		if (b[i][j].equals(NORTHWEST_ARROW)) {
			PRINT_LCS(b, x, i - 1, j - 1);
			System.out.print(x[i-1] + " ");
		} else if (b[i][j].equals(NORTH_ARROW)) {
			PRINT_LCS(b, x, i - 1, j);
		} else {
			PRINT_LCS(b, x, i, j - 1);
		}
	}

	private static int LCS_LENGTH_BF(char[] X, char[] Y, int i, int j) {
		if (i == -1 || j == -1) {
			return 0;
		} else if (X[i] == Y[j]) {
			return 1 + LCS_LENGTH_BF(X, Y, i - 1, j - 1);
		} else {
			return Math.max(LCS_LENGTH_BF(X, Y, i - 1, j), LCS_LENGTH_BF(X, Y, i, j - 1));
		}
	}
}
