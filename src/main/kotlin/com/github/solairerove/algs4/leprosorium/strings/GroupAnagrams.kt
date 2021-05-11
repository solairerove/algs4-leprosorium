package com.github.solairerove.algs4.leprosorium.strings

fun main() {
    print(groupAnagrams(listOf("funeral", "realfun", "debitcard", "badcredit", "bobmarley", "marbleboy")))
}

// O(w * nlog(n)) time | O(wn) space
// w - number of words
// n - length of longest word
private fun groupAnagrams(words: List<String>): List<List<String>> {
    val anagrams = mutableMapOf<String, MutableList<String>>()
    for (word in words) {
        val sortedWord = word.toCharArray().sortedArray().joinToString("")
        if (sortedWord in anagrams) {
            anagrams[sortedWord]!!.add(word)
        } else {
            anagrams[sortedWord] = mutableListOf(word)
        }
    }

    return anagrams.values.toList()
}
