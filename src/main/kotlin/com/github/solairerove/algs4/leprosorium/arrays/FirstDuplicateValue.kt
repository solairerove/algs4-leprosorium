package com.github.solairerove.algs4.leprosorium.arrays

import kotlin.math.abs

fun main() {
    print(firstDuplicateValue(mutableListOf(2, 3, 2, 6, 6, 5, 3, 6))) // 2
}

// O(n) time | O(1) space
private fun firstDuplicateValue(arr: MutableList<Int>): Int {
    for (el in arr) {
        val absEl = abs(el)
        if (arr[absEl - 1] < 0) return absEl
        arr[absEl - 1] *= -1
    }

    return -1
}
