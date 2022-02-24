package com.github.solairerove.algs4.leprosorium.recursion

fun main() {
    println(letterCombinations("23")) // ["ad","ae","af","bd","be","bf","cd","ce","cf"]
}

// O(4^n * n) time | O(4^n * n) space
private fun letterCombinations(digits: String): List<String> {
    if (digits.isEmpty()) return listOf()
    val curr = MutableList(digits.length) { '0' }
    val mnemonics = mutableListOf<String>()

    letterCombinations(0, digits, curr, mnemonics)
    return mnemonics
}

private fun letterCombinations(
    idx: Int, phone: String, curr: MutableList<Char>, mnemonics: MutableList<String>
) {
    if (idx == phone.length) {
        mnemonics.add(curr.joinToString(""))
    } else {
        val digit = phone[idx]
        val letters = DIGIT_TO_LETTERS[digit]!!
        for (letter in letters) {
            curr[idx] = letter
            letterCombinations(idx + 1, phone, curr, mnemonics)
        }
    }
}

val DIGIT_TO_LETTERS = mutableMapOf(
    '0' to listOf('0'),
    '1' to listOf('1'),
    '2' to listOf('a', 'b', 'c'),
    '3' to listOf('d', 'e', 'f'),
    '4' to listOf('g', 'h', 'i'),
    '5' to listOf('j', 'k', 'l'),
    '6' to listOf('m', 'n', 'o'),
    '7' to listOf('p', 'q', 'r', 's'),
    '8' to listOf('t', 'u', 'v'),
    '9' to listOf('w', 'x', 'y', 'z')
)