package com.github.solairerove.algs4.leprosorium.dynamic_programming

fun main() {
    print(change(intArrayOf(1, 2, 5), 5)) // 4
}

// O(nd) time | O(n) space
private fun change(coins: IntArray, amount: Int): Int {
    val ways = MutableList(amount + 1) { 0 }
    ways[0] = 1
    for (c in coins) {
        for (a in 1 until amount + 1) {
            if (c <= a) ways[a] += ways[a - c]
        }
    }

    return ways[amount]
}
