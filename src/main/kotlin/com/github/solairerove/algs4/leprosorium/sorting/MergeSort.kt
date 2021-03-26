package com.github.solairerove.algs4.leprosorium.sorting

fun main() {
    val items = mutableListOf(5, 6, 4, 3, 10, 9, 5, 6, 7)
    print("items: $items \n")
    mergeSort(items)
    print("items: $items \n")
}

private fun mergeSort(arr: MutableList<Int>) {
    val n = arr.size

    val aux = MutableList(n) { i -> i }
    mergeSort(arr, aux, 0, n - 1)
}

private fun mergeSort(arr: MutableList<Int>, aux: MutableList<Int>, low: Int, high: Int) {
    if (high <= low) {
        return
    }

    val mid = low + (high - low) / 2

    mergeSort(arr, aux, low, mid)
    mergeSort(arr, aux, mid + 1, high)
    merge(arr, aux, low, mid, high)
}

private fun merge(arr: MutableList<Int>, aux: MutableList<Int>, low: Int, mid: Int, high: Int) {
    var i = low
    var j = mid + 1

    for (k in low..high) {
        aux[k] = arr[k]
    }

    for (k in low..high) {
        when {
            i > mid -> arr[k] = aux[j++]
            j > high -> arr[k] = aux[i++]
            aux[j] < aux[i] -> arr[k] = aux[j++]
            else -> arr[k] = aux[i++]
        }
    }
}
