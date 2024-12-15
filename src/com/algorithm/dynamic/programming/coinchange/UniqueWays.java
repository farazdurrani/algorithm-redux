package com.algorithm.dynamic.programming.coinchange;

import java.util.Arrays;

public class UniqueWays {
  public static void main(String[] args) {
    int[] coins = {1, 2, 3};
    int change = 4;
    int result = dynamic(coins, change);
    System.out.println(
        "Unique ways to make change of " + 4 + " " + "from coins " + Arrays.toString(coins) + " " + "is " + result);
    result = bruteForce(coins, change);
    System.out.println(
        "Unique ways to make change of " + 4 + " " + "from coins " + Arrays.toString(coins) + " " + "is " + result);
  }

  static int bruteForce(int[] coins, int change) {
    return bruteForce(coins, coins.length, change);
  }

  static int bruteForce(int[] coins, int n, int change) {
    // If change is 0 then there is 1 solution
    // (do not include any coin)
    if (change == 0) return 1;
    // 0 ways in the following two cases
    if (change < 0 || n == 0) return 0;
    // Exclude the current coin: bruteForce(coins, n-1,change ).
    // Include the current coin: bruteForce(coins, n, change – coins[n-1] )
    return bruteForce(coins, n - 1, change) + bruteForce(coins, n, change - coins[n - 1]);
  }

  static int dynamic(int[] coins, int change) {
    int[][] table = new int[coins.length + 1][change + 1];
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
