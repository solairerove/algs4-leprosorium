package com.github.solairerove.algs4.leprosorium.dynamic_programming

fun main() {
    println(uniquePaths(3, 7)) // 28
}

// O(nm) time | O(nm) space
private fun uniquePaths(n: Int, m: Int): Int {
    val numberOfWays = MutableList(m + 1) { MutableList(n + 1) { 0 } }

    for (wIdx in 1 until n + 1) {
        for (hIdx in 1 until m + 1) {
            numberOfWays[hIdx][wIdx] =
                if (wIdx == 1 || hIdx == 1) 1 else numberOfWays[hIdx][wIdx - 1] + numberOfWays[hIdx - 1][wIdx]
        }
    }

    return numberOfWays[m][n]
}
