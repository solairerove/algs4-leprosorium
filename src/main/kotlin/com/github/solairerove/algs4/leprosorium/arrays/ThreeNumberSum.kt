package com.github.solairerove.algs4.leprosorium.arrays

fun main() {
    val arr = mutableListOf(-9, -7, -6, -4, 0, 2, 3, 4, 5, 7)
    print(threeNumberSum(arr, -1)) // [[-9, 3, 5], [-7, 2, 4], [-6, 0, 5], [-6, 2, 3], [-4, 0, 3]]
}

// O(n^2) time | O(n) space
private fun threeNumberSum(arr: MutableList<Int>, target: Int): List<List<Int>> {
    arr.sort()

    val triplets = mutableListOf<MutableList<Int>>()

    for (i in 0 until arr.size - 2) {
        var low = i + 1
        var high = arr.size - 1

        while (low < high) {
            val curr = arr[i] + arr[low] + arr[high]

            when {
                curr == target -> {
                    triplets.add(mutableListOf(arr[i], arr[low], arr[high]))
                    low++
                    high--
                }
                curr < target -> low++
                else -> high--
            }
        }
    }

    return triplets
}
