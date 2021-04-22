package com.github.solairerove.algs4.leprosorium.heap

import kotlin.math.min

fun main() {
    val arr = mutableListOf(6, 5, 3, 2, 8, 10, 9)
    val k = 3

    sortKSortedArrays(arr, k)
    print(arr)
}

// O(nlog(k)) time | O(k) space
// n - total elements, k is k
private fun sortKSortedArrays(arr: MutableList<Int>, k: Int) {
    val minHeap = MinHeap(arr.slice(0..min(k, arr.size - 1)).toMutableList())

    var idx = 0
    for (i in k + 1 until arr.size) {
        arr[idx++] = minHeap.remove()
        minHeap.insert(arr[i])
    }

    while (minHeap.size() != 0) {
        arr[idx++] = minHeap.remove()
    }
}
