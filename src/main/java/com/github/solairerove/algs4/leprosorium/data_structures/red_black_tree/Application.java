package com.github.solairerove.algs4.leprosorium.data_structures.red_black_tree;

public class Application {
    public static void main(String... args) {
        RedBlackBST<String, Integer> tree = new RedBlackBST<>();
        tree.put("X", 0);
        tree.put("S", 1);
        tree.put("R", 2);
        tree.put("M", 3);
        tree.put("H", 4);
        tree.put("E", 5);
        tree.put("C", 6);
        tree.put("A", 11);

        System.out.println(tree.get("A"));

        System.out.println(tree.min()); // A
        tree.deleteMin();
        System.out.println(tree.min()); // C

        System.out.println(tree.max()); // X
        tree.deleteMax();
        System.out.println(tree.max()); // S
    }
}
