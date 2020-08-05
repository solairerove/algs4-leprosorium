package com.github.solairerove.algs4.leprosorium.simple_collection.linked.lifo;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Application {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        String s = new In("/Users/solairerove/Downloads/algs4-data/tobe.txt").readLine();
        String[] strings = s.split(" ");
        for (String item : strings) {
            if (!item.equals("-")) {
                stack.push(item);
            } else if (!stack.isEmpty()) {
                StdOut.print(stack.pop() + " \n");
            }
        }

        System.out.printf("\nspace is: %s\n", stack.size());
    }
}
