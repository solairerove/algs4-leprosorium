package com.github.solairerove.algs4.leprosorium.dynamic;

import java.util.Arrays;

/**
 * arrays as coin denominations and n as target amount.
 * return number of ways to make change for that target sum
 */
public class NumberOfWaysToMakeChange {
    public static void main(String[] args) {
        int n = 5;
        int[] a = {1, 4};
        System.out.println(numberOfWays(a, n));

        int n1 = 10;
        int[] a1 = {1, 5, 10, 25};
        System.out.printf("Number of ways for %s is %s", Arrays.toString(a1), numberOfWays(a1, n1));
    }

    private static int numberOfWays(int[] a, int n) {
        int[] ways = new int[n + 1];
        ways[0] = 1;
        for (int d : a)
            for (int amount = 1; amount < n + 1; amount++)
                if (d <= amount) ways[amount] += ways[amount - d];

        return ways[n];
    }
}
