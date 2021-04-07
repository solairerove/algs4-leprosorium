package com.github.solairerove.algs4.leprosorium.searching

fun main() {
    val items = listOf(5, 6, 4, 3, 10, 9, 5, 6, 7)
    print("items: $items \n")

    val sorted = items.sorted()
    print("items: $sorted \n")
    print("trying to find 10, index: ${biSectRight(sorted, 10)} \n") // 9
}

private fun biSectRight(arr: List<Int>, target: Int, lo: Int = 0, hi: Int = arr.size): Int {
    val n = arr.size
    if (n == 0) return 0

    var low = lo
    var high = hi

    if (target < arr[low]) return low
    if (target > arr[high - 1]) return high

    while (true) {
        if (low + 1 == high) {
            return low + 1
        }

        val mid = low + (high - low) / 2

        when {
            target < arr[mid] -> high = mid
            else -> low = mid
        }
    }
}
