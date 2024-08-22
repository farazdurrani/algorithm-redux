package com.algorithm.greedy.knapsack.fractional;

public class FractionalKnapsack {

	public static void main(String[] args) {

		int[] w = { 10, 40, 20, 24 }; //sorted already by Pi / Wi
		int[] p = { 100, 280, 120, 120 }; //sorted already by Pi / Wi
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

		double[] ratios = new double[w.length];

		int weight = 0; // Cumulative weight so far.

		for (int i = 0; i < w.length; i++) {
			if (weight + w[i] <= W) {
				ratios[i] = 1;
				weight += w[i];
			} else {
				double ratio = (double) (W - weight) / w[i];
				ratios[i] = ratio;
				weight = W;
				break;
			}
		}
		return ratios;
	}
}
