package com.github.solairerove.algs4.leprosorium.dynamic_programming

import kotlin.math.min

fun main() {
    print(coinChange(intArrayOf(1, 2, 5), 11)) // 3
}

// O(nd) time | O(n) space
private fun coinChange(coins: IntArray, amount: Int): Int {
    val nums = MutableList(amount + 1) { Int.MAX_VALUE }
    nums[0] = 0

    for (coin in coins) {
        for (i in 0 until amount + 1) {
            if (coin <= i) {
                val cmp = if (nums[i - coin] == Int.MAX_VALUE) nums[i - coin] else nums[i - coin] + 1
                nums[i] = min(nums[i], cmp)
            }
        }
    }
    return if (nums[amount] != Int.MAX_VALUE) nums[amount] else -1
}
