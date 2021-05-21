package com.github.solairerove.algs4.leprosorium.recursion

fun main() {
    print(productSum(listOf(1, listOf(2, listOf(3))))) // 23
}

// O(n) time | O(d) space
// n is total number of elements
// d is max depth
private fun productSum(arr: List<*>): Int {
    return productSum(arr, 1)
}

private fun productSum(arr: List<*>, multiplier: Int): Int {
    var sum = 0

    for (el in arr) {
        sum += if (el is List<*>) {
            productSum(el, multiplier + 1)
        } else {
            el as Int
        }
    }

    return sum * multiplier
}
