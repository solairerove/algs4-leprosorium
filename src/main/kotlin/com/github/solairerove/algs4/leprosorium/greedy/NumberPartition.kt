package com.github.solairerove.algs4.leprosorium.greedy

fun main() {
    var n = 6

    val res = mutableListOf<Int>()
    for (i in 1..n) {
        if (n - i >= i + 1) {
            res.add(i)
        } else {
            res.add(n)
            break
        }
        n -= i
    }

    print("${res.size}\n")
    res.forEach { print("$it ") }
}
