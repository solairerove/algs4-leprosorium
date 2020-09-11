package com.github.solairerove.algs4.leprosorium.structures.symbol_table.sequential;

public class Application {
    public static void main(String... args) {
        var map = new SequentialSearchST<String, String>();
        map.put("lox", "pidor");
        map.put("no", "friends"); // will be first
        map.put("nora", "noir"); // delete

        System.out.println(map.get("no")); // friends
        System.out.println(map.contains("no")); // true
        System.out.println(map.contains("false")); // false
        System.out.println(map.isEmpty()); // false
        System.out.println(map.size()); // 3
    }
}
