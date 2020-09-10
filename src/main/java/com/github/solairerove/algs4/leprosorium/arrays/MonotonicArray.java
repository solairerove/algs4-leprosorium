package com.github.solairerove.algs4.leprosorium.arrays;

import java.util.Arrays;

/**
 * from left to right non increase or non decrease
 */
public class MonotonicArray {
    public static void main(String[] args) {
        int[] a = {-2, -5, -5, -6, -20, -30, -1000};
        System.out.printf("%s %s", Arrays.toString(a), isMonotonic(a));
    }

    private static boolean isMonotonic(int[] a) {
        int n = a.length;

        boolean inc = true;
        boolean dec = true;

        for (int i = 1; i < n; i++) {
            if (a[i] > a[i - 1]) {
                inc = false;
            }

            if (a[i] < a[i - 1]) {
                dec = false;
            }
        }

        return inc || dec;
    }
}
