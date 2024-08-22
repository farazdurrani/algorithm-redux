package com.algorithm.matrix.square.multiply;

public class SquareMatrixMultiply {
    public static void main(String[] args) {
	int[][] A = new int[2][2];
	A[0][0] = 1;
	A[0][1] = 2;
	A[1][0] = 3;
	A[1][1] = 4;
	
	int[][] B = new int[2][2];
	B[0][0] = 5;
	B[0][1] = 6;
	B[1][0] = 7;
	B[1][1] = 8;
	
	int n = A.length;
	int[][] C = new int[n][n];
	for(int i = 0; i < n; i++) {
	    for(int j = 0; j < n; j++) {
		C[i][j] = 0;
		for(int k = 0; k < n; k++) {
		    C[i][j] = C[i][j] + (A[i][k] * B[k][j]);
		}
	    }
	}
	/**
	 * 14
	 * 16
	 * 28
	 * 32
	 */
	
	for (int i = 0; i < C.length; i++) {
	    for (int j = 0; j < C.length; j++) {
		System.out.println(C[i][j]);
	    }
	}
    }
}
