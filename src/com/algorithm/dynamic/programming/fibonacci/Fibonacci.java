package com.algorithm.dynamic.programming.fibonacci;

import java.time.Instant;
import java.util.Arrays;
import java.time.Duration;
public class Fibonacci {
	public static void main(String[] args) {
		System.out.println(fibTopDown(100));
		System.out.println(fibBottomUp(100));
		Instant start = Instant.now();
		System.out.println(fib(100));
		Instant end = Instant.now();
		System.out.println("time taken: " + Duration.between(start, end).toMillis());
	}

	private static long fibBottomUp(int n) {
		long[] memo = new long[n + 1];
		memo[0] = 0; // symbolic
		memo[1] = 1;
		for (int i = 2; i <= n; i++) {
			memo[i] = memo[i - 1] + memo[i - 2];
		}
		return memo[n];
	}

	private static long fibTopDown(int n) {
		long[] memo = new long[n + 1];
		Arrays.fill(memo, -1);
		return fibTopDown(n, memo);
	}

	private static long fibTopDown(int n, long[] memo) {
		if (n == 0 || n == 1) {
			return n;
		}
		if (memo[n] != -1) {
			return memo[n];
		}
		memo[n] = fibTopDown(n - 1, memo) + fibTopDown(n - 2, memo);
		return memo[n];
	}

	/**
	 * naive
	 */
	private static long fib(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		return fib(n - 1) + fib(n - 2);
	}
}
