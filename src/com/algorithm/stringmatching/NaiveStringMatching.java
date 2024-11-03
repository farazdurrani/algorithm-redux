package com.algorithm.stringmatching;

import java.util.Arrays;

public class NaiveStringMatching {
    public static void main(String[] args) {
        String text = "this is not this";
        String pattern = "this";
        naiveStringMatching(text, pattern);
    }

    /**
     * hint : it's a sliding tile thing. Think of text as fixed tiles. And pattern as sliding tiles.
     * Keep moving tile and match each element.
     * @param text
     * @param pattern
     */
    private static void naiveStringMatching(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        for (int s = 0; s <= n - m; s++) {
            if (Arrays.equals(pattern.toCharArray(), textArray(text, s, s + m))) {
                System.out.println("Found a match!");
            }
        }
    }

    private static char[] textArray(String text, int start, int end) {
        char[] arr = new char[end - start];
        for (int i = start, j = 0; i < end; i++, j++) {
            arr[j] = text.charAt(i);
        }
        return arr;
    }
}
