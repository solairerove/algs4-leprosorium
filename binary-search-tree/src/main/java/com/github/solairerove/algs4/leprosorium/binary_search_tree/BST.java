package com.github.solairerove.algs4.leprosorium.binary_search_tree;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int n; // количество узлов в поддереве с этим корнем

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            this.n = n;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;

        return x.n;
    }

    public Value get(Key key) {
        throw new UnsupportedOperationException();
    }

    public void put(Key key, Value value) {
        throw new UnsupportedOperationException();
    }
}
