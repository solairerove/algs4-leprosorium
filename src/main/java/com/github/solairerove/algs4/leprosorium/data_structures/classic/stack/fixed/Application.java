package com.github.solairerove.algs4.leprosorium.data_structures.classic.stack.fixed;

import com.github.solairerove.algs4.leprosorium.data_structures.classic.stack.resized.ResizingArrayStack;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Application {

    // to be or not to - be - - that - - - is
    public static void main(String[] args) {
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(100);
        ResizingArrayStack stack1 = new ResizingArrayStack();

        String s = new In("/Users/solairerove/Downloads/algs4-data/tobe.txt").readLine();
        String[] strings = s.split(" ");
        for (String item : strings) {
            if (!item.equals("-")) {
                stack.push(item);
                stack1.push(item);
            } else if (!stack.isEmpty()) {
                StdOut.print(stack.pop() + " \n");
                StdOut.print(stack1.pop() + " \n");
            }
        }

        System.out.printf("\nspace is: %s\n", stack.size());
        System.out.printf("\nspace is: %s\n", stack1.size());
    }
}
