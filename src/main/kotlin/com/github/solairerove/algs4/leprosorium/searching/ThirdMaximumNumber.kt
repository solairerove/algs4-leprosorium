package com.github.solairerove.algs4.leprosorium.searching

fun main() {
    val arr = listOf(-74, -62, -60, -36, -25, -2, 5, 15, 24, 46, 57, 80) // 46
    print(thirdMaximumNumber(arr))
}

// O(n) time | O(1) space
fun thirdMaximumNumber(arr: List<Int>): Int {
    val largestNumbers = mutableListOf(Int.MIN_VALUE, Int.MIN_VALUE, Int.MIN_VALUE)

    for (element in arr) {
        when {
            element > largestNumbers[2] -> shift(largestNumbers, element, 2)
            element > largestNumbers[1] -> shift(largestNumbers, element, 1)
            element > largestNumbers[0] -> shift(largestNumbers, element, 0)
        }
    }

    return largestNumbers[0]
}

fun shift(arr: MutableList<Int>, toInsert: Int, position: Int) {
    for (i in 0 until position + 1) {
        arr[i] = if (i == position) toInsert else arr[i + 1]
    }
}
