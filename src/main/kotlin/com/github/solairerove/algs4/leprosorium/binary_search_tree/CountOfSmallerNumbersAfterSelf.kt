package com.github.solairerove.algs4.leprosorium.binary_search_tree

import java.util.*

fun main() {
    println(countSmallerNaiveSquared(intArrayOf(5, 2, 6, 1))) // [2, 1, 1, 0]
    println(countSmallerBST(listOf(5, 2, 6, 1))) // [2, 1, 1, 0]
    println(countSmaller(intArrayOf(5, 2, 6, 1))) // [2, 1, 1, 0]
}

private data class ValueWithIdx(val value: Int, val originalIdx: Int)

// O(log(n)) time | O(n) space
private fun countSmaller(nums: IntArray): List<Int> {
    if (nums.isEmpty()) return emptyList()
    val n = nums.size

    val arr = Array(n) { ValueWithIdx(0, 0) }
    for (i in 0 until n) arr[i] = ValueWithIdx(nums[i], i)

    val res = IntArray(n)
    mergeSortAndCount(arr, res, 0, n - 1)

    return res.toList()
}

private fun mergeSortAndCount(arr: Array<ValueWithIdx>, aux: IntArray, low: Int, high: Int) {
    if (low >= high) return

    val mid = low + (high - low) / 2

    mergeSortAndCount(arr, aux, low, mid)
    mergeSortAndCount(arr, aux, mid + 1, high)
    mergeAndCount(arr, aux, low, mid, high)
}

private fun mergeAndCount(arr: Array<ValueWithIdx>, aux: IntArray, low: Int, mid: Int, high: Int) {
    var i = low
    var j = mid + 1
    val merged = LinkedList<ValueWithIdx>()
    var numElementRightArrayLessThanLeftArray = 0
    while (i < mid + 1 && j <= high) {
        if (arr[i].value > arr[j].value) {
            ++numElementRightArrayLessThanLeftArray
            merged.add(arr[j])
            ++j
        } else {
            aux[arr[i].originalIdx] += numElementRightArrayLessThanLeftArray
            merged.add(arr[i])
            ++i
        }
    }

    while (i < mid + 1) {
        aux[arr[i].originalIdx] += numElementRightArrayLessThanLeftArray
        merged.add(arr[i])
        ++i
    }

    while (j <= high) {
        merged.add(arr[j])
        ++j
    }

    var pos = low
    for (m in merged) {
        arr[pos] = m
        ++pos
    }
}

// O(nˆ2) time | O(n) space
private fun countSmallerNaiveSquared(arr: IntArray): List<Int> {
    val counts = mutableListOf<Int>()
    for (i in arr.indices) {
        var counter = 0
        for (j in i + 1 until arr.size) {
            if (arr[j] < arr[i]) counter++
        }
        counts.add(counter)
    }
    return counts
}

// O(log(n)) time | O(n) space
// O(nˆ2) time | O(n) space worst
private fun countSmallerBST(arr: List<Int>): List<Int> {
    if (arr.isEmpty()) return listOf()

    val counts = arr.toMutableList()
    val bst = BST()
    for (i in arr.size - 1 downTo 0) {
        bst.put(arr[i], counts, i, 0)
    }

    return counts
}

private class BST {
    private var root: Node? = null

    inner class Node(var value: Int) {
        var right: Node? = null
        var left: Node? = null
        var segmentLeftCount = 0
    }

    fun put(value: Int, arr: MutableList<Int>, idx: Int, preSum: Int) {
        root = put(root, value, arr, idx, preSum)
    }

    private fun put(root: Node?, value: Int, arr: MutableList<Int>, idx: Int, preSum: Int): Node {
        var x = root

        if (x == null) {
            arr[idx] = preSum
            x = Node(value = value)
        } else if (value >= x.value) {
            val newPreSum = preSum + x.segmentLeftCount + if (value > x.value) 1 else 0
            x.right = put(x.right, value, arr, idx, newPreSum)
        } else {
            x.segmentLeftCount++
            x.left = put(x.left, value, arr, idx, preSum)
        }

        return x
    }
}
