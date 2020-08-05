package com.github.solairerove.algs4.leprosorium.simple_collection.stack.parentheses;

import java.util.Stack;

public class Application {
    public static void main(String[] args) {
        String balanced = "[()]{}{[()()]()}";
        System.out.printf("is %s balanced: %s\n", balanced, isBalanced(balanced));

        String notBalanced = "[(])";
        System.out.printf("is %s balanced: %s\n", notBalanced, isBalanced(notBalanced));
    }

    private static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {
            if ('(' == s.charAt(i)) stack.push('(');
            if ('[' == s.charAt(i)) stack.push('[');
            if ('{' == s.charAt(i)) stack.push('{');

            if (')' == s.charAt(i)) {
                if (stack.isEmpty()) return false;
                if ('(' != stack.pop()) return false;
            }

            if (']' == s.charAt(i)) {
                if (stack.isEmpty()) return false;
                if ('[' != stack.pop()) return false;
            }

            if ('}' == s.charAt(i)) {
                if (stack.isEmpty()) return false;
                if ('{' != stack.pop()) return false;
            }
        }

        return stack.isEmpty();
    }
}
