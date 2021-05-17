package com.github.solairerove.algs4.leprosorium.strings

fun main() {
    print(caesarCipherEncryptor("abc", 2)) // cde
}

// O(n) time | O(n) space
private fun caesarCipherEncryptor(s: String, k: Int): String {
    val newLetters = mutableListOf<Char>()
    val key = k % 26
    s.forEach { newLetters.add(getNewLetter(it, key)) }

    return newLetters.joinToString("")
}

private fun getNewLetter(letter: Char, key: Int): Char {
    val newLetterCode = letter.toInt() + key
    return if (newLetterCode <= 122) {
        newLetterCode.toChar()
    } else (newLetterCode % 122).toChar()
}
