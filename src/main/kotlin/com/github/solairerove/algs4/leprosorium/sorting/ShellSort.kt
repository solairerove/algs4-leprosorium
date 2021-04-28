package com.github.solairerove.algs4.leprosorium.sorting

fun main() {
    val items = mutableListOf(5, 6, 4, 3, 10, 9, 5, 6, 7)
    print("items: $items \n")
    shellSort(items)
    print("items: $items \n")
}

// O(nlog(n)) time | O(1) space
private fun shellSort(arr: MutableList<Int>) {
    val n = arr.size

    // 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093,
    var h = 1
    while (h < n / 3) h = h * 3 + 1

    while (h >= 1) {
        // h-sort
        for (i in h until n) {
            for (j in i downTo h step h) {
                if (arr[j] < arr[j - h]) {
                    swap(arr, j, j - h)
                }
            }
        }
        h /= 3
    }
}

private fun swap(arr: MutableList<Int>, i: Int, j: Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}
