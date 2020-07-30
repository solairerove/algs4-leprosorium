package com.github.solairerove.algs4.leprosorium.exercise1;

public class IntEqualArgsApplication {
    public static void main(String... args) {

        int a = parseInt(args[0]);
        int b = parseInt(args[1]);
        int c = parseInt(args[2]);

        if (a == b && b == c) {
            System.out.println("equal");
        } else {
            System.out.println("nah");
        }
    }

    private static Integer parseInt(String arg) {
        return Integer.parseInt(arg);
    }
}
