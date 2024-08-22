package com.algorithm.matrix.square.multiply;

public class SquareMatrixMultiply13 {
    public static void main(String[] args) {
	// correct algorithm
	// match it from here ->
	// https://www.mathsisfun.com/algebra/matrix-multiplying.html
	// 2 4
	// 7 10
	int n = 2;
	int[][] a = new int[n][n];
	int[][] b = new int[n][n];

	a[0][0] = 2;
	a[0][1] = 0;
	a[1][0] = 1;
	a[1][1] = 2;
	b[0][0] = 1;
	b[0][1] = 2;
	b[1][0] = 3;
	b[1][1] = 4;

	a[0][0] = 2;
	a[0][1] = 0;
	a[1][0] = 1;
	a[1][1] = 2;
	b[0][0] = 1;
	b[0][1] = 2;
	b[1][0] = 3;
	b[1][1] = 4;
	int c[][] = new int[n][n];

	for (int i = 0; i < n; i++) {
	    for (int j = 0; j < n; j++) {
		for (int k = 0; k < n; k++) {
		    c[i][j] = c[i][j] + (a[i][k] * b[k][j]);
		}
	    }
	}

	for (int i = 0; i < n; i++) {
	    for (int j = 0; j < n; j++) {
		System.out.print(c[i][j] + " ");
	    }
	    System.out.println();
	}

    }
}
