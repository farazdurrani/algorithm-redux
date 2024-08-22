package com.algorithm.matrix.square.multiply;

public class SquareMatrixMultiply7 {
    public static void main(String[] args) {
	int n = 2;
	int A[][] = new int[n][n];
	int B[][] = new int[n][n];
	A[0][0] = 1;
	A[1][0] = 2;
	A[0][1] = 3;
	A[1][1] = 4;
	B[0][0] = 5;
	B[1][0] = 6;
	B[0][1] = 7;
	B[1][1] = 8;
	int[][] C = new int[n][n];
	for (int i = 0; i < n; i++) {
	    for (int j = 0; j < n; j++) {
		for (int k = 0; k < n; k++) {
		    C[i][j] = C[i][j] + (A[i][k] + B[k][j]);
		}
	    }
	}
	for (int i = 0; i < C.length; i++) {
	    for (int j = 0; j < C.length; j++) {
		System.out.print(C[i][j] + " ");
	    }
	    System.out.println();
	}
    }
}
