package com.github.solairerove.algs4.leprosorium.data_structures.classic.priority;

public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N;

    public MaxPQ() {

    }

    public MaxPQ(int max) {
        pq = (Key[]) new Comparable[max + 1];
    }

    public MaxPQ(Key[] a) {

    }

    void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    Key max() {
        return null;
    }

    Key delMax() {
        Key max = pq[1];
        swap(1, N--);
        pq[N + 1] = null;
        sink(1);

        return max;
    }

    boolean isEmpty() {
        return N == 0;
    }

    int size() {
        return N;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void swap(int i, int j) {
        var temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            swap(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            swap(k, j);
            k = j;
        }
    }
}
