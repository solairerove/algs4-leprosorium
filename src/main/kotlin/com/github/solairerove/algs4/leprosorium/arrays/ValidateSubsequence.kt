package com.github.solairerove.algs4.leprosorium.arrays

fun main() {
    val arr = listOf(-10, 20, 18, -3, 3, 12, 11, 17, -1, 9)
    val subsequence = listOf(-10, -3, -1)
    print(validateSubsequence(arr, subsequence))
}

// O(n) time | O(1) space
private fun validateSubsequence(arr: List<Int>, subsequence: List<Int>): Boolean {
    var seqIdx = 0

    for (el in arr) {
        if (seqIdx == subsequence.size) break
        if (el == subsequence[seqIdx]) seqIdx++
    }

    return seqIdx == subsequence.size
}
