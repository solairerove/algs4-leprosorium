package com.github.solairerove.algs4.leprosorium.recursion

fun main() {
    println(numTrees(3)) // 5
    println(numTrees(1)) // 1
}

// O(n^2) time | O(n) space
private fun numTrees(n: Int): Int {
    val cache = mutableListOf<Int>(1)
    for (i in 1 until n + 1) {
        var num = 0
        for (j in 0 until i) {
            val right = i - 1 - j
            val leftNum = cache[j]
            val rightNum = cache[right]
            num += leftNum * rightNum
        }
        cache.add(num)
    }
    return cache[n]
}
