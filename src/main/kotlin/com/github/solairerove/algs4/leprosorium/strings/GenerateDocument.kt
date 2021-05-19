package com.github.solairerove.algs4.leprosorium.strings

fun main() {
    print(generateDocument("abcabc", "aabbcc"))
}

// O(n + m) time | O(c) space
// n is number of chars
// m is document length
// c is number of unique chars
private fun generateDocument(chars: String, doc: String): Boolean {
    val freq = mutableMapOf<Char, Int>()

    for (c in chars) {
        if (c !in freq) freq[c] = 0
        freq[c] = freq[c]!! + 1
    }

    for (c in doc) {
        if (c !in freq || freq[c] == 0) return false
        freq[c] = freq[c]!! - 1
    }

    return true
}
