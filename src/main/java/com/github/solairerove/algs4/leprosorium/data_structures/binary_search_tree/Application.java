package com.github.solairerove.algs4.leprosorium.data_structures.binary_search_tree;

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
        tree.print();
        System.out.println(); // A C E H M R S X

        System.out.println(tree.get("A")); // 11
        System.out.println(tree.max()); // X
        System.out.println(tree.min()); // A
        System.out.println(tree.floor("G")); // E
        System.out.println(tree.select(3)); // H
        System.out.println(tree.size()); // 8

        tree.deleteMin();
        System.out.println(tree.min()); // C
        System.out.println(tree.size()); // 7

        tree.delete("E");
        System.out.println(tree.size()); // 6

        tree.print(); // C H M R S X
        System.out.println();

        tree.keys().forEach(s -> System.out.printf("%s ", s)); // C H M R S X
    }
}
