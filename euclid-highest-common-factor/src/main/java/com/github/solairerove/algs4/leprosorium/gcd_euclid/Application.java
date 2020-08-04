package com.github.solairerove.algs4.leprosorium.gcd_euclid;

public class Application {
    public static void main(String[] args) {
        System.out.printf("For 9 and 6 highest common factor is: %s\n", ownGcd(9, 6)); // 3
        System.out.printf("For 15 and 5 highest common factor is: %s\n", ownGcd(15, 5)); // 5
        System.out.printf("For 5 and 15 highest common factor is: %s\n", ownGcd(5, 15)); // 5
        System.out.printf("For 13 and 10 highest common factor is: %s\n", ownGcd(13, 10)); // 1
        System.out.printf("For 105 and 24 highest common factor is: %s\n", ownGcd(105, 24)); // 3
        System.out.printf("For 1111111 and 1234567 highest common factor is: %s\n", ownGcd(1111111, 1234567)); // 1
        System.out.printf("For 98 and 56 highest common factor is: %s\n", ownGcd(98, 56)); // 14
        System.out.printf("For 48 and 18 highest common factor is: %s\n", ownGcd(48, 18)); // 6
    }

    // greatest common divisor
    private static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }

        int r = p % q;

        return gcd(q, r);
    }

    public static int ownGcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }
}
