package com.github.solairerove.algs4.leprosorium.stack

import kotlin.math.min

fun main() {
    val obj = MinStack()
    obj.push(1)
    obj.push(2)
    obj.push(3)
    obj.push(4)
    obj.pop()
    println(obj.top()) // 3
    println(obj.getMin()) // 1
}

class MinStack {
    private val minMaxStack = mutableListOf<Map<String, Int>>()
    private val stack = mutableListOf<Int>()

    // O(1) time | O(1) space
    fun push(number: Int) {
        val newMinMax = mutableMapOf("min" to number)
        if (minMaxStack.size > 0) {
            val lastMinMax = minMaxStack[minMaxStack.size - 1]
            newMinMax["min"] = min(lastMinMax["min"]!!, number)
        }
        minMaxStack.add(newMinMax)
        stack.add(number)
    }

    // O(1) time | O(1) space
    fun pop() {
        minMaxStack.removeAt(stack.size - 1)
        stack.removeAt(stack.size - 1)
    }

    // O(1) time | O(1) space
    fun top(): Int {
        return stack[stack.size - 1]
    }

    // O(1) time | O(1) space
    fun getMin(): Int {
        return minMaxStack[minMaxStack.size - 1]["min"]!!
    }
}
