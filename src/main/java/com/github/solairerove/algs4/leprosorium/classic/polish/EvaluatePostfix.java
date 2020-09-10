package com.github.solairerove.algs4.leprosorium.classic.polish;

import java.util.Stack;

public class EvaluatePostfix {
    public static void main(String[] args) {
        String s1 = "3 4 5 + *"; // 27
        String s2 = "1 2 3 4 5 * + 6 * * +"; // 277
        String s3 = "7 16 16 16 * * * 5 16 16 * * 3 16 * 1 + + +"; // 30001
        String s4 = "7 16 * 5 + 16 * 3 + 16 * 1 +"; // 30001

        System.out.printf("%s = %s\n", s1, evaluate(s1));
        System.out.printf("%s = %s\n", s2, evaluate(s2));
        System.out.printf("%s = %s\n", s3, evaluate(s3));
        System.out.printf("%s = %s\n", s4, evaluate(s4));
    }

    private static Integer evaluate(String statement) {
        Stack<Integer> vals = new Stack<>();

        for (String el : statement.split(" ")) {
            if ("+".equals(el)) vals.push(vals.pop() + vals.pop());
            else if ("*".equals(el)) vals.push(vals.pop() * vals.pop());
            else vals.push(Integer.parseInt(el));
        }

        return vals.pop();
    }
}
