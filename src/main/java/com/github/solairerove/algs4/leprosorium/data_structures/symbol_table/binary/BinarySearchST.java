package com.github.solairerove.algs4.leprosorium.data_structures.symbol_table.binary;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] values;
    private int n;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Value get(Key key) {
        if (isEmpty()) return null;

        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) return values[i];
        else return null;
    }

    public void put(Key key, Value value) {
        int i = rank(key);

        if (i < n && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }

        // сдвиг вправо
        for (int j = n; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        n++;
    }

    public int rank(Key key) {
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = key.compareTo(keys[mid]);

            if (cmp < 0) high = mid - 1;
            else if (cmp > 0) low = mid + 1;
            else return mid;
        }

        return low;
    }
}
