package com.github.solairerove.algs4.leprosorium.data_structures.classic.linked.fifo;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Application {

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();

        String s = new In("/Users/solairerove/Downloads/algs4-data/tobe.txt").readLine();
        String[] strings = s.split(" ");
        for (String item : strings) {
            if (!item.equals("-")) {
                queue.enqueue(item);
            } else if (!queue.isEmpty()) {
                StdOut.print(queue.dequeue() + " \n");
            }
        }

        System.out.printf("\nspace is: %s\n", queue.size());

        Queue<String> dequeue = new Queue<>();
        dequeue.enqueue("Hello");
        dequeue.enqueue("World");
        dequeue.enqueue("!");

        System.out.printf("%s ", dequeue.dequeue());
        System.out.printf("%s ", dequeue.dequeue());
        System.out.printf("%s ", dequeue.dequeue());
    }
}
