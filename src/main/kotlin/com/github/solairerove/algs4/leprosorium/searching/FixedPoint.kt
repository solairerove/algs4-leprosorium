package com.github.solairerove.algs4.leprosorium.searching

fun main() {
    val nums = listOf(-10, -5, 2, 3, 7)

    print(searchFixedPoint(nums)) // 2
}

// O(log(n)) time | O(1) space
private fun searchFixedPoint(arr: List<Int>): Int {
    var low = 0
    var high = arr.size - 1

    while (low <= high) {
        val mid = low + (high - low) / 2

        when {
            arr[mid] < mid -> low = mid + 1
            arr[mid] == mid && mid == 0 -> return mid
            arr[mid] == mid && arr[mid - 1] < mid - 1 -> return mid
            else -> high = mid - 1
        }
    }

    return -1
}
