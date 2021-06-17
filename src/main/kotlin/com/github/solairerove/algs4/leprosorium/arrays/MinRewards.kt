package com.github.solairerove.algs4.leprosorium.arrays

import kotlin.math.max

fun main() {
    println(minRewards(listOf(9, 2, 3, 1, 8, 4, 7))) // 11
}

// O(n) time | O(n) space
private fun minRewards(scores: List<Int>): Int {
    val n = scores.size
    val rewards = MutableList(n) { 1 }

    for (i in 1 until n) {
        if (scores[i] > scores[i - 1]) {
            rewards[i] = rewards[i - 1] + 1
        }
    }

    for (i in n - 2 downTo 0) {
        if (scores[i] > scores[i + 1]) {
            rewards[i] = max(rewards[i], rewards[i + 1] + 1)
        }
    }

    return rewards.sum()
}
