package com.github.solairerove.algs4.leprosorium.data_structures.symbol_table.hash;

import com.github.solairerove.algs4.leprosorium.data_structures.symbol_table.sequential.SequentialSearchST;

public class SeparateChainingHashST<Key, Value> {
    private static final int INIT_CAPACITY = 4;

    private int n; // number of key-value pairs
    private int m; // hash table size
    private SequentialSearchST<Key, Value>[] st; // array of linked list tables

    public SeparateChainingHashST() {
        this(INIT_CAPACITY);
    }

    public SeparateChainingHashST(int m) {
        this.m = m;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
        for (int i = 0; i < m; i++) st[i] = new SequentialSearchST<>();
    }

    private void resize(int chains) {

    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        int i = hash(key);
        return st[i].get(key);
    }

    public void put(Key key, Value value) {
        if (key == null) throw new IllegalArgumentException("key argument to put() is null");

        if (n >= 10 * m) resize(2 * m);

        int i = hash(key);
        if (!st[i].contains(key)) n++;
        st[i].put(key, value);
    }
}
