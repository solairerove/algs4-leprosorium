package com.github.solairerove.algs4.leprosorium.arrays

fun main() {
    val arr = mutableListOf(-9, -7, 2, -4, 0, 2, 3, 4, 5, 7)
    val k = 2

    moveElementToTheEnd(arr, k) // -9, -7, 7, -4, 0, 5, 3, 4, 2, 2

    print(arr)
}

// O(n) time | O(1) space
private fun moveElementToTheEnd(arr: MutableList<Int>, k: Int) {
    var low = 0
    var high = arr.size - 1

    while (low < high) {
        if (arr[low] == k) {
            while (low < high && arr[high] == k) high--
            swap(arr, low, high--)
        }
        low++
    }
}

private fun swap(arr: MutableList<Int>, i: Int, j: Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}
