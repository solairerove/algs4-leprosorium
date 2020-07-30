package com.github.solairerove.algs4.leprosorium.exercise1;

import edu.princeton.cs.algs4.StdOut;

public class StdlibExample {
    public static void main(String[] args) {
        System.out.printf("Fibonacci for n: %s \n", 15);
        fibonacci(15);
        fibonacciMoreClear(80);
        classicFibonacci();
    }

    public static void fibonacci(int n) {
        long a = 0L;
        long b = 1L;

        for (int i = 0; i <= n; ++i) {
            StdOut.print(a + " ");

            a += b;
            b = a - b;
        }
        StdOut.println();
    }

    public static void fibonacciMoreClear(int n) {
        long a = 0L;
        long b = 1L;

        for (int i = 0; i <= n; ++i) {
            StdOut.print(a + " ");

            long temp = a;
            a += b;
            b = temp;
        }
        StdOut.println();
    }

    public static long F(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return F(n - 1) + F(n - 2);
    }

    public static void classicFibonacci() {
        for (int n = 0; n <= 15; n++) {
            StdOut.print(F(n) + " ");
        }
    }
}
