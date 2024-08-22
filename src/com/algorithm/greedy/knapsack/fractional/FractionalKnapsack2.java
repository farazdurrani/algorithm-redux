package com.algorithm.greedy.knapsack.fractional;

public class FractionalKnapsack2 {

	public static void main(String[] args) {

		int[] w = { 10, 40, 20, 24 }; // sorted already by Pi / Wi
		int[] p = { 100, 280, 120, 120 }; // sorted already by Pi / Wi
		int W = 60;

		double ratios[] = fractionalKnapsackGreedy(w, p, W);

		double maxProfit = maxProfit(ratios, p);

		System.out.println("Maximum Profit: " + maxProfit);

	}

	private static double maxProfit(double[] ratios, int[] p) {
		double maxProfit = 0;

		for (int i = 0; i < ratios.length; i++) {
			if (ratios[i] != 0) {
				maxProfit = maxProfit + (p[i] * ratios[i]);
			}
		}
		return maxProfit;
	}

	// it assumes that weight and profit are in descending order
	public static double[] fractionalKnapsackGreedy(int[] w, int[] p, int W) {
		return null;
	}
}
