package com.algorithm.matrix.chain.multiply;

public class MatrixChainMultiply5 {
	public static void main(String[] args) {
//	https://javatutoring.com/matrix-multiplication-in-java/
//	output   matrix:-
//	30 24 18
//	84 69 54
//	138 114 90
		int aRows = 3;
		int aColumns = 3;

		int bRows = 3;
		int bColumns = 3;

		int[][] a = new int[aRows][aColumns];
		int[][] b = new int[bRows][bColumns];

		fillup(a, b);

		// solution

		int[][] c = new int[aRows][bColumns];

		if (aColumns != bRows) {
			System.out.println("Invalid dimentions");
			return;
		}

		for (int i = 0; i < aRows; i++) {
			for (int j = 0; j < bColumns; j++) {
				for (int k = 0; k < aRows; k++) {
					c[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		// print
		for (int i = 0; i < aRows; i++) {
			for (int j = 0; j < bColumns; j++) {
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void fillup(int[][] a, int[][] b) {
		a[0][0] = 1;
		a[0][1] = 2;
		a[0][2] = 3;
		a[1][0] = 4;
		a[1][1] = 5;
		a[1][2] = 6;
		a[2][0] = 7;
		a[2][1] = 8;
		a[2][2] = 9;

		b[0][0] = 9;
		b[0][1] = 8;
		b[0][2] = 7;
		b[1][0] = 6;
		b[1][1] = 5;
		b[1][2] = 4;
		b[2][0] = 3;
		b[2][1] = 2;
		b[2][2] = 1;
	}
}
