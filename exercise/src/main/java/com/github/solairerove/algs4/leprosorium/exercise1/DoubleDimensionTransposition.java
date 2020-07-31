package com.github.solairerove.algs4.leprosorium.exercise1;

public class DoubleDimensionTransposition {
    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1, 2, 3, 4},
                {1, 2, 3, 4},
                {1, 2, 3, 4}
        };

        for (int i = 0; i < a[0].length; i++) {
            for (int[] ints : a) {
                System.out.printf("%s ", ints[i]);
            }
            System.out.println();
        }
    }
}
