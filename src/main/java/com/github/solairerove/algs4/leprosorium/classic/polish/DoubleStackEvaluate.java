package com.github.solairerove.algs4.leprosorium.classic.polish;

import java.util.Stack;

public class DoubleStackEvaluate {
    public static void main(String[] args) {
        String ev1 = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        System.out.printf("%s = %s\n", ev1, evaluate(ev1));

        String ev2 = "( 1 + ( 5 * ( 4 * 5 ) ) )";
        System.out.printf("%s = %s\n", ev2, evaluate(ev2));

        String ev3 = "( 1 + ( 5 * 20 ) )";
        System.out.printf("%s = %s\n", ev3, evaluate(ev3));

        String ev4 = "( 1 + 100 )";
        System.out.printf("%s = %s\n", ev4, evaluate(ev4));

        String ev5 = "101";
        System.out.printf("%s = %s\n", ev5, evaluate(ev5));
    }

    private static double evaluate(String s) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();

        String[] strings = s.split(" ");
        for (String el : strings) {
            if ("(".equals(el)) ;
            else if ("+".equals(el)) {
                ops.push(el);
            } else if ("-".equals(el)) {
                ops.push(el);
            } else if ("*".equals(el)) {
                ops.push(el);
            } else if ("/".equals(el)) {
                ops.push(el);
            } else if (")".equals(el)) {
                String op = ops.pop();
                Double val = vals.pop();

                if ("+".equals(op)) {
                    val = vals.pop() + val;
                } else if ("-".equals(op)) {
                    val = vals.pop() - val;
                } else if ("*".equals(op)) {
                    val = vals.pop() * val;
                } else if ("/".equals(op)) {
                    val = vals.pop() / val;
                }

                vals.push(val);
            } else {
                vals.push(Double.parseDouble(el));
            }
        }

        return vals.pop();
    }
}
