package com.algorithm.dynamic.programming.lcs;

class LCS {
	public int longestCommonSubsequenceLength(String s1, String s2) {
		/*
		 * s2 will be on the rows, s1 will be on the columns.
		 * 
		 * +1 to leave room at the left for the "".
		 */
		int cache[][] = new int[s2.length() + 1][s1.length() + 1];

		/*
		 * cache[s2.length()][s1.length()] is our original subproblem. Each entry in the
		 * table is taking a substring operation against whatever string is on the rows
		 * or columns.
		 * 
		 * It goes from index 0 to index s2Row/s1Col (exclusive)
		 * 
		 * So if my s1 = "azb" and s1Col = 2...then my substring that I pass to the
		 * lcs() function will be:
		 * 
		 * 0 1 2 "a  z  b"
		 * 
		 * "az" (index 2...our upper bound of the snippet...is excluded)
		 */
		for (int s2Row = 0; s2Row <= s2.length(); s2Row++) {
			for (int s1Col = 0; s1Col <= s1.length(); s1Col++) {
				if (s2Row == 0 || s1Col == 0) {
					cache[s2Row][s1Col] = 0;
				} else if (s2.charAt(s2Row - 1) == s1.charAt(s1Col - 1)) {
					cache[s2Row][s1Col] = cache[s2Row - 1][s1Col - 1] + 1;
				} else {
					cache[s2Row][s1Col] = Math.max(cache[s2Row - 1][s1Col], cache[s2Row][s1Col - 1]);
				}
			}
		}

		return cache[s2.length()][s1.length()];
	}
}
