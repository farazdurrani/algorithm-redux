package com.algorithm.dynamic.programming.coinchange;

import java.util.Arrays;

public class MinimumCoinChange {
  public static void main(String[] args) {
    int[] coins = {1, 3, 5};
    int change = 9;
    int minimumWays = bruteForce(coins, change);
    System.out.println("Brute force way of finding the minimum number of coins: " + minimumWays);
    bottomUp(coins, change);
    topDown(coins, change);
  }

  private static int bruteForce(int[] coins, int change) {
    if (change == 0) {
      return 0;
    }
    int minimumCoins = Integer.MAX_VALUE;
    for (int i = 0; i < coins.length; i++) {
      if (coins[i] <= change) {
        int result = bruteForce(coins, change - coins[i]);
        if (result + 1 < minimumCoins) {
          minimumCoins = result + 1;
        }
      }
    }
    return minimumCoins;
  }

  private static void bottomUp(int[] coins, int change) {
    int[] table = new int[change + 1];
    Arrays.fill(table, change + 1);
    table[0] = 0;
    for (int i = 0; i <= change; i++) {
      for (int j = 0; j < coins.length; j++) {
        if (coins[j] <= i) {
          table[i] = Math.min(table[i], 1 + table[i - coins[j]]);
        }
      }
    }
    System.out.println("Minimum number of coins needed to make a change for " + change + " is:  " + table[change]);
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
}
