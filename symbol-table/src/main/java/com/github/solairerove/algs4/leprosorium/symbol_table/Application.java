package com.github.solairerove.algs4.leprosorium.symbol_table;

public class Application {
    public static void main(String... args) {
        var map = new SequentialSearchST<String, String>();
        map.put("lox", "pidor");
        map.put("no", "friends");

        // O(n)
        System.out.println(map.get("no")); //friends
    }
}
