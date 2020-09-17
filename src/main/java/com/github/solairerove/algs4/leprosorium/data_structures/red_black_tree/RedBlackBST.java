package com.github.solairerove.algs4.leprosorium.data_structures.red_black_tree;

public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private Node root;

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private boolean color;
        private int n;

        public Node(Key key, Value value, boolean color, int n) {
            this.key = key;
            this.value = value;
            this.color = color;
            this.n = n;
        }
    }

    /***************************************************************************
     *  Node helper methods.
     ***************************************************************************/

    // is node x red; false if x is null ?
    private boolean isRed(Node x) {
        if (x == null) return false;
        return RED == x.color;
    }

    /**
     * Is this symbol table empty?
     *
     * @return {@code true} if this symbol table is empty and {@code false} otherwise
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return size(root);
    }

    // number of node in subtree rooted at x; 0 if x is null
    private int size(Node x) {
        if (x == null) return 0;
        else return x.n;
    }

    /***************************************************************************
     *  Standard BST search.
     ***************************************************************************/

    // value associated with the given key in subtree rooted at x; null if no such key
    private Value get(Node x, Key key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);

            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.value;
        }

        return null;
    }

    /**
     * Returns the value associated with the given key.
     *
     * @param key the key
     * @return the value associated with the given key if the key is in the symbol table
     * and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        return get(root, key);
    }

    /**
     * Does this symbol table contain the given key?
     *
     * @param key the key
     * @return {@code true} if this symbol table contains {@code key} and
     * {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }

    /***************************************************************************
     *  Red-black tree insertion.
     ***************************************************************************/

    // insert the key-value pair in the subtree rooted at h
    private Node put(Node h, Key key, Value value) {
        if (h == null) return new Node(key, value, RED, 1);

        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, key, value);
        else if (cmp > 0) h.right = put(h.right, key, value);
        else h.value = value;

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        h.n = size(h.left) + size(h.right) + 1;
        return h;
    }

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param key   the key
     * @param value the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(Key key, Value value) {
        /*
         if (key == null) throw  new IllegalArgumentException("first argument to put is null");
         if (value == null) {
            delete(key);
            return;
        }
        */
        root = put(root, key, value);
        root.color = BLACK;
    }

    /***************************************************************************
     *  Red-black tree deletion.
     ***************************************************************************/

    // delete the key-value pair with the minimum key rooted at h
    private Node deleteMin(Node h) {
        return h;
    }

    /***************************************************************************
     *  Red-black tree helper functions.
     ***************************************************************************/

    // make a right-leaning link lean to the left
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;

        // x.color = x.left.color;
        // x.left.color = RED;
        x.color = h.color;
        h.color = RED;

        x.n = h.n;
        h.n = 1 + size(h.left) + size(x.right);
        return x;
    }

    // make a left-leaning link lean to the right
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;

        // x.color = x.right.color;
        // x.right.color = RED;
        x.color = h.color;
        h.color = RED;

        x.n = h.n;
        h.n = 1 + size(h.left) + size(h.right);
        return x;
    }

    // flip the colors of a node and its two children
    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    private Node balance(Node h) {
        if (isRed(h.right)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        h.n = size(h.left) + size(h.right) + 1;
        return h;
    }

    // Assuming that h is red and both h.left and h.left.left
    // are black, make h.left or one of its children red.
    private Node moveRedLeft(Node h) {
        flipColors(h);

        if (isRed(h.right.left)) {
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
        }
        return h;
    }
}
