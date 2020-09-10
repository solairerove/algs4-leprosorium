package com.github.solairerove.algs4.leprosorium.arrays;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        double[] a = new double[]{1, 1, 2, 3, 5, 8, 2, 4, 3};

        System.out.printf("Reversed array is: %s\n", Arrays.toString(reverseCopy(a)));
        System.out.printf("Steroid reverse is: %s\n", Arrays.toString(steroidReverseCopy(a)));
    }

    private static double[] reverseCopy(double[] a) {
        int size = a.length;
        double[] b = new double[size];

        for (int i = 0; i < size; ++i) {
            b[size - i - 1] = a[i];
        }

        return b;
    }

    private static double[] steroidReverseCopy(double[] a) {
        int length = a.length;

        for (int i = 0; i < length / 2; ++i) {
            double temp = a[i];
            a[i] = a[length - i - 1];
            a[length - i - 1] = temp;
        }

        return a;
    }
}
