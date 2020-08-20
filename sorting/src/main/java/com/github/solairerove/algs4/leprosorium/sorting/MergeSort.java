package com.github.solairerove.algs4.leprosorium.sorting;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class MergeSort {

    private static Comparable[] aux;

    // O(nlog(n)) time | O(n) space
    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int low, int high) {
        if (high <= low) return;

        int mid = low + (high - low) / 2;
        sort(a, low, mid);
        sort(a, mid + 1, high);
        merge(a, low, mid, high);
    }

    private static void merge(Comparable[] a, int low, int mid, int high) {
        // merge a[low..mid] with a[mid+1..high]
        int i = low, j = mid + 1;

        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
        }

        for (int k = low; k <= high; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > high) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
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
        sortTD(a);
        System.out.println(Arrays.toString(a));
    }

    private static void sortTD(int[] a) {
        int n = a.length;

        int[] aux = new int[n];
        sortTD(a, aux, 0, n - 1);
    }

    private static void sortTD(int[] a, int[] aux, int low, int high) {
        if (high <= low) {
            return;
        }

        int mid = low + (high - low) / 2;

        sortTD(a, aux, low, mid);
        sortTD(a, aux, mid + 1, high);
        merge(a, aux, low, mid, high);
    }

    private static void merge(int[] a, int[] aux, int low, int mid, int high) {
        int i = low, j = mid + 1;

        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
        }

        for (int k = low; k <= high; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > high) a[k] = aux[i++];
            else if (aux[j] < aux[i]) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }
}
