package com.github.solairerove.algs4.leprosorium.binary;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 2, 3, 5, 8, 11, 15, 33};

        System.out.printf("For array: %s\n", Arrays.toString(a));
        System.out.printf("Index of element %s is %s\n", 8, rank(8, a));
        System.out.printf("Index of element %s is %s\n", 8, ownRank(8, a));
    }

    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1);
    }

    public static int rank(int key, int[] a, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }

        int mid = lo + (hi - lo) / 2;

        if (key < a[mid]) {
            return rank(key, a, lo, mid - 1);
        } else if (key > a[mid]) {
            return rank(key, a, mid + 1, hi);
        } else {
            return mid;
        }
    }

    public static int ownRank(int key, int[] a) {
        int length = a.length;
        int low = 0;
        int high = length - 1;

        do {
            if (low > high) {
                return -1;
            }

            int mid = low + (high - low) / 2;

            if (key < a[mid]) {
                high = mid - 1;
            } else if (key > a[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        } while (true);
    }
}
