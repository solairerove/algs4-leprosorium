package com.github.solairerove.algs4.leprosorium.greedy

/**
 * По данному числу n найти максимальное число k,
 * для которого n можно представить как сумму k различных натуральных слагаемых.
 * Sample Input: 6
 * Sample Output: 3 (1 2 3)
 */
fun main() {
    var n = 6

    val res = mutableListOf<Int>()
    for (i in 1..n) {
        if (n - i >= i + 1) {
            res.add(i)
        } else {
            res.add(n)
            break
        }
        n -= i
    }

    print("${res.size}\n")
    res.forEach { print("$it ") }
}
