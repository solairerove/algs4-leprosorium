package com.github.solairerove.algs4.leprosorium.simple_arrays;

import java.util.Arrays;

/**
 * takes array and return max sum, by summing ints of subarray.
 * Kadane's algo
 */
public class MaxSubArraySumApplication {
    public static void main(String... args) {
        int[] a = {2, 3, 4, 5, 7}; // 21
        System.out.printf("%s %s\n", Arrays.toString(a), maxSubArraySum(a));

        int[] b = {-2, -3, 4, -1, -2, 1, 5, -3}; // 7
        System.out.printf("%s %s\n", Arrays.toString(b), maxSubArraySum(b));

        int[] c = {11, -5, -5, -2, 1, 2, 3, 4, 5, 0, 1}; // 16
        System.out.printf("%s %s\n", Arrays.toString(c), maxSubArraySum(c));

        int[] d = {9, -5, -5, -2, 1, 2, -1, 4, 5, 0, 1}; // 12
        System.out.printf("%s %s\n", Arrays.toString(d), maxSubArraySum(d));

        int[] e = {-1, -2, -3, -4, -5}; // -1
        System.out.printf("%s %s\n", Arrays.toString(e), maxSubArraySum(e));

        int[] f = {-2}; // -2
        System.out.printf("%s %s\n", Arrays.toString(f), maxSubArraySum(f));

        int[] g = {3}; // 3
        System.out.printf("%s %s\n", Arrays.toString(g), maxSubArraySum(g));

        int[] h = {3, -1, -1, 10, -3, -2, 4}; // 11
        System.out.printf("%s %s\n", Arrays.toString(h), maxSubArraySum(h));
    }

    // O(n) time | O(1) space
    private static int maxSubArraySum(int[] a) {
        int madMax = a[0];
        int superMax = a[0];

        for (int i = 1; i < a.length; i++) {
            int num = a[i];

            madMax = Math.max(num, madMax + num);
            superMax = Math.max(madMax, superMax);
        }

        return superMax;
    }
}
