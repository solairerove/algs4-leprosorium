package com.github.solairerove.algs4.leprosorium.sorting;

public class QuickSelect {

    public static void main(String[] args) {
        int[] a = new int[]{8, 5, 2, 9, 7, 6, 3};
        System.out.println(select(a, 3));
    }

    public static int select(int[] a, int k) {
        if (k < 0 || k > a.length) {
            throw new IllegalArgumentException();
        }

        int low = 0, high = a.length - 1;

        while (high > low) {
            int j = partition(a, low, high);
            if (j > k) high = j - 1;
            else if (j < k) low = j + 1;
            else return a[j];
        }

        return a[low];
    }

    private static int partition(int[] a, int low, int high) {
        int i = low, j = high + 1;
        int v = a[low];

        while (true) {
            while (less(a[++i], v)) if (i == high) break;
            while (less(v, a[--j])) if (j == low) break;
            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a, low, j);

        return j;
    }

    private static boolean less(int a, int b) {
        if (a == b) return false;
        return a < b;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
