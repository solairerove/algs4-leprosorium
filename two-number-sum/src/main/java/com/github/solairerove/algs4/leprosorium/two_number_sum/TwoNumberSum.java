package com.github.solairerove.algs4.leprosorium.two_number_sum;

import java.util.Arrays;

/**
 * Write a function that takes in a non-empty array of distinct integers and an integer
 * representing a target sum. If any two numbers in the input array sum up to the
 * target sum, the function should return them in an array, in any order. If no two
 * numbers sum up tp the target sum, the function should return an empty array;
 * <p>
 * Known issues:
 * - you can assume that there will be at most one pair of numbers summing up to the
 * target sum
 * <p>
 * Sample Input
 * array = [-1, 2, 3, 4, 5, -2, -3, 4]
 * targetSum = -4
 * <p>
 * Sample Output
 * [-3, -1]
 */
public class TwoNumberSum {

    public static void main(String[] args) {
        int[] a = new int[]{-1, 2, 3, 4, 5, -2, -3, 4};
        int targetSum = 4;

        int[] b = new int[]{3, 5, -4, 8, 11, 1, -1, 6};
        int targetSumB = 10;

        System.out.printf("Target sum: %s for %s -> %s\n",
                targetSum, Arrays.toString(a), Arrays.toString(twoNumberSum(a, targetSum)));

        System.out.printf("Target sum: %s for %s -> %s\n",
                targetSumB, Arrays.toString(b), Arrays.toString(twoNumberSum(b, targetSumB)));
    }

    // O(N^2) time | O(1) space
    public static int[] twoNumberSum(int[] array, int targetSum) {
        int[] b = new int[2];

        for (int value : array) {
            for (int i : array) {
                if (value + i == targetSum) {
                    b[0] = value;
                    b[1] = i;
                }
            }
        }

        return b;
    }
}
