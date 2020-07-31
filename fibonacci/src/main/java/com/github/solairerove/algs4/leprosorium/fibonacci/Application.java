package com.github.solairerove.algs4.leprosorium.fibonacci;

public class Application {
    public static void main(String[] args) {
        fibonacci(15);
        System.out.println();
        fibonacci1(15);
    }

    private static void fibonacci(int n) {
        int a = 0;
        int b = 1;

        for (int i = 0; i <= n; ++i) {
            System.out.printf("%s ", a);

            a += b;
            b = a - b;
        }
    }

    private static void fibonacci1(int n) {
        int a = 0;
        int b = 1;

        for (int i = 0; i <= n; ++i) {
            System.out.printf("%s ", a);

            int temp = a;
            a += b;
            b = temp;
        }
    }
}
