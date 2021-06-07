package com.github.solairerove.algs4.leprosorium.recursion

fun main() {
    print(powerset(listOf(1, 2))) // [[], [1], [2], [1, 2]]
}

// O(n*2ˆn) time | O(n*2ˆn) space
private fun powerset(arr: List<Int>): List<List<Int>> {
    val sets = mutableListOf(listOf<Int>())
    for (el in arr) {
        for (i in 0 until sets.size) {
            val curr = sets[i].toMutableList()
            curr.add(el)
            sets.add(curr)
        }
    }
    return sets
}
