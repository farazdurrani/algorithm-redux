package com.algorithm.matrix.chain.multiply;

public class MatrixChainMultiply3 {
    public static void main(String[] args) {
//	https://javatutoring.com/matrix-multiplication-in-java/
//	output   matrix:-
//	30 24 18
//	84 69 54
//	138 114 90
	int r1 = 3;
	int r2 = 3;
	int c1 = 3;
	int c2 = 3;

	int[][] a = new int[r1][c1];
	int[][] b = new int[r2][c2];

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

	int[][] c = new int[r1][c2];

	if (c1 != r2) {
	    throw new RuntimeException("Incompitable Matrix");
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
