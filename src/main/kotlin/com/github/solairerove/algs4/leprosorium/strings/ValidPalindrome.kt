package com.github.solairerove.algs4.leprosorium.strings

/**
 * A phrase is a palindrome if,
 * after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters,
 * it reads the same forward and backward.
 *
 * Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 */

// O(n) time | O(1) space
fun isPalindrome(s: String): Boolean {
    var low = 0
    var high = s.length - 1
    while (low < high) {
        while (s[low].isNotLetterOrDigit() && low < high) low++
        while (s[high].isNotLetterOrDigit() && low < high) high--
        if (s[low].lowercaseChar() != s[high].lowercaseChar()) return false
        low++
        high--
    }

    return true
}

private fun Char.isNotLetterOrDigit(): Boolean = !isLetterOrDigit()
