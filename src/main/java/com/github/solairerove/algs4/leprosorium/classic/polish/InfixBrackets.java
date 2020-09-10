package com.github.solairerove.algs4.leprosorium.classic.polish;

import java.util.Stack;

public class InfixBrackets {
    public static void main(String[] args) {
        String s = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";

        System.out.printf("%s\n%s", s, transform(s));
    }

    private static String transform(String statement) {
        String s = "";

        Stack<String> ops = new Stack<>();
        Stack<String> vals = new Stack<>();

        String[] a = statement.split(" ");
        for (String el : a) {
            if ("(".equals(el)) ;
            else if ("+".equals(el)) ops.push(el);
            else if ("-".equals(el)) ops.push(el);
            else if ("*".equals(el)) ops.push(el);
            else if ("/".equals(el)) ops.push(el);
            else if (")".equals(el)) {
                String op = ops.pop();
                String val2 = vals.pop();
                String val1 = vals.pop();

                String sub = "( " + val1 + " " + op + " " + val2 + " )";
                vals.push(sub);
            } else {
                vals.push(el);
            }
        }

        return vals.pop();
    }
}
