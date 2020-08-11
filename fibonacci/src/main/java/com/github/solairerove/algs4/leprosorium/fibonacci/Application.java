package com.github.solairerove.algs4.leprosorium.fibonacci;

public class Application {
    public static void main(String[] args) {
        fibonacci(15);
        System.out.println();
        fibonacci1(15);
        System.out.printf("\n%sth fibonacci: %s\n", 5, getNthFibonacci(5));
        System.out.printf("%sth fibonacci: %s\n", 6, getNthFibonacci(6));
        System.out.printf("%sth fibonacci: %s\n", 6, getAnotherNthFibonacci(6));
        System.out.printf("%sth fibonacci: %s\n", 6, getForAnotherNthFibonacci(6));
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

    private static int getNthFibonacci(int n) {
        int[] lastTwo = {0, 1};
        int counter = 3;

        while (counter <= n) {
            int next = lastTwo[0] + lastTwo[1];
            lastTwo[0] = lastTwo[1];
            lastTwo[1] = next;

            counter++;
        }

        return n > 1 ? lastTwo[1] : lastTwo[0];
    }

    private static int getAnotherNthFibonacci(int n) {
        int a = 0;
        int b = 1;
        int counter = 3;

        while (counter <= n) {
            int next = a + b;
            a = b;
            b = next;

            counter++;
        }

        return n > 1 ? b : a;
    }

    private static int getForAnotherNthFibonacci(int n) {
        int a = 0;
        int b = 1;

        for (int counter = 3; counter <= n; ++counter) {
            int next = a + b;
            a = b;
            b = next;
        }

        return n > 1 ? b : a;
    }
}
