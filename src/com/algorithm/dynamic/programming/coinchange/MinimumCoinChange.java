package com.algorithm.dynamic.programming.coinchange;

import java.util.Arrays;

public class MinimumCoinChange {
	public static void main(String[] args) {
		int[] coins = { 1, 3, 5, 6, 9 };
		int change = 90;
		bottomUp(coins, change);
		topDown(coins, change);
	}

	private static void topDown(int[] coins, int change) {
		int[] table = new int[change + 1];
		int minCoins = topDownHelper(coins, change, table);
		System.out.println("Minimum number of coins needed to make a change for " + change + " is:  " + minCoins);
	}

	private static int topDownHelper(int[] coins, int remainder, int[] table) {
		if (remainder < 0) {
			return -1;
		}
		if (remainder == 0) {
			return 0;
		}

		if (table[remainder] != 0) {
			return table[remainder];
		}

		int minimum = Integer.MAX_VALUE;
		for (int coin : coins) {
			int changeResult = topDownHelper(coins, remainder - coin, table);
			if (changeResult >= 0 && changeResult < minimum) {
				minimum = 1 + changeResult;
			}
		}
		return table[remainder] = minimum == Integer.MAX_VALUE ? -1 : minimum;
	}

	private static void bottomUp(int[] coins, int change) {
		int[] table = new int[change + 1];
		Arrays.fill(table, change + 1);
		table[0] = 0;
		for (int i = 0; i < coins.length; i++) {
			for (int j = 1; j <= change; j++) {
				if (coins[i] <= j) {
					table[j] = Math.min(table[j], table[j - coins[i]] + 1);
				}
			}
		}
		System.out.println("Minimum number of coins needed to make a change for " + change + " is:  " + table[change]);
	}
}
