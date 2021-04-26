package com.github.solairerove.algs4.leprosorium.sorting

import kotlin.math.min

fun main() {
    val items = mutableListOf(5, 6, 4, 3, 10, 9, 5, 6, 7)
    print("items: $items \n")
    mergeSort(items)
    print("items: $items \n")
}

// O(nlog(n)) time | O(n) space
private fun mergeSort(arr: MutableList<Int>) {
    val n = arr.size
    val aux = MutableList(n) { i -> i }

    var len = 1
    while (len < n) {
        for (low in 0 until n - len step 2 * len) {
            val mid = low + len - 1
            val high = min(low + 2 * len - 1, n - 1)
            merge(arr, aux, low, mid, high)
        }
        len *= 2
    }
}

private fun merge(arr: MutableList<Int>, aux: MutableList<Int>, low: Int, mid: Int, high: Int) {
    for (k in low..high) {
        aux[k] = arr[k]
    }

    var i = low
    var j = mid + 1

    for (k in low..high) {
        when {
            i > mid -> arr[k] = aux[j++]
            j > high -> arr[k] = aux[i++]
            aux[j] < aux[i] -> arr[k] = aux[j++]
            else -> arr[k] = aux[i++]
        }
    }
}
