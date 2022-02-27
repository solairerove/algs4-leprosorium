package com.github.solairerove.algs4.leprosorium.stack

import kotlin.math.max

fun main() {
    println(largestRectangleArea(intArrayOf(2, 1, 5, 6, 2, 3))) // 10
    println(largestRectangleArea(intArrayOf(2, 4))) // 4
}

// O(n) time | O(n) space
fun largestRectangleArea(heights: IntArray): Int {
    val indices = mutableListOf<Int>()
    var area = 0

    val extendHeights = heights.plus(listOf(0))
    for (i in extendHeights.indices) {
        val height = extendHeights[i]
        while (indices.isNotEmpty() && heights[indices[indices.size - 1]] >= height) {
            val pHeight = heights[indices.removeAt(indices.size - 1)]
            val width = if (indices.isEmpty()) i else i - indices[indices.size - 1] - 1
            area = max(width * pHeight, area)
        }
        indices.add(i)
    }

    return area
}