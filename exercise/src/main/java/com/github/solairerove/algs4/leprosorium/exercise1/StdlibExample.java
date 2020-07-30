package com.github.solairerove.algs4.leprosorium.exercise1;

import edu.princeton.cs.algs4.StdOut;

public class StdlibExample {
    public static void main(String[] args) {
        System.out.printf("Fibonacci for n: %s \n", 15);
        fibonacci(15);
    }

    public static void fibonacci(int n) {
        int a = 0;
        int b = 1;

        for (int i = 0; i <= n; ++i) {
            StdOut.print(a + " ");

            a += b;
            b = a - b;
        }
        StdOut.println();
    }
}
