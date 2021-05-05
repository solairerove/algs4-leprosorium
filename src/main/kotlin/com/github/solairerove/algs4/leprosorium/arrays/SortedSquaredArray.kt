package com.github.solairerove.algs4.leprosorium.arrays

import kotlin.math.abs

fun main() {
    val arr = listOf(-2, -1, 3, 4, 6, 7, 9, 10)

    print(sortedSquaredArray(arr)) // [1, 4, 9, 16, 36, 49, 81, 100]
}

// O(n) time | O(n) space
private fun sortedSquaredArray(arr: List<Int>): List<Int> {
    val n = arr.size

    val sortedSquared = MutableList(n) { 0 }
    var low = 0
    var high = n - 1

    for (i in n - 1 downTo 0) {
        val lowEl = arr[low]
        val highEl = arr[high]

        if (abs(highEl) > abs(lowEl)) {
            sortedSquared[i] = highEl * highEl
            high--
        } else {
            sortedSquared[i] = lowEl * lowEl
            low++
        }
    }

    return sortedSquared
}
