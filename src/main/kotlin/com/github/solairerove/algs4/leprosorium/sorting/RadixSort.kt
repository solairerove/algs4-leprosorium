package com.github.solairerove.algs4.leprosorium.sorting

import kotlin.math.pow

fun main() {
    val arr = mutableListOf(
        634, 472, 977, 756, 770, 966, 993, 191, 52, 49, 475, 564, 491,
        722, 284, 45, 614, 273, 332, 744, 629, 304, 822, 548, 864, 45,
        971, 352, 3, 687
    )

    radixSort(arr)

    print(arr)
}

private fun radixSort(arr: MutableList<Int>) {
    // find max
    var max = arr[0]
    arr.forEach { if (it > max) max = it }

    var digit = 0
    while (max / 10.0.pow(digit).toInt() > 0) {
        countSort(arr, digit++)
    }
}

private fun countSort(arr: MutableList<Int>, digit: Int) {
    // init count with zeros
    val count = MutableList(10) { 0 }

    // count
    val digitColumn = 10.0.pow(digit).toInt()
    for (el in arr) {
        val countIdx = (el / digitColumn) % 10
        count[countIdx]++
    }

    // cumulate sum
    for (i in 1 until 10) {
        count[i] += count[i - 1]
    }

    val output = MutableList(arr.size) { 0 }
    for (i in arr.size - 1 downTo 0) {
        val cntIdx = (arr[i] / digitColumn) % 10
        count[cntIdx]--
        val outputIdx = count[cntIdx]
        output[outputIdx] = arr[i]
//        output[count[arr[i]] - 1] = arr[i]
//        count[arr[i]]--
    }

    arr.forEachIndexed { i, _ -> arr[i] = output[i] }
}