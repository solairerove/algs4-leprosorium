package com.github.solairerove.algs4.leprosorium.greedy

/**
 * Given non empty array of positive int, that define time to execute.
 * Only one query can be executed at time, but in any order.
 * Get minimal waiting time to execute all of queries.
 * 9 6 5 2 3 1 -> 1 2 3 5 6 9 -> 0 + 1 + (1 + 2) + (1 + 2 + 3) + (1 + 2 + 3 + 5) + (1 + 2 + 3 + 5 + 6) = 38
 */
fun main() {
    print(minimumWaitingTime(mutableListOf(9, 6, 5, 2, 3, 1)))
}

// O(nlogn) time | O(1) space
private fun minimumWaitingTime(queries: MutableList<Int>): Int {
    queries.sort()

    var minimumWaitingTime = 0
    var previousSum = queries[0]
    for (i in 1 until queries.size) {
        minimumWaitingTime += previousSum
        previousSum += queries[i]
    }

    return minimumWaitingTime
}
