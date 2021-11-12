package com.github.solairerove.algs4.leprosorium.binary_search_tree

import java.util.*

fun main() {
    println(countSmallerNaiveSquared(intArrayOf(5, 2, 6, 1))) // [2, 1, 1, 0]
    println(countSmallerBST(listOf(5, 2, 6, 1))) // [2, 1, 1, 0]
    println(countSmaller(intArrayOf(5, 2, 6, 1))) // [2, 1, 1, 0]
}

private data class ArrayValWithOrigIdx(val value: Int, val originalIdx: Int)

// O(log(n)) time | O(n) space
private fun countSmaller(arr: IntArray?): List<Int> {
    if (arr == null || arr.isEmpty()) return emptyList()
    val n = arr.size
    val res = IntArray(n)

    val newNums = Array<ArrayValWithOrigIdx>(n) { ArrayValWithOrigIdx(0, 0) }
    for (i in 0 until n) {
        newNums[i] = ArrayValWithOrigIdx(arr[i], i)
    }

    mergeSortAndCount(newNums, 0, n - 1, res)

    val resList = LinkedList<Int>()
    for (i in res) {
        resList.add(i)
    }

    return resList
}

private fun mergeSortAndCount(
    arr: Array<ArrayValWithOrigIdx>,
    low: Int,
    high: Int,
    res: IntArray
) {
    if (low >= high) return

    val mid = low + (high - low) / 2
    mergeSortAndCount(arr, low, mid, res)
    mergeSortAndCount(arr, mid + 1, high, res)

    var i = low
    var j = mid + 1
    val merged = LinkedList<ArrayValWithOrigIdx>()
    var numElementRightArrayLessThanLeftArray = 0
    while (i < mid + 1 && j <= high) {
        if (arr[i].value > arr[j].value) {
            ++numElementRightArrayLessThanLeftArray
            merged.add(arr[j])
            ++j
        } else {
            res[arr[i].originalIdx] += numElementRightArrayLessThanLeftArray
            merged.add(arr[i])
            ++i
        }
    }

    while (i < mid + 1) {
        res[arr[i].originalIdx] += numElementRightArrayLessThanLeftArray
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
