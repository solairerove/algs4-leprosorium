package com.github.solairerove.algs4.leprosorium.recursion

fun main() {
    print(staircaseTraverse(4, 3)) // 7
}

// O(n) time | O(n) space
private fun staircaseTraverse(height: Int, maxSteps: Int): Int {
    var number = 0
    val ways = mutableListOf(1)

    for (curr in 1 until height + 1) {
        val low = curr - maxSteps - 1
        val high = curr - 1
        if (low >= 0) number -= ways[low]

        number += ways[high]
        ways.add(number)
    }

    return ways[height]
}
