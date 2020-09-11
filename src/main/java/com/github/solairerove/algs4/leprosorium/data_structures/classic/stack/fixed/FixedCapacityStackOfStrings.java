package com.github.solairerove.algs4.leprosorium.data_structures.classic.stack.fixed;

public class FixedCapacityStackOfStrings {

    private final String[] a;
    private int N;

    public FixedCapacityStackOfStrings(int capacity) {
        a = new String[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(String item) {
        a[N++] = item;
    }

    public String pop() {
        return a[--N];
    }
}
