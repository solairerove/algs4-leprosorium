package com.github.solairerove.algs4.leprosorium.sorting;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class InsertionSort {

    public static void sort(Comparable[] a) {

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

        sort(array);
        show(array);
    }
}
