package com.algorithm.dynamic.programming.cutrod;

public class CutRod8 {

    public static void main(String[] args) {
	int[] p = { 0, 1, 5, 8, 9, 10, 17, 17, 20, 23, 30 };
	int n = 4;
	System.out.println("Cut Rod Naive: " + cutRod(p, n));
	// dynamic programming
	// top down approach
	System.out.println("Top down approach: " + memoizedCutRod(p, n));
	// bottom up approach
	System.out.println("Bottom Up approach: " + bottomUpCutRod(p, n));


	printCutRodSolution(p, n);
	n = 10;
	printCutRodSolution(p, n);
	n = 7;
	printCutRodSolution(p, n);

    }

    private static void printCutRodSolution(int[] p, int i) {
    }

    private static int bottomUpCutRod(int[] p, int n) {
	return -1;
    }

    private static int memoizedCutRod(int[] p, int n) {
	return -1;
    }
    
	private static int memoizedCutRodAuxillary(int[] p, int n, int[] r) {
		return 0;
	}

    private static int cutRod(int[] p, int n) {
	return -1;
    }

}
