package com.github.solairerove.algs4.leprosorium.dynamic;

/**
 * takes array of numbers and return max sum of non adjacent elements
 */
public class MaxSumOfNoAdjacentElements {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7}; // 16
        System.out.println(maxSum1(a));
    }

    private static int maxSum1(int[] a) {
        int n = a.length;
        if (n == 0) return 0;
        else if (n == 1) return a[0];

        int[] maxSums = new int[n];
        System.arraycopy(a, 0, maxSums, 0, n);
        maxSums[1] = Math.max(a[0], a[1]);
        for (int i = 2; i < n; i++)
            maxSums[i] = Math.max(maxSums[i - 1], maxSums[i - 2] + a[i]);

        return maxSums[n - 1];
    }
}
