package com.github.solairerove.algs4.leprosorium.greedy

fun main() {
    val red = mutableListOf(1, 5, 9, 4, 6)
    val blue = mutableListOf(4, 8, 6, 5, 3)

    print(heightChecker(red, blue))
}

// O(nlog(n)) time | O(1) space
private fun heightChecker(red: MutableList<Int>, blue: MutableList<Int>): Boolean {
    red.sortDescending()
    blue.sortDescending()

    val firstRow = if (red[0] < blue[0]) 1 else 0

    for (i in 0 until red.size) {
        val r = red[i]
        val b = blue[i]

        if (firstRow == 1) {
            if (r >= b) return false
        } else {
            if (r <= b) return false
        }
    }

    return true
}
