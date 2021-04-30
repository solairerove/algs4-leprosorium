package com.github.solairerove.algs4.leprosorium.arrays

fun main() {
    val arr = listOf(-10, -9, -4, 0, 1, 2, 3, 5, 9, 11, 12, 14, 17)
    print(isMonotonic(arr))
}

// O(n) time | O(1) space
private fun isMonotonic(arr: List<Int>): Boolean {
    var isIncreasing = true
    var isDecreasing = true

    for (i in 1 until arr.size) {
        when {
            arr[i - 1] < arr[i] -> isDecreasing = false
            arr[i - 1] > arr[i] -> isIncreasing = false
        }
    }

    return isIncreasing || isDecreasing
}
