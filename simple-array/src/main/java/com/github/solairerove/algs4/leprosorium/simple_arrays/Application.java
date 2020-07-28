package com.github.solairerove.algs4.leprosorium.simple_arrays;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        double[] a = new double[]{1, 1, 2, 3, 5, 8, 2, 4};

        System.out.printf("For array: %s\n", Arrays.toString(a));
        System.out.printf("Max element is: %s\n", findMax(a));
        System.out.printf("Average value is: %s\n", averageValue(a));
        System.out.printf("New copy of arraY?): %s\n", Arrays.toString(arrayCopy(a)));
        System.out.printf("Reversed array is: %s\n", Arrays.toString(reverseCopy(a)));
        System.out.printf("Steroid reverse is: %s\n", Arrays.toString(steroidReverseCopy(a)));
    }

    private static double findMax(double[] a) {
        double max = a[0];
        for (int i = 1; i < a.length; ++i) {
            if (max < a[i]) {
                max = a[i];
            }
        }

        return max;
    }

    private static double averageValue(double[] a) {
        double sum = 0.0;
        for (double v : a) {
            sum += v;
        }

        return sum / a.length;
    }

    private static double[] arrayCopy(double[] a) {
        int size = a.length;
        double[] b = new double[size];

        System.arraycopy(a, 0, b, 0, size);

        return b;
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
