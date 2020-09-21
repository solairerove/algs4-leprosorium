package com.github.solairerove.algs4.leprosorium.dynamic;

import java.util.Arrays;

/**
 * given array as coin denominations and n as target amount
 * return smallest number of coins to make change.
 * n = 6
 * [1, 2, 5]
 * 2 -> 1x1 + 5x1
 */
public class MinNumberOfCoinsForChange {
    public static void main(String[] args) {
        int[] a = {1, 2, 5};
        int n = 6;
        System.out.println(minNumOfCoins(a, n));
    }

    private static int minNumOfCoins(int[] a, int n) {
        int[] coinsNum = new int[n + 1];
        Arrays.fill(coinsNum, Integer.MAX_VALUE);
        coinsNum[0] = 0;

        for (var den : a)
            for (var num = 0; num < coinsNum.length; num++)
                if (den <= num) {
                    var curr = coinsNum[num - den];
                    coinsNum[num] = Math.min(coinsNum[num], Integer.MAX_VALUE == curr ? curr : curr + 1);
                }

        return coinsNum[n] == Integer.MAX_VALUE ? -1 : coinsNum[n];
    }
}
