package com.github.solairerove.algs4.leprosorium.two_number_sum;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Подсчет трех чисел с нулевой суммой
 */
public class ThreeSum {

    public static void main(String[] args) {
        var path = "/Users/solairerove/Downloads/algs4-data/1Kints.txt";
        int[] array = new In(path).readAllInts();

        System.out.printf("Null sum count: %s", count(array));

        int[] b = new int[]{12, 3, 1, 2, -6, 5, -8, 6};
        int targetSum = 0;
        System.out.printf("\n%s with %s\n", Arrays.toString(b), targetSum);
        List<Integer[]> integers = threeNumberSum(b, targetSum);
        System.out.print("[");
        integers.forEach(el -> System.out.printf("%s", Arrays.toString(el)));
        System.out.print("]");

        List<Integer[]> integers2 = threeNumberSum2(b, targetSum);
        System.out.print("\n[");
        integers2.forEach(el -> System.out.printf("%s", Arrays.toString(el)));
        System.out.print("]");
    }

    // O(n^2 * log(n)) time | O(1) space
    private static int count(int[] a) {
        Arrays.sort(a);

        int N = a.length;
        int cnt = 0;

        for (int i = 0; i < N; ++i) {
            for (int j = i + 1; j < N; ++j) {
                if (BinarySearch.indexOf(a, -a[i] - a[j]) > j) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    /**
     * Find all triplets in the array that sum up to the target sum,
     * and a two dimensional array of all these triplets.
     */
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        List<Integer[]> triplets = new ArrayList<>();

        for (int i = 0; i < array.length; ++i) {
            for (int j = i + 1; j < array.length; ++j) {
                int num = targetSum - (array[i] + array[j]);

                if (rank(array, num) > j) {
                    Integer[] triplet = {array[i], array[j], num};
                    triplets.add(triplet);
                }
            }
        }

        return triplets;
    }

    private static int rank(int[] array, int key) {
        int length = array.length;
        int low = 0;
        int high = length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (key < array[mid]) high = mid - 1;
            else if (key > array[mid]) low = mid + 1;
            else return mid;
        }

        return -1;
    }

    // O(n^2) time | O(n) space
    private static List<Integer[]> threeNumberSum2(int[] array, int targetSum) {
        Arrays.sort(array);

        List<Integer[]> triplets = new ArrayList<>();
        for (int i = 0; i < array.length - 2; ++i) {
            int low = i + 1;
            int high = array.length - 1;

            while (low < high) {
                int currentSum = array[i] + array[low] + array[high];

                if (currentSum > targetSum) {
                    high--;
                } else if (currentSum < targetSum) {
                    low++;
                } else {
                    Integer[] triplet = {array[i], array[low], array[high]};
                    triplets.add(triplet);

                    low++;
                    high--;
                }
            }
        }

        return triplets;
    }
}
