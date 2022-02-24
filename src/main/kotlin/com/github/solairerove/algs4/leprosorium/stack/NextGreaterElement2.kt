package com.github.solairerove.algs4.leprosorium.stack

fun main() {
    nextGreaterElements(intArrayOf(1, 2, 1)).forEach { print("$it ") } // 2, -1, 2
}

// O(n) time | O(n) space
private fun nextGreaterElements(nums: IntArray): IntArray {
    val n = nums.size
    val res = MutableList(n) { -1 }
    val stack = mutableListOf<Int>()

    for (i in 2 * n - 1 downTo 0) {
        val idx = i % n

        while (stack.size > 0) {
            if (stack[stack.size - 1] <= nums[idx]) {
                stack.removeAt(stack.size - 1)
            } else {
                res[idx] = stack[stack.size - 1]
                break
            }
        }
        stack.add(nums[idx])
    }

    return res.toIntArray()
}
