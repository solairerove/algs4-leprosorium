package com.github.solairerove.algs4.leprosorium.binary_search_tree;

public class Application {
    public static void main(String... args) {
        BST<String, Integer> tree = new BST<>();
        tree.put("X", 0);
        tree.put("S", 1);
        tree.put("R", 2);
        tree.put("M", 3);
        tree.put("H", 4);
        tree.put("E", 5);
        tree.put("C", 6);
        tree.put("A", 11);

        System.out.println(tree.get("A")); // 11
        System.out.println(tree.max()); // X
        System.out.println(tree.min()); // A
    }
}
