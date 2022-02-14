package com.github.solairerove.algs4.leprosorium.dynamic_programming

import kotlin.math.max

fun main() {
    print(rob(intArrayOf(2, 7, 9, 3, 1))) // 12
}

// O(n) time | O(1) space
private fun rob(arr: IntArray): Int {
    if (arr.isEmpty()) return 0
    else if (arr.size == 1) return arr[0]

    var first = max(arr[0], arr[1])
    var second = arr[0]

    for (i in 2 until arr.size) {
        val curr = max(first, second + arr[i])
        second = first
        first = curr
    }

    return first
}
