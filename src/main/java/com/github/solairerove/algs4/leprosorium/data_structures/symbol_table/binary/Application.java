package com.github.solairerove.algs4.leprosorium.data_structures.symbol_table.binary;

public class Application {
    public static void main(String... args) {
        BinarySearchST<String, Integer> binarySearchST = new BinarySearchST<>(15);
        binarySearchST.put("S", 0);
        binarySearchST.put("E", 1);
        binarySearchST.put("A", 2);
        binarySearchST.put("R", 3);
        binarySearchST.put("C", 4);
        binarySearchST.put("H", 5);
        binarySearchST.put("E", 6);
        binarySearchST.put("X", 7);
        binarySearchST.put("A", 8);
        binarySearchST.put("M", 9);
        binarySearchST.put("P", 10);
        binarySearchST.put("L", 11);
        binarySearchST.put("E", 12);

        System.out.println(binarySearchST.get("E")); // 12
    }
}
