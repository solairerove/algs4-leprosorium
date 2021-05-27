package com.github.solairerove.algs4.leprosorium.arrays

import kotlin.math.max

fun main() {
    print(kadane(listOf(12, 11, -16, -14, -15, -9, 5, -20, 3, 7, -7))) // 23
}

// O(n) time | O(1) space
private fun kadane(arr: List<Int>): Int {
    var curr = arr[0]
    var max = arr[0]

    for (i in 1 until arr.size) {
        curr = max(arr[i], curr + arr[i])
        max = max(curr, max)
    }

    return max
}
