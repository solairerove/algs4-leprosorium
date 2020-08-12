package com.github.solairerove.algs4.leprosorium.two_number_sum;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;

import java.util.Arrays;

/**
 * Подсчет трех чисел с нулевой суммой
 */
public class ThreeSum {

    public static void main(String[] args) {
        var path = "/Users/solairerove/Downloads/algs4-data/1Kints.txt";
        int[] array = new In(path).readAllInts();

        System.out.printf("Null sum count: %s", count(array));
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
}
