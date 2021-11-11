package com.github.solairerove.algs4.leprosorium.binary_search_tree

fun main() {
    println(countSmallerNaiveSquared(intArrayOf(5, 2, 6, 1))) // [2, 1, 1, 0]
    println(countSmallerBST(listOf(5, 2, 6, 1))) // [2, 1, 1, 0]
}

// O(nˆ2) time | O(n) space
fun countSmallerNaiveSquared(arr: IntArray): List<Int> {
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
fun countSmallerBST(arr: List<Int>): List<Int> {
    if (arr.isEmpty()) return listOf()

    val counts = arr.toMutableList()
    val bst = BST()
    for (i in arr.size - 1 downTo 0) {
        bst.put(arr[i], counts, i, 0)
    }

    return counts
}

class BST {
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
