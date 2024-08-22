import java.util.Arrays;

public class A {

    public static void main(String[] args) {
	int a[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
	Arrays.stream(a).forEach(x -> System.out.printf("%4d", x));
	System.out.println();

	// correct algorithm
	// match it from here ->
	// https://www.mathsisfun.com/algebra/matrix-multiplying.html
	// 2 4
	// 7 10

	int n = 2;
	int[][] A = new int[n][n];
	int[][] B = new int[n][n];

	A[0][0] = 2;
	A[0][1] = 0;
	A[1][0] = 1;
	A[1][1] = 2;
	B[0][0] = 1;
	B[0][1] = 2;
	B[1][0] = 3;
	B[1][1] = 4;

	A[0][0] = 2;
	A[0][1] = 0;
	A[1][0] = 1;
	A[1][1] = 2;
	B[0][0] = 1;
	B[0][1] = 2;
	B[1][0] = 3;
	B[1][1] = 4;
	
	int c[] [] = new int[n][n];
	
	for(int i = 0; i < n; i++) {
	    for(int j = 0; j  < n; j++) {
		
	    }
	}

    }
}
