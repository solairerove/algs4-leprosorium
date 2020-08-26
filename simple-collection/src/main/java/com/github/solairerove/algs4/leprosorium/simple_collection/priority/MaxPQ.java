package com.github.solairerove.algs4.leprosorium.simple_collection.priority;

public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N;

    public MaxPQ() {

    }

    public MaxPQ(int max) {

    }

    public MaxPQ(Key[] a) {

    }

    void insert(Key v) {

    }

    Key max() {
        return null;
    }

    Key delMax() {
        return null;
    }

    boolean isEmpty() {
        return false;
    }

    int size() {
        return 0;
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
