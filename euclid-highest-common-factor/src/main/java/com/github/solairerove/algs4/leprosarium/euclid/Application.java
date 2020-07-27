package com.github.solairerove.algs4.leprosarium.euclid;

public class Application {
    public static void main(String[] args) {
        System.out.printf("For 9 and 6 highest common factor is: %s\n", gcd(9, 6));
        System.out.printf("For 15 and 5 highest common factor is: %s\n", gcd(15, 5));
        System.out.printf("For 5 and 15 highest common factor is: %s\n", gcd(5, 15));
    }

    // greatest common divisor
    private static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }

        int r = p % q;
        return gcd(q, r);
    }
}
