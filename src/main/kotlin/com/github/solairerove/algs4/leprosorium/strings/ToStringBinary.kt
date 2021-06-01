package com.github.solairerove.algs4.leprosorium.strings

fun main() {
    println(toBinaryString(5)) // 101
    println(toBinaryString(10)) // 1010
}

// O(n) time | O(n) space
private fun toBinaryString(n: Int): String {
    val stringBuilder = StringBuilder()
    var idx = n
    while (idx > 0) {
        stringBuilder.insert(0, idx % 2)
        idx /= 2
    }

    return stringBuilder.toString()
}
