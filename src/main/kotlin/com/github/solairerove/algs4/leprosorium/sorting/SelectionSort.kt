package com.github.solairerove.algs4.leprosorium.sorting

fun main() {
    val items = mutableListOf(5, 6, 4, 3, 10, 9, 5, 6, 7)
    print("items: $items \n")
    selectionSort(items)
    print("items: $items \n")
}

// O(n^2) time | O(1) space
private fun selectionSort(arr: MutableList<Int>) {
    val n = arr.size

    for (i in 0 until n) {
        var min = i

        for (j in (i + 1) until n) {
            if (arr[j] < arr[min]) {
                min = j
            }
        }

        swap(arr, i, min)
    }
}

private fun swap(arr: MutableList<Int>, i: Int, j: Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}
