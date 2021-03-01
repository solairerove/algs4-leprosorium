package com.github.solairerove.algs4.leprosorium.recursion

fun main() {
    print(getNthFibonacci(1))
    print(getNthFibonacci(2))
    print(getNthFibonacci(3))
    print(getNthFibonacci(4))
    print(getNthFibonacci(5))
    print(getNthFibonacci(6))
}

private fun getNthFibonacci(n: Int): Int {
    val lastTwo = mutableListOf(0, 1)

    for (cnt in 3..n) {
        val next = lastTwo.sum()
        lastTwo[0] = lastTwo[1]
        lastTwo[1] = next
    }

    return if (n > 1) lastTwo[1] else lastTwo[0]
}
