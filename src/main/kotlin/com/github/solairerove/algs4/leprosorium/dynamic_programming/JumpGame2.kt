package com.github.solairerove.algs4.leprosorium.dynamic_programming

import kotlin.math.max

fun main() {
    println(jump(intArrayOf(2, 3, 1, 1, 4))) // 2
}

// O(n) time | O(1) space
private fun jump(nums: IntArray): Int {
    if (nums.size == 1) return 0
    var jumps = 0
    var reach = nums[0]
    var steps = nums[0]
    for (i in 1 until nums.size - 1) {
        reach = max(reach, nums[i] + i)
        steps--
        if (steps == 0) {
            jumps++
            steps = reach - i
        }
    }
    return jumps + 1
}
