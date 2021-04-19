package com.github.solairerove.algs4.leprosorium.searching

fun main() {
    val nums = listOf(5, 7, 7, 8, 8, 10)
    val target = 8

    print(searchRange(nums, target)) // [3,4]
}

// O(log(n)) time | O(1) space
private fun searchRange(arr: List<Int>, target: Int): Pair<Int, Int> {
    return Pair(findFirstIndex(arr, target), findLastIndex(arr, target))
}

private fun findFirstIndex(arr: List<Int>, target: Int): Int {
    var idx = -1
    var low = 0
    var high = arr.size - 1

    while (low <= high) {
        val mid = low + (high - low) / 2

        when {
            arr[mid] >= target -> high = mid - 1
            else -> low = mid + 1
        }

        if (arr[mid] == target) idx = mid
    }

    return idx
}

private fun findLastIndex(arr: List<Int>, target: Int): Int {
    var idx = -1
    var low = 0
    var high = arr.size - 1

    while (low <= high) {
        val mid = low + (high - low) / 2

        when {
            arr[mid] <= target -> low = mid + 1
            else -> high = mid - 1
        }

        if (arr[mid] == target) idx = mid
    }

    return idx
}
