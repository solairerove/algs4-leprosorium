package com.github.solairerove.algs4.leprosorium.sorting

fun main() {
    val items = mutableListOf(5, 6, 4, 3, 10, 9, 5, 6, 7)
    print("items: $items \n")
    heapSort(items)
    print("items: $items \n")
}

// O(nlogn) time | O(1) space
private fun heapSort(arr: MutableList<Int>) {
    val n = arr.size

    for (k in n / 2 downTo 1) {
        sink(arr, k, n)
    }
    var k = n
    while (k > 1) {
        swap(arr, 1, k--)
        sink(arr, 1, k)
    }
}

private fun sink(arr: MutableList<Int>, k: Int, n: Int) {
    var idx = k
    while (2 * idx <= n) {
        var j = 2 * idx
        if (j < n && less(arr, j, j + 1)) j++
        if (!less(arr, idx, j)) break
        swap(arr, idx, j)
        idx = j
    }
}

private fun less(arr: MutableList<Int>, i: Int, j: Int): Boolean {
    return arr[i - 1] < arr[j - 1]
}

private fun swap(arr: MutableList<Int>, i: Int, j: Int) {
    val temp = arr[i - 1]
    arr[i - 1] = arr[j - 1]
    arr[j - 1] = temp
}
