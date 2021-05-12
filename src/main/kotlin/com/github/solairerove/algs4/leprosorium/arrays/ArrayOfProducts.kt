package com.github.solairerove.algs4.leprosorium.arrays

fun main() {
    print(arrayOfProducts(listOf(1, 2, 3, 4, 6))) // [144, 72, 48, 36, 24]
}

// O(n) time | O(n) space
private fun arrayOfProducts(arr: List<Int>): List<Int> {
    val n = arr.size
    val products = MutableList(n) { 1 }

    var low = 1
    for (i in 0 until n) {
        products[i] = low
        low *= arr[i]
    }

    var high = 1
    for (i in n - 1 downTo 0) {
        products[i] *= high
        high *= arr[i]
    }

    return products
}
