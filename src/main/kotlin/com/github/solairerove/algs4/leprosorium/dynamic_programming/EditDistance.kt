package com.github.solairerove.algs4.leprosorium.dynamic_programming

import kotlin.math.min

fun main() {
    println(minDistance("horse", "ros")) // 3
    println(minDistance("abc", "zabd")) // 2
}

// O(nm) time | O(nm) space
private fun minDistance(word1: String, word2: String): Int {
    val n1 = word1.length
    val n2 = word2.length
    val distance = List(n2 + 1) { MutableList(n1 + 1) { el -> el } }

    for (i in 0 until n2 + 1) {
        for (j in 0 until n1 + 1) {
            distance[i][j] = j
        }
        distance[i][0] = i
    }

    for (i in 1 until n2 + 1) {
        for (j in 1 until n1 + 1) {
            distance[i][j] = if (word2[i - 1] == word1[j - 1]) {
                distance[i - 1][j - 1]
            } else {
                1 + min(
                    distance[i - 1][j - 1],
                    min(
                        distance[i - 1][j],
                        distance[i][j - 1]
                    )
                )
            }
        }
    }

    return distance[n2][n1]
}
