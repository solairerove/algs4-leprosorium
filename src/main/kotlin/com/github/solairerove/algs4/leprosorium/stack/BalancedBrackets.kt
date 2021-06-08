package com.github.solairerove.algs4.leprosorium.stack

import java.util.Stack

fun main() {
    println(balancedBrackets("[()]{}{[()()]()}")) // true
    println(balancedBrackets("(()())((()))()(())(())()()()())")) // false
}

// O(n) time | O(n) space
private fun balancedBrackets(s: String): Boolean {
    val stack = Stack<Char>()

    for (i in s.indices) {
        if ('(' == s[i]) stack.push('(')
        if ('[' == s[i]) stack.push('[')
        if ('{' == s[i]) stack.push('{')

        if (')' == s[i]) {
            if (stack.isEmpty()) return false
            if ('(' != stack.pop()) return false
        }

        if (']' == s[i]) {
            if (stack.isEmpty()) return false
            if ('[' != stack.pop()) return false
        }

        if ('}' == s[i]) {
            if (stack.isEmpty()) return false
            if ('{' != stack.pop()) return false
        }
    }

    return stack.isEmpty()
}
