package com.github.solairerove.algs4.leprosorium.exercise1;

import edu.princeton.cs.algs4.StdOut;

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

        System.out.println();
        someShit();
        someShit2();
        someShit3();

        System.out.println();
        System.out.println('b');
        System.out.println('b' + 'c');
        System.out.println((char) ('a' + 4));

        System.out.printf("%s in binary string is %s\n", 5, Integer.toBinaryString(5));
        System.out.printf("%s in binary string is %s\n", 1, Integer.toBinaryString(1));
        System.out.printf("%s in binary string is %s\n", 0, Integer.toBinaryString(0));
    }

    private static boolean inRangeOfZeroAndOne(double a, double b) {
        return a < 1.0 && a > 0.0 && b < 1.0 && b > 0.0;
    }

    private static void someShit() {
        double t = 9.0;
        while (Math.abs(t - 9.0 / t) > .001) {
            t = (9.0 / t + t) / 2.0;
        }
        StdOut.printf("%.5f\n", t);
    }

    private static void someShit2() {
        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
        }
        StdOut.println(sum);
    }

    private static void someShit3() {
        int sum = 0;
        for (int i = 1; i < 1000; i *= 2) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
        }
        StdOut.println(sum);
    }
}
