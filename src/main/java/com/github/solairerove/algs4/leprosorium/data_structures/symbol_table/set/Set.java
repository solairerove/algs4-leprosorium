package com.github.solairerove.algs4.leprosorium.data_structures.symbol_table.set;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeSet;

public class Set<Key extends Comparable<Key>> implements Iterable<Key> {
    private TreeSet<Key> set;

    public Set(Set<Key> x) {
        set = new TreeSet<>(x.set);
    }

    public void add(Key key) {
        if (key == null) throw new IllegalArgumentException("called add() with a null key");
        set.add(key);
    }

    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("called contains() with a null key");
        return set.contains(key);
    }

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("called delete() with a null key");
        set.remove(key);
    }

    public void remove(Key key) {
        if (key == null) throw new IllegalArgumentException("called delete() with a null key");
        set.remove(key);
    }

    public int size() {
        return set.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<Key> iterator() {
        return set.iterator();
    }

    public Key max() {
        if (set.isEmpty()) throw new NoSuchElementException("called max() with empty set");
        return set.last();
    }

    public Key min() {
        if (set.isEmpty()) throw new NoSuchElementException("called min() with empty set");
        return set.first();
    }

    // returns the smallest key in this set greater than or equal to key
    public Key ceiling(Key key) {
        if (key == null) throw new IllegalArgumentException("called ceiling() with a null key");
        Key k = set.ceiling(key);
        if (k == null) throw new NoSuchElementException("all keys are less than " + key);
        return k;
    }

    // Returns the largest key in this set less than or equal to key
    public Key floor(Key key) {
        if (key == null) throw new IllegalArgumentException("called floor() with a null key");
        Key k = set.floor(key);
        if (k == null) throw new NoSuchElementException("all keys are greater than " + key);
        return k;
    }
}
