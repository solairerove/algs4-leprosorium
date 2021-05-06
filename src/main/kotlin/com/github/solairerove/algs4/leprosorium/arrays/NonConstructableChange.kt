package com.github.solairerove.algs4.leprosorium.arrays

fun main() {
    val arr = mutableListOf(2, 3, 1, 1, 2, 13)

    print(nonConstructableChange(arr)) // 10
}

// O(nlog(n)) time | O(1) space
private fun nonConstructableChange(arr: MutableList<Int>): Int {
    arr.sort()

    var change = 0
    for (el in arr) {
        if (el > change + 1) return change + 1

        change += el
    }

    return change + 1
}
