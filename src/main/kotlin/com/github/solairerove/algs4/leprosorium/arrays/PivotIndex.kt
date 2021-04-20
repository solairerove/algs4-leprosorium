package com.github.solairerove.algs4.leprosorium.arrays

fun main() {
    val arr = listOf(1, 7, 3, 6, 5, 6) // 28
    print(pivotIndex(arr)) // 3
}

// O(n) time | O(1) space
private fun pivotIndex(arr: List<Int>): Int {
    val total = arr.sum()
    var sum = 0

    for (i in arr.indices) {
        if (sum * 2 == total - arr[i]) return i
        sum += arr[i]
    }
    return -1
}
