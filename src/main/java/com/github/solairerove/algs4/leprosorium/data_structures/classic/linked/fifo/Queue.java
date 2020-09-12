package com.github.solairerove.algs4.leprosorium.data_structures.classic.linked.fifo;

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
        return first == null;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if (isEmpty()) first = last;
        else oldLast.next = last;

        N++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;

        if (isEmpty()) last = null;
        N--;

        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator(first);
    }

    private class QueueIterator implements Iterator<Item> {
        private Node current;

        public QueueIterator(Node current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;

            return item;
        }
    }
}
