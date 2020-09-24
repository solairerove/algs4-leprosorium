package com.github.solairerove.algs4.leprosorium.dynamic;

/**
 * takes two strings and return min number of edit ops
 * to obtain second string from first.
 */
public class LevenshteinDistance {
    public static void main(String... args) {
        System.out.println(levenshteinDistance("abc", "abcz"));
        System.out.println(levenshteinDistance("abcd", "abczy"));
    }

    // O(nm) time | O(nm) space
    private static int levenshteinDistance(String s1, String s2) {
        int n1 = s1.length() + 1, n2 = s2.length() + 1;
        int[][] edits = new int[n1][n2];

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                edits[i][j] = j;
            }
            edits[i][0] = i;
        }

        for (int i = 1; i < n1; i++) {
            for (int j = 1; j < n2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    edits[i][j] = edits[i - 1][j - 1];
                } else {
                    edits[i][j] = 1 + Math.min(edits[i - 1][j - 1], Math.min(edits[i][j - 1], edits[i - 1][j]));
                }
            }
        }

        return edits[n1 - 1][n2 - 1];
    }
}
