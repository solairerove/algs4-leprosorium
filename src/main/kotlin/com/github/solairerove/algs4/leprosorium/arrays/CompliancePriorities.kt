package com.github.solairerove.algs4.leprosorium.arrays

/*
    https://leetcode.com/discuss/interview-question/1362915/amazon-hackerrank-question-priority-assignment
 */
fun main() {
    reassignedPriorities(arrayOf(1, 4, 8, 4)).forEach { print("$it ") }// [1, 2, 3, 2]
}

// O(n) time | O(n) space
private fun reassignedPriorities(priorities: Array<Int>): Array<Int> {
    var priority = 1
    val cnt = IntArray(100) { 0 }
    priorities.forEach { cnt[it]++ }
    for (i in cnt.indices) if (cnt[i] > 0) cnt[i] = priority++
    for (i in priorities.indices) priorities[i] = cnt[priorities[i]]

    return priorities
}

// O(n) time | O(n) space
private fun reassignedPrioritiesHS(priorities: Array<Int>): Array<Int> {
    var counter = 1
    val numberToMinimum = priorities.toSortedSet().associateWith { counter++ }
    return priorities.map { numberToMinimum[it]!! }.toTypedArray()
}
