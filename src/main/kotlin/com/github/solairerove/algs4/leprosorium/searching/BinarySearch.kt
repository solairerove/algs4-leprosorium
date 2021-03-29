package com.github.solairerove.algs4.leprosorium.searching

fun main() {
    val items = listOf(5, 6, 4, 3, 10, 9, 5, 6, 7)
    print("items: $items \n")

    val sorted = items.sorted()
    print("items: $items \n")
    print("trying to find 10, index: ${binarySearch(sorted, 10)} - ${rank(sorted, 10)} \n") // 8
    print("trying to find 10, index: ${binarySearch(sorted, 6)} - ${rank(sorted, 6)} \n") // 4
    print("trying to find 10, index: ${binarySearch(sorted, 0)} - ${rank(sorted, 0)} \n") // -1
}

// O(log(n)) time | O(1) space
private fun binarySearch(items: List<Int>, target: Int): Int {
    var low = 0
    var high = items.size - 1

    while (low <= high) {
        val mid = low + (high - low) / 2

        when {
            items[mid] < target -> low = mid + 1
            items[mid] > target -> high = mid - 1
            else -> return mid
        }
    }

    return -1
}

// O(log(n)) time | O(log(n)) space cause of stack call
private fun rank(items: List<Int>, item: Int): Int {
    return rank(items, item, 0, items.size)
}

private fun rank(items: List<Int>, item: Int, low: Int, high: Int): Int {
    if (low > high) return -1

    val mid = (low + high) / 2
    val guess = items[mid]

    return when {
        guess == item -> mid
        guess > item -> rank(items, item, low, mid - 1)
        else -> rank(items, item, mid + 1, high)
    }
}
