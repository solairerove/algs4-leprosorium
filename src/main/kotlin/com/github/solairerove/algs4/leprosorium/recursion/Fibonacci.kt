package com.github.solairerove.algs4.leprosorium.recursion

import java.math.BigInteger

// TODO: add recursive variant
fun main() {
    for (i in 1..6) {
        print("${getNthFibonacci(i)} ")
    }

    print("\n")

    for (i in 10..15) {
        print("${getLastNumberOfNthFibonacci(i)} ")
    }

    print("${getLastNumberOfNthFibonacci(841645)} ") // 5

    print("\n")

    val n = BigInteger.valueOf(12589)
    val m = BigInteger.valueOf(369)
    val round = getModOfBigNthFibonacci(n, m)
    print("${round[n.mod(BigInteger.valueOf(round.size.toLong())).intValueExact()]} ") // 89
}

// O(n) time | O(1) space
private fun getNthFibonacci(n: Int): Int {
    val lastTwo = mutableListOf(0, 1)

    repeat(n - 2) {
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

// TODO: move to PisanoPeriod
// 1 <= n <= 10^18 and 2 <= m <= 10^5 Pisano period
private fun getModOfBigNthFibonacci(n: BigInteger, m: BigInteger): List<BigInteger> {
    val round = mutableListOf(BigInteger.ZERO, BigInteger.ONE)

    var cnt = BigInteger.ONE

    while (cnt < n) {
        val next = round[cnt.intValueExact()]
            .add(round[cnt.subtract(BigInteger.ONE).intValueExact()])
            .mod(m)

        if (round[round.size - 1].compareTo(BigInteger.ZERO) == 0
            && next.compareTo(BigInteger.ONE) == 0
        ) {
            round.removeAt(round.size - 1)
            break
        }

        round.add(next)

        cnt = cnt.add(BigInteger.ONE)
    }

    return round
}