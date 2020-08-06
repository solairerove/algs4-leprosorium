package com.github.solairerove.algs4.leprosorium.dijkstra;

import java.util.Stack;

public class InfixBrackets {
    public static void main(String[] args) {
        String s = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";

        System.out.printf("%s\n%s", s, transform(s));
    }

    private static String transform(String statement) {
        String s = "";

        Stack<String> stack = new Stack<>();
        stack.push("");

        String[] a = statement.split(" ");
        for (int i = 0; i < a.length; ++i) {
            String pop = stack.pop();
            pop = pop + a[i] + " ";
            stack.push(pop);
        }

        return stack.pop();
    }
}
