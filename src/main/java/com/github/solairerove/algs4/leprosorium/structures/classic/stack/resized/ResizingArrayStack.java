package com.github.solairerove.algs4.leprosorium.structures.classic.stack.resized;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {

    private Item[] a = (Item[]) new Object[1];
    private int N = 0;

    public boolean isEmpty() {
        return this.N == 0;
    }

    public int size() {
        return this.N;
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];

        for (int i = 0; i < this.N; ++i) {
            temp[i] = this.a[i];
        }
        this.a = temp;
    }

    public void push(Item item) {
        if (this.N == this.a.length) {
            this.resize(this.a.length * 2);
        }

        this.a[this.N++] = item;
    }

    public Item pop() {
        Item item = this.a[--this.N];
        this.a[this.N] = null;
        if (this.N == this.a.length / 4) {
            this.resize(this.a.length / 2);
        }

        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {

        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }
    }
}
