package com.github.solairerove.algs4.leprosorium.dijkstra;

import java.util.Stack;

/**
 * Reads in a fully parenthesized infix expression from standard input
 * and prints an equivalent postfix expression to standard output.
 */
public class InfixToPostfix {
    public static void main(String[] args) {
        String s1 = "( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )"; // 2 3 4 + 5 6 * * +
        String s2 = "( ( ( 5 + ( 7 * ( 1 + 1 ) ) ) * 3 ) + ( 2 * ( 1 + 1 ) ) )"; //  5 7 1 1 + * + 3 * 2 1 1 + * +

        System.out.printf("%s -> %s\n", s1, infixToPostfix(s1));
        System.out.printf("%s -> %s\n", s2, infixToPostfix(s2));

        printPostfix(s1);
        System.out.println();
        printPostfix(s2);
    }

    // 2 3 4 + 5 6 * * +
    private static String infixToPostfix(String statement) {
        Stack<String> stack = new Stack<>();
        String r = "";

        for (String s : statement.split(" ")) {
            if ("+".equals(s)) stack.push(s);
            else if ("*".equals(s)) stack.push(s);
            else if (")".equals(s)) r = r + stack.pop() + " ";
            else if ("(".equals(s)) ;
            else r = r + s + " ";
        }

        return r;
    }

    private static void printPostfix(String statement) {
        Stack<String> ops = new Stack<>();

        for (String s : statement.split(" ")) {
            if ("+".equals(s)) ops.push(s);
            else if ("*".equals(s)) ops.push(s);
            else if ("(".equals(s)) ;
            else if (")".equals(s)) System.out.printf("%s ", ops.pop());
            else System.out.printf("%s ", s);
        }
    }
}
