package com.github.solairerove.algs4.leprosorium.arrays

import kotlin.math.max

fun main() {
    print(mergeOverlappingIntervals(listOf(listOf(3, 5), listOf(1, 4), listOf(6, 7)))) // [[1, 5], [6, 7]]
}

// O(nlog(n)) time | O(n) space
private fun mergeOverlappingIntervals(intervals: List<List<Int>>): List<List<Int>> {
    val sorted = intervals.toMutableList()
        .sortedWith { a, b -> a[0].compareTo(b[0]) }
        .map { it.toMutableList() }

    val merged = mutableListOf<MutableList<Int>>()
    var curr = sorted[0]
    merged.add(curr)

    for (next in sorted) {
        val (_, currHigh) = curr
        val (nextLow, nextHigh) = next

        if (currHigh >= nextLow) {
            curr[1] = max(currHigh, nextHigh)
        } else {
            curr = next
            merged.add(curr)
        }
    }

    return merged
}
