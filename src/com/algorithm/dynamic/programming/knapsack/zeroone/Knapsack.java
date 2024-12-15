package com.algorithm.dynamic.programming.knapsack.zeroone;

public class Knapsack {
  public static void main(String[] args) {
    int[] w = {10, 20, 30};
    int[] v = {60, 100, 120};
    int W = 50;
    int n = w.length; // number of items
    int[][] max = knapsackDynamic(w, v, n, W);
    System.out.println("Maximum Profit: " + max[n][W]);
    printSelectedItems(w, v, n, W, max);
    int maxValueFromBF = knapsackBruteForce(w, v, n, W);
    System.out.println("Maximum Profit (brute-force) " + maxValueFromBF);
  }

  private static int[][] knapsackDynamic(int[] w, int[] v, int n, int W) {
    int[][] table = new int[n + 1][W + 1];
    for (int j = 0; j <= W; j++) {
      table[0][j] = 0;
    }
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= W; j++) {
        if (w[i - 1] > j) {
          table[i][j] = table[i - 1][j];
        } else {
          table[i][j] = Math.max(table[i - 1][j], v[i - 1] + table[i - 1][j - w[i - 1]]);
        }
      }
    }
    return table;
  }

  private static void printSelectedItems(int[] w, int[] v, int n, int W, int[][] max) {
    int i = n;
    int j = W;
    while (i != 0) {
      if (max[i][j] != max[i - 1][j]) {
        System.out.println("Item " + i + " selected with weight " + w[i - 1] + " and value " + v[i - 1]);
        j = j - w[i - 1];
      }
      i--;
    }
  }

  private static int knapsackBruteForce(int[] w, int[] v, int n, int W) {
    if (n == 0 || W == 0) {
      return 0;
    } else if (w[n - 1] > W) {
      return knapsackBruteForce(w, v, n - 1, W);
    } else {
      int excludeItem = knapsackBruteForce(w, v, n - 1, W);
      int includeItem = v[n - 1] + knapsackBruteForce(w, v, n - 1, W - w[n - 1]);
      return Math.max(excludeItem, includeItem);
    }
  }

  private static int[][] knapsackDynamicWithNotes(int[] w, int[] v, int n, int W) {
    // this table stores the maximum values for a given item and for a given weight limit
    // a.k.a capacity. We go from 0 to exhausting all the items and weights.
    int[][] table = new int[n + 1][W + 1];
    for (int j = 0; j <= W; j++) {
      // for 1st row (a.k.a 0 items), no matter what the weight capacity is,
      // since the item is missing, maximum value is always 0.
      table[0][j] = 0;
    }
    for (int i = 1; i <= n; i++) { // i represents item number
      for (int j = 1; j <= W; j++) { // j represents weight at this juncture
        if (w[i - 1] > j) {
          // The weight of current 'i' item exceeds the capacity 'j' so we copy the
          // value of the previously selected items for this weight j.
          table[i][j] = table[i - 1][j];
        } else {
          // We can fit current item.
          // Ultimately, we want to hold items of greatest value.
          // So we may pick current item or may not pick current item.
          // We pick whatever yields us the greatest value!
          table[i][j] = Math.max(table[i - 1][j], v[i - 1] + table[i - 1][j - w[i - 1]]);
        }
      }
    }
    return table;
  }
}
