package com.github.solairerove.algs4.leprosorium.two_number_sum;

import edu.princeton.cs.algs4.BinarySearch;

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
                targetSum, Arrays.toString(a), Arrays.toString(twoNumberSum4(a, targetSum)));
        System.out.printf("Target sum: %s for %s -> %s\n",
                targetSum, Arrays.toString(a), Arrays.toString(thoNumbersSum5(a, targetSum)));

        System.out.printf("Target sum: %s for %s -> %s\n",
                targetSumB, Arrays.toString(b), Arrays.toString(twoNumberSum(b, targetSumB)));
        System.out.printf("Target sum: %s for %s -> %s\n",
                targetSumB, Arrays.toString(b), Arrays.toString(twoNumberSum2(b, targetSumB)));
        System.out.printf("Target sum: %s for %s -> %s\n",
                targetSumB, Arrays.toString(b), Arrays.toString(twoNumberSum3(b, targetSumB)));
        System.out.printf("Target sum: %s for %s -> %s\n",
                targetSumB, Arrays.toString(b), Arrays.toString(twoNumberSum4(b, targetSumB)));
        System.out.printf("Target sum: %s for %s -> %s\n",
                targetSumB, Arrays.toString(b), Arrays.toString(thoNumbersSum5(b, targetSumB)));
    }

    // O(N^2) time | O(1) space
    public static int[] twoNumberSum(int[] array, int targetSum) {
        for (int i = 0; i < array.length - 1; ++i) {
            for (int j = i + 1; j < array.length; ++j) {
                if (targetSum == array[i] + array[j]) {
                    return new int[]{array[i], array[j]};
                }
            }
        }


        return new int[0];
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

    // O(Nlog(N)) time | O(1) space
    public static int[] twoNumberSum4(int[] array, int targetSum) {
        Arrays.sort(array);

        for (int i = 0; i < array.length; ++i) {
            int num = targetSum - array[i];

            if (BinarySearch.indexOf(array, num) > i) {
                return new int[]{num, array[i]};
            }
        }

        return new int[0];
    }

    // O(Nlog(N)) time | O(1) space
    public static int[] thoNumbersSum5(int[] array, int targetSum) {
        Arrays.sort(array);

        for (int i = 0; i < array.length; ++i) {
            int current = array[i];
            int num = targetSum - current;

            if (binaryIndexOf(array, num) > i) {
                return new int[]{num, current};
            }
        }

        return new int[0];
    }

    private static int binaryIndexOf(int[] array, int key) {
        int length = array.length;

        int low = 0;
        int high = length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (key < array[mid]) {
                high = mid - 1;
            } else if (key > array[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
