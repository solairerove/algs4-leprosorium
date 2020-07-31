package com.github.solairerove.algs4.leprosorium.exercise1;

public class BoolDoubleDimensionApplication {
    public static void main(String[] args) {
        boolean[][] booleans = new boolean[][]{
                {true, false, false},
                {false, true, true},
                {true, false, true}
        };

        for (boolean[] aBoolean : booleans) {
            for (int k = 0; k < booleans.length; ++k) {
                if (aBoolean[k]) {
                    System.out.printf("%s ", "*");
                } else {
                    System.out.printf("%s ", " ");
                }
            }
            System.out.println();
        }
    }
}
