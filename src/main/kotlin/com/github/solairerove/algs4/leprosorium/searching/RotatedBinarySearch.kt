package com.github.solairerove.algs4.leprosorium.searching

fun main() {
    val items = listOf(5, 6, 6, 7, 9, 10, 3, 4, 5)
    print("items: $items \n")
    print(rotatedBinarySearch(items, 7)) // 3
}

// O(log(n)) time | O(1) space
private fun rotatedBinarySearch(arr: List<Int>, k: Int): Int {
    var low = 0
    var high = arr.size - 1

    while (low <= high) {
        val mid = low + (high - low) / 2

        if (arr[mid] == k) return mid
        else if (arr[low] <= k) {
            if (k < arr[mid] && k >= arr[low]) high = mid - 1
            else low = mid + 1
        } else {
            if (k > arr[mid] && k <= arr[high]) low = mid + 1
            else high = mid - 1
        }
    }

    return -1
}
