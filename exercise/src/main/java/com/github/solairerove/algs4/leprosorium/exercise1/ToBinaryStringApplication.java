package com.github.solairerove.algs4.leprosorium.exercise1;

public class ToBinaryStringApplication {
    public static void main(String[] args) {
        System.out.printf("Binary string is: %s for: %s\n", Integer.toBinaryString(5), 5);
        System.out.printf("Binary string is: %s for: %s\n", Integer.toBinaryString(10), 10);
        System.out.printf("Binary string is: %s for: %s\n\n", Integer.toBinaryString(2), 2);

        System.out.printf("Binary string is: %s for: %s\n", toBinaryString(5), 5);
        System.out.printf("Binary string is: %s for: %s\n", toBinaryString(10), 10);
        System.out.printf("Binary string is: %s for: %s\n", toBinaryString(2), 2);
    }

    private static String toBinaryString(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n; i > 0; i /= 2) {
            // s = (i % 2) + s;
            stringBuilder.insert(0, i % 2);
        }

        return stringBuilder.toString();
    }
}
