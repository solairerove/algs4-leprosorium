package com.github.solairerove.algs4.leprosorium.sorting

fun main() {
    val items = mutableListOf(5, 6, 4, 3, 10, 9, 5, 6, 7)
    print("items: $items \n")
    quickSort(items)
    print("items: $items \n")
}

// O(nlog(n)) time | O(n) space
private fun quickSort(arr: MutableList<Int>) {
    quickSort(arr, 0, arr.size - 1)
}

private fun quickSort(arr: MutableList<Int>, low: Int, high: Int) {
    if (high <= low) return

    val j = partition(arr, low, high)
    quickSort(arr, low, j - 1)
    quickSort(arr, j + 1, high)
}

private fun partition(arr: MutableList<Int>, low: Int, high: Int): Int {
    var i = low
    var j = high + 1
    val v = arr[low]

    while (true) {
        while (arr[++i] < v) if (i == high) break
        while (v < arr[--j]) if (j == low) break
        if (i >= j) break
        swap(arr, i, j)
    }

    swap(arr, low, j)

    return j
}

private fun swap(arr: MutableList<Int>, i: Int, j: Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}