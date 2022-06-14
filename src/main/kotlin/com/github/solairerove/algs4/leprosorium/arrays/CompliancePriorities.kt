package com.github.solairerove.algs4.leprosorium.arrays

/*
    https://leetcode.com/discuss/interview-question/1362915/amazon-hackerrank-question-priority-assignment
 */
fun main() {
    reassignedPriorities(arrayOf(1, 4, 8, 4)).forEach { print("$it ") }// [1, 2, 3, 2]
}

// O(1) time | O(1) space
private fun reassignedPriorities(priorities: Array<Int>): Array<Int> {
    var priority = 1
    val cnt = IntArray(100) { 0 }
    priorities.forEach { cnt[it] = 1 }
    cnt.forEachIndexed { idx, el -> if (el > 0) cnt[idx] = priority++ }
    priorities.forEachIndexed { idx, el -> priorities[idx] = cnt[el] }
    return priorities
}

// O(n * log(n)) time | O(n) space
private fun reassignedPrioritiesHS(priorities: Array<Int>): Array<Int> {
    var counter = 1
    val numberToMinimum = priorities.toSortedSet().associateWith { counter++ }
    return priorities.map { numberToMinimum[it]!! }.toTypedArray()
}
