package com.github.solairerove.algs4.leprosorium.sorting

fun main() {
    val items = mutableListOf(5, 6, 4, 3, 10, 9, 5, 6, 7)
    print("items: $items \n")
    quickSort(items)
    print("items: $items \n")
}

// O(nlog(n)) time | O(log(n)) space
private fun quickSort(arr: MutableList<Int>, low: Int = 0, high: Int = arr.size - 1) {
    if (high <= low) return
    var lt = low
    var gt = high
    val v = arr[low]
    var i = low + 1

    while (i <= gt) {
        when {
            arr[i] < v -> swap(arr, lt++, i++)
            arr[i] > v -> swap(arr, i, gt--)
            else -> i++
        }
    }

    quickSort(arr, low, lt - 1)
    quickSort(arr, gt + 1, high)
}

private fun swap(arr: MutableList<Int>, i: Int, j: Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}
