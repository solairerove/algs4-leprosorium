package com.github.solairerove.algs4.leprosorium.strings

fun main() {
    print(runLengthEncoding("xxxxxxyyyйййй")) // 6x3y4й
}

// O(n) time | O(n) space
private fun runLengthEncoding(s: String): String {
    val n = s.length

    val encoded = mutableListOf<Char>()
    var len = 1

    for (i in 1 until n) {
        val currChar = s[i]
        val prevChar = s[i - 1]

        if (currChar != prevChar || len == 9) {
            encoded.add(len.toString()[0])
            encoded.add(prevChar)
            len = 0
        }

        len++
    }

    encoded.add(len.toString()[0])
    encoded.add(s[n - 1])

    return encoded.joinToString("")
}
