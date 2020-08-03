package com.github.solairerove.algs4.leprosorium.simple_collection.fixed;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Application {

    // to be or not to - be - - that - - - is
    public static void main(String[] args) {
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(100);
        String s = new In("/Users/solairerove/Downloads/algs4-data/tobe.txt").readLine();
        String[] strings = s.split(" ");
        for (String item : strings) {
            if (!item.equals("-")) {
                stack.push(item);
            } else if (!stack.isEmpty()) {
                StdOut.print(stack.pop() + " ");
            }
        }

        System.out.printf("\nspace is: %s\n", stack.size());
    }
}
