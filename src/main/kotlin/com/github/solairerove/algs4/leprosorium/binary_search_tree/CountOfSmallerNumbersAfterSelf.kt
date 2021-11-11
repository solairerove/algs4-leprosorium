package com.github.solairerove.algs4.leprosorium.binary_search_tree

fun main() {
    println(countSmallerNaiveSquared(intArrayOf(5, 2, 6, 1))) // [2, 1, 1, 0]
}

// O(nˆ2) time | O(n) space
fun countSmallerNaiveSquared(arr: IntArray): List<Int> {
    val counts = mutableListOf<Int>()
    for (i in arr.indices) {
        var counter = 0
        for (j in i + 1 until arr.size) {
            if (arr[j] < arr[i]) counter++
        }
        counts.add(counter)
    }
    return counts
}
