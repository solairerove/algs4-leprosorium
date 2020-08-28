package com.github.solairerove.algs4.leprosorium.simple_arrays;

import java.util.Arrays;

public class MoveElementToEnd {
    public static void main(String... args) {
        int[] a = {1, 2, 1, 1, 1, 4, 5, 1};
        System.out.printf("%s ", Arrays.toString(a));
        moveElementToTheEnd(a, 1);
        System.out.printf("%s ", Arrays.toString(a));
    }

    private static void moveElementToTheEnd(int[] a, int k) {
        int low = 0, high = a.length - 1;

        while (high > low) {
            if (k == a[low]) {
                while (high > low && k == a[high]) high--;
                swap(a, low, high);
                high--;
            }
            low++;
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
