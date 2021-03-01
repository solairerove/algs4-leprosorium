package com.github.solairerove.algs4.leprosorium.sorting

fun main() {
    val items = mutableListOf(5, 6, 4, 3, 10, 9, 5, 6, 7)
    print("items: $items \n")
    insertionSort(items)
    print("items: $items \n")
}

// O(n^2) time | O(1) space
private fun insertionSort(arr: MutableList<Int>) {
    val n = arr.size

    for (i in 1 until n) {
        for (j in i downTo 0) {
            if (j > 0 && arr[j] < arr[j - 1]) {
                swap(arr, j, j - 1)
            }
        }
    }
}

private fun swap(arr: MutableList<Int>, i: Int, j: Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}