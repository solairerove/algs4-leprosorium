package com.github.solairerove.algs4.leprosorium.sorting

fun main() {
    val arr = mutableListOf(1, 2, 3, 3, 2, 1)
    sortColors(arr, listOf(3, 2, 1))
    print(arr) // 3 3 2 2 1 1
}

// O(n) time | O(1) space
private fun sortColors(arr: MutableList<Int>, colors: List<Int>) {
    var lt = 0
    var i = 0
    var gt = arr.size - 1

    while (i <= gt) {
        when (arr[i]) {
            colors[0] -> swap(arr, i++, lt++)
            colors[1] -> i++
            else -> swap(arr, i, gt--)
        }
    }
}

private fun swap(arr: MutableList<Int>, i: Int, j: Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}
