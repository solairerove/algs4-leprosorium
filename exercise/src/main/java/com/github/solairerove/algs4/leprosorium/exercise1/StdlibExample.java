package com.github.solairerove.algs4.leprosorium.exercise1;

import edu.princeton.cs.algs4.StdOut;

public class StdlibExample {
    public static void main(String[] args) {
        int f = 0;
        int g = 1;

        for (int i = 0; i <= 15; i++) {
            StdOut.println(f);
            f = f + g;
            g = f - g;
        }
    }
}
