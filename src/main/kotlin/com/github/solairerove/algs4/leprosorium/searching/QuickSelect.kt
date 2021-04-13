package com.github.solairerove.algs4.leprosorium.searching

fun main() {
    val arr = mutableListOf(4, 1, 2, 6, 3, 9, 10, 5, 7, 8)
    print(quickSelect(arr, 3)) // 4
}

// O(n) time | O(1) space
private fun quickSelect(arr: MutableList<Int>, k: Int): Int {
    var low = 0
    var high = arr.size - 1

    while (low < high) {
        val j = partition(arr, low, high)

        when {
            j < k -> low = j + 1
            j > k -> high = j - 1
            else -> return arr[j]
        }
    }

    return arr[low]
}

private fun partition(arr: MutableList<Int>, low: Int, high: Int): Int {
    var i = low
    var j = high + 1
    val v = arr[low]

    while (true) {
        while (arr[++i] < v) if (i == high) break
        while (v < arr[--j]) if (j == low) break
        if (j <= i) break
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
