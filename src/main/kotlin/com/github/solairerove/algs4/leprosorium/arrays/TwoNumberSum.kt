package com.github.solairerove.algs4.leprosorium.arrays

fun main() {
    val arr = mutableListOf(-9, -7, -6, -4, 0, 2, 3, 4, 5, 7)
    println(twoNumberSum(arr, -1)) // [-6, 5]
    print(twoNumberSumHS(arr, -1)) // [3, -4]
}

// O(n) time | O(1) space
private fun twoNumberSum(arr: MutableList<Int>, targetSum: Int): List<Int> {
    var low = 0
    var high = arr.size - 1

    while (low < high) {
        val potentialSum = arr[low] + arr[high]

        when {
            potentialSum < targetSum -> low++
            potentialSum > targetSum -> high--
            else -> return listOf(arr[low], arr[high])
        }
    }

    return listOf()
}


// O(n) time | O(n) space
private fun twoNumberSumHS(arr: MutableList<Int>, targetSum: Int): List<Int> {
    val numbers = hashSetOf<Int>()

    for (a in arr) {
        val potential = targetSum - a
        if (numbers.contains(potential)) {
            return listOf(a, potential)
        } else {
            numbers.add(a)
        }
    }

    return listOf()
}
