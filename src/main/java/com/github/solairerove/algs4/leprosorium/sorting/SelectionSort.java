package com.github.solairerove.algs4.leprosorium.sorting;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class SelectionSort {

    // O(n^2) time | O(1) space
    public static void sort(Comparable[] a) {
        int N = a.length;

        for (int i = 0; i < N; ++i) {
            int min = i;
            for (int j = i + 1; j < N; ++j) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            swap(a, i, min);
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (Comparable el : a) {
            StdOut.print(el + " ");
        }
        StdOut.println();
    }

    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; ++i) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String... args) {
        String s = new In("/Users/solairerove/Downloads/algs4-data/tiny.txt").readLine();
        String[] array = s.split(" ");

        show(array);
        sort(array);
        show(array);

        int[] a = new int[]{8, 5, 2, 9, 5, 6, 3};
        System.out.println(Arrays.toString(a));
        selectionSort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void selectionSort(int[] a) {
        int n = a.length;

        for (int i = 0; i < n - 1; i++) {
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }

            int temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }
    }
}