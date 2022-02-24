package com.github.solairerove.algs4.leprosorium.stack

fun main() {
    println(sort(mutableListOf(1, 5, 3, 2, 4))) // 1, 2, 3, 4, 5
}

// O(n ^ 2) time | O(n) space
private fun sort(stack: MutableList<Int>): MutableList<Int> {
    if (stack.size == 0) return stack

    val top = stack.removeAt(stack.size - 1)

    sort(stack)

    insert(stack, top)

    return stack
}

private fun insert(stack: MutableList<Int>, num: Int) {
    if (stack.size == 0 || stack[stack.size - 1] <= num) {
        stack.add(num)
        return
    }

    val top = stack.removeAt(stack.size - 1)

    insert(stack, num)

    stack.add(top)
}
