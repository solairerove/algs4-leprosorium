package com.github.solairerove.algs4.leprosorium.exercise1;

public class Main {
    public static void main(String[] args) {
        System.out.printf("15 / 2 = %s\n", 15 / 2);
        System.out.printf("2.0e-6 * 100000000.1 = %s\n", 2.0e-6 * 100000000.1);
        System.out.printf("true && false || true && true = %s\n", true);

        System.out.println();

        System.out.printf("(1 + 2.236) / 2 = %s\n", (1 + 2.236) / 2);
        System.out.printf("1 + 2 + 3 + 4.0 = %s\n", 1 + 2 + 3 + 4.0);
        System.out.printf("4.1 > 4 = %s\n", true);
        System.out.printf("1 + 2 + \"3\" = %s\n", 1 + 2 + "3");

        System.out.println();

        System.out.printf("a = %s, b = %s in range of 0 and 1 %s\n", 1, 2, inRangeOfZeroAndOne(1, 2));
        System.out.printf("a = %s, b = %s in range of 0 and 1 %s\n", 1.0, 2.0, inRangeOfZeroAndOne(1.0, 2.0));
        System.out.printf("a = %s, b = %s in range of 0 and 1 %s\n", 0.5, 2.0, inRangeOfZeroAndOne(0.5, 2.0));
        System.out.printf("a = %s, b = %s in range of 0 and 1 %s\n", 0.5, 0.1, inRangeOfZeroAndOne(0.5, 0.1));
    }

    private static boolean inRangeOfZeroAndOne(double a, double b) {
        return a < 1.0 && a > 0.0 && b < 1.0 && b > 0.0;
    }
}
