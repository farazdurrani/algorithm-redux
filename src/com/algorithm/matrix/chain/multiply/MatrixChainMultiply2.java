package com.algorithm.matrix.chain.multiply;

public class MatrixChainMultiply2 {
    public static void main(String[] args) {
	// correct algorithm
	// match it from here ->
	// https://www.mathsisfun.com/algebra/matrix-multiplying.html
	// 2 4
	// 7 10
	int r1 = 2;
	int r2 = 2;
	int c1 = 2;
	int c2 = 2;

	int[][] a = new int[r1][c1];
	int[][] b = new int[r2][c2];

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
	int c[][] = new int[r1][c2];

	if (c1 != r2) {
	    System.out.println("Invalid dimentions");
	    return;
	}

	for (int i = 0; i < r1; i++) {
	    for (int j = 0; j < c2; j++) {
		for (int k = 0; k < c1; k++) {
		    c[i][j] += a[i][k] * b[k][j];
		}
	    }
	}

	for (int i = 0; i < r1; i++) {
	    for (int j = 0; j < c2; j++) {
		System.out.print(c[i][j] + " ");
	    }
	    System.out.println();
	}
    }
}
