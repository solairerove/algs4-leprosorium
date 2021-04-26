package com.github.solairerove.algs4.leprosorium.greedy

import kotlin.math.max

fun main() {
    val red = mutableListOf(1, 5, 9, 4, 6)
    val blue = mutableListOf(4, 8, 6, 5, 3)

    print(tandemBicycle(red, blue)) // 34
}

// O(nlog(n)) time | O(1) space
private fun tandemBicycle(red: MutableList<Int>, blue: MutableList<Int>): Int {
    red.sort()
    blue.sort()
    val n = red.size

    var total = 0
    for (i in 0 until n) {
        total += max(red[i], blue[n - 1 - i])
    }

    return total
}
