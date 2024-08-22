package com.algorithm.dynamic.programming.knapsack.zeroone;

//https://medium.com/@fabianterh/how-to-solve-the-knapsack-problem-with-dynamic-programming-eb88c706d3cf
public class Knapsack2 {
	public static void main(String[] args) {
//		int[] w = { 24, 10, 10, 7 };
//		int[] v = { 24, 18, 18, 10 };
//		int W = 25;

//		int[] w = { 10, 40, 20 };
//		int[] v = { 100, 280, 120 };
//		int W = 60;
		
		//int W[] = new int[]{3, 4, 5, 9, 4};
		int w[] = new int[]{12, 2, 1, 1, 4};
		
		//int V[] = new int[]{3, 4, 4, 10, 4};
		int v[] = new int[]{4, 2, 1, 2, 10};

		int W = 15; 

		int n = w.length; // number of items

		int max[][] = knapsackDynamic(w, v, n, W);
		System.out.println("Maximum Profit: " + max[n][W]);
		
		printSelectedItems(w, v, n, W,  max);
	}

	private static void printSelectedItems(int[] w, int[] v, int n, int W, int[][] max) {
		while (n != 0) {
			if (max[n][W] != max[n - 1][W]) {
				System.out.println("\tPackage " + n + " with W = " + w[n - 1] + " and Value = " + v[n - 1]);
				W = W - w[n-1];
			}
			n--;
		}
	}

	private static int[][] knapsackDynamic(int[] w, int[] v, int n, int W) {
		int m[][] = new int[n + 1][W + 1];
		for (int j = 0; j <= W; j++) {
			m[0][j] = 0; // symbolic since item 0 (that has weight of 0) will always have max value of 0
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= W; j++) {
				if (w[i - 1] > j) {
					m[i][j] = m[i - 1][j];
				} else {
					m[i][j] = Math.max(m[i - 1][j], v[i - 1] + m[i - 1][j - w[i - 1]]);
				}
			}
		}
		return m;
	}
}
