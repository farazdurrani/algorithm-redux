package com.algorithm.dynamic.programming.coinchange;

import java.util.Arrays;

public class UniqueWays {
	public static void main(String[] args) {
		int[] coins = { 1, 2, 3 };

		int change = 4;

		int result = uniqueWays(coins, change);

		System.out.println("Unique ways to make change of " + 4 + " " + "from coins " + Arrays.toString(coins) + " "
				+ "is " + result);

	}

	static int uniqueWays(int[] coins, int change) {

		int table[][] = new int[coins.length + 1][change + 1];

		for (int i = 0; i <= coins.length; i++) {
			table[i][0] = 1;
		}

		for (int i = 1; i <= coins.length; i++) {
			for (int j = 1; j <= change; j++) {
				if (coins[i - 1] > j) {
					table[i][j] = table[i - 1][j];
				} else {
					table[i][j] = table[i - 1][j] + table[i][j - coins[i - 1]];
				}
			}
		}

		return table[coins.length][change];
	}
}
