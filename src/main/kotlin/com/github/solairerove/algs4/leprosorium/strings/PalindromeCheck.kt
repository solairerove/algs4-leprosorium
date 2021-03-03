package com.github.solairerove.algs4.leprosorium.strings

fun main() {
    print("'string' is palindrome ${isPalindrome("string")}\n")
    print("'aba' is palindrome ${isPalindrome("aba")}\n")
    print("'sobaka' is palindrome ${isPalindrome("sobaka")}\n")
    print("'civic' is palindrome ${isPalindrome("civic")}\n")
    print("'level' is palindrome ${isPalindrome("level")}\n")
    print("'racecar' is palindrome ${isPalindrome("racecar")}\n")
}

// O(n) time | O(1) space
private fun isPalindrome(s: String): Boolean {
    for (i in s.indices) {
        if (s[i] != s[s.length - 1 - i]) {
            return false
        }
    }
    return true
}
