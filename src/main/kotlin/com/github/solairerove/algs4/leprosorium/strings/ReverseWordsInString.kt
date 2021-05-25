package com.github.solairerove.algs4.leprosorium.strings

fun main() {
    print(reverseWordsInString("anything. do to free we're that everything lost we've after only It's"))
}

// O(n) time | O(n) space
private fun reverseWordsInString(s: String): String {
    val chars = s.map { it }.toMutableList()
    val n = chars.size
    reverse(chars, 0, n - 1)

    var low = 0
    while (low < n) {
        var high = low
        while (high < n && chars[high] != ' ') high++

        reverse(chars, low, high - 1)
        low = high + 1
    }

    return chars.joinToString("")
}

private fun reverse(chars: MutableList<Char>, lo: Int, hi: Int) {
    var low = lo
    var high = hi

    while (low < high) {
        swap(chars, low, high)
        low++
        high--
    }
}

private fun swap(arr: MutableList<Char>, i: Int, j: Int) {
    val tmp = arr[i]
    arr[i] = arr[j]
    arr[j] = tmp
}
