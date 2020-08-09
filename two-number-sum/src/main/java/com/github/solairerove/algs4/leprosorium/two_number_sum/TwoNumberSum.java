package com.github.solairerove.algs4.leprosorium.two_number_sum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Write a function that takes in a non-empty array of distinct integers and an integer
 * representing a target sum. If any two numbers in the input array sum up to the
 * target sum, the function should return them in an array, in any order. If no two
 * numbers sum up tp the target sum, the function should return an empty array;
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

        int[] b = new int[]{55, 66, 77, -2, 2, -3};
        int targetSumB = -5;

        System.out.printf("Target sum: %s for %s -> %s\n",
                targetSum, Arrays.toString(a), Arrays.toString(twoNumberSum(a, targetSum)));
        System.out.printf("Target sum: %s for %s -> %s\n",
                targetSum, Arrays.toString(a), Arrays.toString(twoNumberSum2(a, targetSum)));
        System.out.printf("Target sum: %s for %s -> %s\n",
                targetSum, Arrays.toString(a), Arrays.toString(twoNumberSum3(a, targetSum)));

        System.out.printf("Target sum: %s for %s -> %s\n",
                targetSumB, Arrays.toString(b), Arrays.toString(twoNumberSum(b, targetSumB)));
        System.out.printf("Target sum: %s for %s -> %s\n",
                targetSumB, Arrays.toString(b), Arrays.toString(twoNumberSum2(b, targetSumB)));
        System.out.printf("Target sum: %s for %s -> %s\n",
                targetSumB, Arrays.toString(b), Arrays.toString(twoNumberSum3(b, targetSumB)));
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

    // O(N) time | O(N) space
    public static int[] twoNumberSum2(int[] array, int targetSum) {
        Set<Integer> nums = new HashSet<>();

        for (int num : array) {
            int potential = targetSum - num;
            if (nums.contains(potential)) {
                return new int[]{num, potential};
            } else {
                nums.add(num);
            }
        }

        return new int[0];
    }

    // O(Nlog(N)) time | O(1) space
    public static int[] twoNumberSum3(int[] array, int targetSum) {
        Arrays.sort(array);

        int low = 0;
        int high = array.length - 1;

        while (low < high) {
            int currentSum = array[low] + array[high];
            if (currentSum == targetSum) {
                return new int[]{array[low], array[high]};
            } else if (currentSum < targetSum) {
                low++;
            } else {
                high--;
            }
        }

        return new int[0];
    }
}
