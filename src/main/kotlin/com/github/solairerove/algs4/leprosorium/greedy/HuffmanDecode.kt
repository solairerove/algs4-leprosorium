package com.github.solairerove.algs4.leprosorium.greedy

// abacabad
fun main() {
    val dictionary = mapOf(
        Pair("0", "a"),
        Pair("10", "b"),
        Pair("110", "c"),
        Pair("111", "d")
    )

    val s = "01001100100111"

    val stringBuilder = StringBuilder()
    var i = 0
    while (i < s.length) {
        var isCodeFound = false
        var code = s[i].toString()
        while (!isCodeFound) {
            if (dictionary.containsKey(code)) {
                stringBuilder.append(dictionary[code])
                isCodeFound = true
            } else {
                code = code.plus(s[++i].toString())
                isCodeFound = false
            }
        }
        i++
    }

    print(stringBuilder.toString())
}
