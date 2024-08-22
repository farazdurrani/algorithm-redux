package com.algorithm.matrix.square.multiply;

//correct algorithm
//match it from here -> https://www.mathsisfun.com/algebra/matrix-multiplying.html
//2 4 
//7 10 
public class SquareMatrixMultiply8 {
    public static void main(String[] args) {

	int n = 2;

	int[][] A = new int[n][n];

	int[][] B = new int[n][n];

	fillMatrix(A, B);

	int[][] C = squareMatrixMultiply(A, B, n);

	print(C);

    }

    private static void print(int[][] C) {
	for (int i = 0; i < C.length; i++) {
	    for (int j = 0; j < C.length; j++) {
		System.out.printf("%3d", C[i][j]);
	    }
	    System.out.println();
	}
    }

    private static void fillMatrix(int[][] A, int[][] B) {
	A[0][0] = 2;
	A[0][1] = 0;
	A[1][0] = 1;
	A[1][1] = 2;
	B[0][0] = 1;
	B[0][1] = 2;
	B[1][0] = 3;
	B[1][1] = 4;
    }

    private static int[][] squareMatrixMultiply(int[][] A, int[][] B, int n) {

	int[][] C = new int[n][n];

	for (int i = 0; i < n; i++) {
	    for (int j = 0; j < n; j++) {
		for (int k = 0; k < n; k++) {
		    C[i][j] = C[i][j] + (A[i][k] * B[k][j]);
		}
	    }
	}

	return C;
    }
}
