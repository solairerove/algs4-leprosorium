package com.github.solairerove.algs4.leprosarium.euclid;

public class Application {
    public static void main(String[] args) {
        System.out.printf("For 9 and 6 highest common factor is: %s\n", nonRecursiveNonInfiniteLoopGCD(9, 6)); // 3
        System.out.printf("For 15 and 5 highest common factor is: %s\n", nonRecursiveNonInfiniteLoopGCD(15, 5)); // 5
        System.out.printf("For 5 and 15 highest common factor is: %s\n", nonRecursiveNonInfiniteLoopGCD(5, 15)); // 5
        System.out.printf("For 13 and 10 highest common factor is: %s\n", nonRecursiveNonInfiniteLoopGCD(13, 10)); // 1
    }

    // greatest common divisor
    private static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }

        int r = p % q;

        return gcd(q, r);
    }

    private static int nonRecursiveGCD(int p, int q) {
        int first = p;
        int second = q;

        while (true) {
            if (second == 0) {
                return first;
            }

            int result = first % second;
            first = second;
            second = result;
        }
    }

    private static int nonRecursiveNonInfiniteLoopGCD(int p, int q) {
        int first = p;
        int second = q;

        int gcd = second;

        while (second != 0) {
            gcd = second;

            int result = first % second;
            first = second;
            second = result;
        }

        return gcd;
    }
}
