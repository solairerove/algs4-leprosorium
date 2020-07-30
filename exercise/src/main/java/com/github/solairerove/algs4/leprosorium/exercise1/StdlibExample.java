package com.github.solairerove.algs4.leprosorium.exercise1;

import edu.princeton.cs.algs4.StdOut;

public class StdlibExample {
    public static void main(String[] args) {
        System.out.printf("Fibonacci for n: %s \n", 15);
        fibonacci(15);
        fibonacciMoreClear(15);
        recursiveFibonacci(15);
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

    public static void fibonacciMoreClear(int n) {
        int a = 0;
        int b = 1;

        for (int i = 0; i <= n; ++i) {
            StdOut.print(a + " ");

            int temp = a;
            a += b;
            b = temp;
        }
        StdOut.println();
    }

    public static void recursiveFibonacci(int n) {
        recursiveFibonacci(n, 0, 0, 1);
    }

    public static void recursiveFibonacci(int n, int i, int a, int b) {
        if (i <= n) {
            StdOut.print(a + " ");

            a += b;
            b = a - b;
            i++;

            recursiveFibonacci(n, i, a, b);
        }
    }
}
