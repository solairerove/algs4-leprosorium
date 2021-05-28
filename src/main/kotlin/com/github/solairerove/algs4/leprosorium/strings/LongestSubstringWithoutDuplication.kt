package com.github.solairerove.algs4.leprosorium.strings

import kotlin.math.max

fun main() {
    print(longestSubstringWithoutDuplication("qvfwpccitm")) // qvfwpc
}

// O(n) time | O(n) space
private fun longestSubstringWithoutDuplication(s: String): String {
    val charToLastIdx = mutableMapOf<Char, Int>()
    var longest = Pair(0, 1)
    var low = 0
    for (i in s.indices) {
        val char = s[i]
        if (char in charToLastIdx) {
            low = max(low, charToLastIdx[char]!! + 1)
        }

        if (i + 1 - low > longest.second - longest.first) {
            longest = Pair(low, i + 1)
        }

        charToLastIdx[char] = i
    }

    return s.substring(longest.first, longest.second)
}
