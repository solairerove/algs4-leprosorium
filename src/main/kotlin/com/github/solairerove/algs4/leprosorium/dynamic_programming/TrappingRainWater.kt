package com.github.solairerove.algs4.leprosorium.dynamic_programming

import kotlin.math.max

fun main() {
    println(trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1))) // 6
    println(trap(intArrayOf(4, 2, 0, 3, 2, 5))) // 9
}

// O(n) time | O(1) space
private fun trap(height: IntArray): Int {
    if (height.isEmpty()) return 0

    var left = 0
    var right = height.size - 1
    var lMax = height[left]
    var rMax = height[right]
    var area = 0

    while (left < right) {
        if (height[left] < height[right]) {
            left++
            lMax = max(lMax, height[left])
            area += lMax - height[left]
        } else {
            right--
            rMax = max(rMax, height[right])
            area += rMax - height[right]
        }
    }

    return area
}
