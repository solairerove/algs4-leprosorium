package com.github.solairerove.algs4.leprosorium.sorting;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class SortCompare {
    public static double time(String alg, Double[] a) {
        Stopwatch stopwatch = new Stopwatch();
        if ("Selection".equals(alg)) SelectionSort.sort(a);
        if ("Insertion".equals(alg)) InsertionSort.sort(a);
        if ("Bubble".equals(alg)) BubbleSort.sort(a);
        if ("Shell".equals(alg)) ShellSort.sort(a);
        if ("Merge".equals(alg)) MergeSort.sort(a);

        return stopwatch.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;

        Double[] a = new Double[N];

        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }
            total += time(alg, a);
        }

        return total;
    }

    public static void main(String[] args) {
        String alg1 = "Selection";
        String alg2 = "Insertion";
        String alg3 = "Bubble";
        String alg4 = "Shell";
        String alg5 = "Merge";
        int N = 10000;
        int T = 100;

//        double t1 = timeRandomInput(alg1, N, T);
//        double t2 = timeRandomInput(alg2, N, T);
//        double t3 = timeRandomInput(alg3, N, T);
        double t4 = timeRandomInput(alg4, N, T);
        double t5 = timeRandomInput(alg5, N, T);

//        StdOut.printf("For %d random Doubles\n %s in", N, alg1);
//        StdOut.printf(" %.1f times faster than %s\n", t2 / t1, alg2);
//
//        StdOut.printf("For %d random Doubles\n %s in", N, alg2);
//        StdOut.printf(" %.1f times faster than %s\n", t3 / t2, alg3);
//
//        StdOut.printf("For %d random Doubles\n %s in", N, alg1);
//        StdOut.printf(" %.1f times faster than %s\n", t3 / t1, alg3);
//
//        StdOut.printf("For %d random Doubles\n %s in", N, alg4);
//        StdOut.printf(" %.1f times faster than %s\n", t2 / t4, alg2);
//
//        StdOut.printf("For %d random Doubles\n %s in", N, alg4);
//        StdOut.printf(" %.1f times faster than %s\n", t1 / t4, alg1);

        StdOut.printf("For %d random Doubles\n %s in", N, alg4);
        StdOut.printf(" %.1f times faster than %s\n", t5 / t4, alg5);
    }
}
