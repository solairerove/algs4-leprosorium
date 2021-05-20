package com.github.solairerove.algs4.leprosorium.strings

fun main() {
    print(nonRepeatingCharPivot("sptiroksoz")) // 1
}

// O(n) time | O(n) space
private fun nonRepeatingCharPivot(s: String): Int {
    val freq = mutableMapOf<Char, Int>()

    s.forEach { freq[it] = freq.getOrDefault(it, 0) + 1 }

    for (i in s.indices) {
        if (freq[s[i]] == 1) return i
    }

    return -1
}
