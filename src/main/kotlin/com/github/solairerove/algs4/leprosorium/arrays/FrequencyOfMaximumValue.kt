package com.github.solairerove.algs4.leprosorium.arrays

/**
 * Given an array ‘nums’ of length N containing positive integers
 * and an array ‘query’ of length ‘Q’ containing indexes,
 * print/store for each query the count of maximum value in the sub-array starting at index ‘i’
 * and ending at index ‘N-1’.
 */
fun main() {
    frequencyOfMaxValue(arrayOf(5, 4, 5, 3, 2), arrayOf(1, 2, 3, 4, 5))
        .forEach { print("$it ") } // 2, 1, 1, 1, 1
}

// O(n + q) time | O(n) space
private fun frequencyOfMaxValue(numbers: Array<Int>, q: Array<Int>): Array<Int> {
    val cnt = IntArray(numbers.size) { -1 }
    var max = -1
    var counter = 1
    for (i in numbers.size - 1 downTo 0) {
        if (numbers[i] == max) counter++
        if (numbers[i] > max) {
            max = numbers[i]
            counter = 1
        }
        cnt[i] = counter
    }

    return q.map { cnt[it - 1] }.toTypedArray()
}
