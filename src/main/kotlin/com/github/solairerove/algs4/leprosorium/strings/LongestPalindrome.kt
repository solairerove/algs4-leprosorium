package com.github.solairerove.algs4.leprosorium.strings

fun main() {
    print(longestPalindrome("arpkqqkpfkpdp")) // pkqqkp
}

// O(n^2) time | O(n) space
private fun longestPalindrome(s: String): String {
    var longest = listOf(0, 1)

    for (i in 1 until s.length) {
        val odd = getLongestPalindrome(s, i - 1, i + 1)
        val even = getLongestPalindrome(s, i - 1, i)
        val curr = if (odd[1] - odd[0] > even[1] - odd[0]) odd else even
        longest = if (longest[1] - longest[0] > curr[1] - curr[0]) longest else curr
    }

    return s.substring(longest[0], longest[1])
}

private fun getLongestPalindrome(s: String, lowIdx: Int, highIdx: Int): List<Int> {
    var low = lowIdx
    var high = highIdx

    while (low > 0 && high < s.length) {
        if (s[low] != s[high]) break
        low--
        high++
    }

    return listOf(low + 1, high)
}
