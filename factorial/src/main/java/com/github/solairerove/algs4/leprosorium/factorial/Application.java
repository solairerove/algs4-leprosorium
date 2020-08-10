package com.github.solairerove.algs4.leprosorium.factorial;

public class Application {
    public static void main(String... args) {
        System.out.printf("Factorial for %s is %s\n", 5, factorial(5));
        System.out.printf("Factorial for %s is %s\n", 3, factorial(3));
        System.out.printf("Factorial for %s is %s\n", 10, factorial(10));
    }

    private static int factorial(int n) {
        int r = 1;
        for (int i = 1; i <= n; ++i) r *= i;

        return r;
    }
}
