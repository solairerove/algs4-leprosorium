package com.github.solairerove.algs4.leprosorium.sorting

fun main() {
    val items = mutableListOf(5, 6, 4, 3, 10, 9, 5, 6, 7)
    print("items: $items \n")
    bubbleSort(items)
    print("items: $items \n")
}

// O(n^2) time | O(1) space
private fun bubbleSort(arr: MutableList<Int>) {
    val n = arr.size

    for (i in 1 until n) {
        for (j in 0 until n - i) {
            if (arr[j + 1] < arr[j]) {
                swap(arr, j + 1, j)
            }
        }
    }
}

private fun swap(arr: MutableList<Int>, i: Int, j: Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}
