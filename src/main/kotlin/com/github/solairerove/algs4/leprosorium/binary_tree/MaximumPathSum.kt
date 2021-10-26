package com.github.solairerove.algs4.leprosorium.binary_tree

import kotlin.math.max

fun main() {
    println(maxPathSum(node = getValidTree())) // 58 (15 + 7 + 3 + 8 + 25)
}

// O(n) space | O(log(n))
private fun maxPathSum(node: TreeNode?): Int {
    val (_, maxSumArray) = findMaxSum(node)
    return maxSumArray
}

private fun findMaxSum(node: TreeNode?): List<Int> {
    if (node == null) return listOf(0, Int.MIN_VALUE)

    val (left, leftPathSum) = findMaxSum(node.left)
    val (right, rightPathSum) = findMaxSum(node.right)
    val maxLeafSum = max(left, right)

    val maxBranch = max(maxLeafSum + node.value, node.value)
    val maxRoot = max(left + node.value + right, maxBranch)
    val maxPathSum = listOf(leftPathSum, rightPathSum, maxRoot).max()!!

    return listOf(maxBranch, maxPathSum)
}
