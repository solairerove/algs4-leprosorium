package com.github.solairerove.algs4.leprosorium.stack

import java.util.Stack

fun main() {
    println(simplifyPath("/home/")) // /home
    println(simplifyPath("/home//foo/")) // /home/foo
}

// O(n) time | O(n) space
private fun simplifyPath(path: String): String {
    val isStartWithPath = path[0] == '/'
    val tokens = path.split("/")
    val importantTokens = tokens.filter { token -> isImportantToken(token) }
    val stack = Stack<String>()
    if (isStartWithPath) stack.push("")
    for (token in importantTokens) {
        if (token == "..") {
            if (stack.size == 0 || stack.peek() == "..") {
                stack.add(token)
            } else if (stack.peek() != "") {
                stack.pop()
            }
        } else {
            stack.add(token)
        }
    }
    if (stack.size == 1 && stack.peek() == "") return "/"
    return stack.toList().joinToString("/")
}

private fun isImportantToken(token: String) = token.isNotEmpty() && token != "."
