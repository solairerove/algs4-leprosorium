package com.github.solairerove.algs4.leprosorium.simple_arrays;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        double[] a = new double[]{1, 1, 2, 3, 5, 8, 2, 4};

        System.out.printf("For array: %s\n", Arrays.toString(a));
        System.out.printf("Max element is: %s\n", findMax(a));
        System.out.printf("Average value is: %s\n", averageValue(a));
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
}
