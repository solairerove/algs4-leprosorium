package com.github.solairerove.algs4.leprosorium.arrays;

import java.util.Arrays;

/**
 * Takes two non-empty arrays, finds pair with difference is closest to zero.
 */
public class SmallestDifference {
    public static void main(String... args) {
        int[] a = {1, 5, 3, 19, 18, 25};
        int[] b = {12, 20, -4, 31, 26, 100};

        System.out.println(Arrays.toString(smallestDifference(a, b)));
    }

    // O(nlog(n) + mlog(m)) time | O(1) space
    private static int[] smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        int idxOne = 0, idxTwo = 0;
        int smallest = Integer.MAX_VALUE;
        int[] smallestPair = new int[2];

        while (idxOne < a.length && idxTwo < b.length) {
            int firstNum = a[idxOne], secondNum = b[idxTwo];
            var current = Math.abs(secondNum - firstNum);

            if (firstNum < secondNum) idxOne++;
            else if (firstNum > secondNum) idxTwo++;
            else return new int[]{firstNum, secondNum};

            if (current < smallest) {
                smallest = current;
                smallestPair = new int[]{firstNum, secondNum};
            }
        }

        return smallestPair;
    }
}
