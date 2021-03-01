package com.github.solairerove.algs4.leprosorium.recursion

fun main() {
    for (i in 1..6) {
        print("${getNthFibonacci(i)} ")
    }

    print("\n")

    for (i in 10..15) {
        print("${getLastNumberOfNthFibonacci(i)} ")
    }

    print("${getLastNumberOfNthFibonacci(841645)} ") // 5
}

// O(n) time | O(1) space
private fun getNthFibonacci(n: Int): Int {
    val lastTwo = mutableListOf(0, 1)

    for (cnt in 3..n) {
        val next = lastTwo.sum()
        lastTwo[0] = lastTwo[1]
        lastTwo[1] = next
    }

    return if (n > 1) lastTwo[1] else lastTwo[0]
}

// stepik stupid rules
private fun getLastNumberOfNthFibonacci(n: Int): Int {
    val lastTwo = mutableListOf(0, 1)

    for (cnt in 1 until n) {
        val next = lastTwo.sum()
        lastTwo[0] = lastTwo[1] % 10
        lastTwo[1] = next % 10
    }

    return if (n > 1) lastTwo[1] else lastTwo[0]
}
