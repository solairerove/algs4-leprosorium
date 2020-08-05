package com.github.solairerove.algs4.leprosorium.simple_collection.linked.fifo;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int N;

    private class Node {
        private Item item;
        private Node next;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        Node oldLast = last;

        last = new Node();
        last.item = item;
        last.next = null;

        if (isEmpty()) {
            first = last;
        } else {
            // TODO: не понял
            oldLast.next = last;
        }

        last.next = oldLast;

        N++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;

        if (isEmpty()) {
            last = null;
        }
        N--;

        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}
