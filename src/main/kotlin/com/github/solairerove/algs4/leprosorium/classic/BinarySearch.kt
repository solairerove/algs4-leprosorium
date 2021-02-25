package com.github.solairerove.algs4.leprosorium.classic

fun main() {
    val items = listOf(5, 6, 4, 3, 10, 9, 5, 6, 7)
    print("items: $items \n")

    val sorted = items.sorted()
    print("items: $items \n")
    print("trying to fine 10, index: ${binarySearch(sorted, 10)} \n") // 8
    print("trying to fine 10, index: ${binarySearch(sorted, 6)} \n") // 4
    print("trying to fine 10, index: ${binarySearch(sorted, 0)} \n") // -1
}

private fun binarySearch(items: List<Int>, item: Int): Int {
    var low = 0
    var high = items.size - 1

    while (low <= high) {
        val mid = (low + high) / 2
        val guess = items[mid]

        when {
            guess == item -> return mid
            guess > item -> high = mid - 1
            else -> low = mid + 1
        }
    }

    return -1
}