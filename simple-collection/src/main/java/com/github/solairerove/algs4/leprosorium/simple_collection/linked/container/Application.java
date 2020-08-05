package com.github.solairerove.algs4.leprosorium.simple_collection.linked.container;

public class Application {
    public static void main(String[] args) {
        Bag<String> bag = new Bag<>();
        bag.add("! ");
        bag.add("World ");
        bag.add("Hello ");

        bag.forEach(System.out::print);
    }
}
