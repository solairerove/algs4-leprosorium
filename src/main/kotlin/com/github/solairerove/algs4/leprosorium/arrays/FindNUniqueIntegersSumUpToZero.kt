package com.github.solairerove.algs4.leprosorium.arrays

// O(n) time | O(n) space
fun sumZero(n: Int): IntArray {
    val arr = IntArray(n)
    for (i in 0 until n) arr[i] = i * 2 - n + 1

    return arr
}
