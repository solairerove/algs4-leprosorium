package com.github.solairerove.algs4.leprosorium.sorting

fun main() {
    val items = mutableListOf(5, 6, 4, 3, 10, 9, 5, 6, 7)
    print("items: $items \n")
    countSort(items)
    print("items: $items \n")
}

// O(n + m) time | O(n) space
private fun countSort(arr: MutableList<Int>) {
    val n = arr.size

    // find max
    var max = arr[0]
    arr.forEach { if (it > max) max = it }

    // init count with zeros
    val count = MutableList(max + 1) { 0 }

    // count
    arr.forEach { count[it]++ }

    // cumulate sum
    for (i in 1..max) {
        count[i] += count[i - 1]
    }

    val output = MutableList(n + 1) { 0 }
    for (i in n - 1 downTo 0) {
        output[count[arr[i]] - 1] = arr[i]
        count[arr[i]]--
    }

    arr.forEachIndexed { i, _ -> arr[i] = output[i] }
}
