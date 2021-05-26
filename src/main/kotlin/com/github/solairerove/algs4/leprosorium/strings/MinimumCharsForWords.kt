package com.github.solairerove.algs4.leprosorium.strings

import kotlin.math.max

fun main() {
    print(minimumCharsForWords(listOf("only", "after", "we", "have", "lost", "everything")))
}

// O(n * l) time | O(c) space
// n is number of words
// l is length of longest word
// c is number of unique chars
private fun minimumCharsForWords(words: List<String>): List<Char> {
    val maxCharFreq = mutableMapOf<Char, Int>()

    for (word in words) {
        val charFreq = mutableMapOf<Char, Int>()
        word.forEach { charFreq[it] = charFreq.getOrDefault(it, 0) + 1 }

        for ((char, freq) in charFreq) {
            if (char in maxCharFreq) {
                maxCharFreq[char] = max(freq, maxCharFreq[char]!!)
            } else {
                maxCharFreq[char] = freq
            }
        }
    }

    val chars = mutableListOf<Char>()
    for ((char, freq) in maxCharFreq) {
        for (i in 0 until freq) {
            chars.add(char)
        }
    }

    return chars
}
