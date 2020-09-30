package com.github.solairerove.algs4.leprosorium.data_structures.symbol_table.set;

public class Application {
    public static void main(String... args) {
        Set<String> strings = new Set<>();
        strings.add("A");
        strings.add("B");
        strings.add("C");
        strings.add("D");
        strings.add("E");
        strings.add("F");
        strings.add("G");
        strings.add("H");

        System.out.println(strings.contains("A")); // true
        System.out.println(strings.size()); // 8
        System.out.println(strings.max()); // H
        System.out.println(strings.min()); // A
        strings.delete("A");
        System.out.println(strings.min()); // B
        System.out.println(strings.floor("K")); // H
    }
}
