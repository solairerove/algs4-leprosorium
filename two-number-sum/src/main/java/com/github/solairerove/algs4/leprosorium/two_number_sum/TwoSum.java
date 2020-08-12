package com.github.solairerove.algs4.leprosorium.two_number_sum;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;

import java.util.Arrays;

/**
 * Подсчет пар чисел с нулевой суммой
 */
public class TwoSum {

    public static void main(String[] args) {
        var path = "/Users/solairerove/Downloads/algs4-data/1Kints.txt";
        int[] array = new In(path).readAllInts();

        System.out.printf("Null sum count: %s", count(array));
    }

    // O(nlog(n)) time | O(1) space
    private static int count(int[] a) {
        Arrays.sort(a);

        int cnt = 0;

        for (int i = 0; i < a.length; ++i) {
            if (BinarySearch.indexOf(a, -a[i]) > i) {
                cnt++;
            }
        }

        return cnt;
    }
}
